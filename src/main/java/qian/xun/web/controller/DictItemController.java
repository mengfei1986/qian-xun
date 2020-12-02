package qian.xun.web.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import qian.xun.facade.po.SysDict;
import qian.xun.facade.po.SysDictItem;
import qian.xun.facade.request.SysDictItemRequest;
import qian.xun.facade.request.SysDictRequest;
import qian.xun.facade.response.PageResult;
import qian.xun.facade.service.SysDictItemService;
import qian.xun.facade.service.SysDictService;
import qian.xun.web.model.DictModel;
import qian.xun.web.response.AjaxResult;
import qian.xun.web.response.DataResult;

import javax.annotation.Resource;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dict")
public class DictItemController {
    Logger logger = Logger.getLogger("DictItemController");
    @Resource
    SysDictItemService dictItemService;
    @Resource
    SysDictService dictService;
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public AjaxResult<DictModel.DictItemView> list() {
        List<SysDict> dictList = dictList(null);
        return AjaxResult.success(dictList);
    }
    @RequestMapping(value = "item/list", method = RequestMethod.GET)
    public AjaxResult<DictModel.DictItemView> pageList(SysDictItemRequest.PageList req) {
        logger.info("SysDictItemRequest.PageList:"+JSON.toJSONString(req));
        PageResult<SysDictItem> pageResult = dictItemService.pageList(req);

        DataResult<DictModel.DictItemView> data = new DataResult<>();
        if(Objects.nonNull(pageResult) && !CollectionUtils.isEmpty(pageResult.getItems())){
            Map<String,String> dictMap = dictMap(pageResult.getItems().stream()
                    .filter(e->{return !StringUtils.isEmpty(e.getDictCode());
                    })
                    .map(e->e.getDictCode())
                    .collect(Collectors.toList()));
            data.setItems( pageResult.getItems().stream().map(e->{
                DictModel.DictItemView view = new DictModel.DictItemView();
                  view.setId(e.getId());
                  view.setDictCode(e.getDictCode());
                  view.setDictName(dictMap.getOrDefault(e.getDictCode() , ""));
                  view.setItemKey(e.getItemKey());
                  view.setItemVal(e.getItemVal());
                  view.setStatus(e.getStatus());
                  return view;
              }).collect(Collectors.toList()));
            data.setTotal(pageResult.getTotal());
        }
        return AjaxResult.success(data);
    }

    private Map<String,String> dictMap(List<String> dictCodes){
        List<SysDict> dicts = dictList(dictCodes);
        if(CollectionUtils.isEmpty(dicts)){
            return Collections.emptyMap();
        }
        return dicts.stream().collect(Collectors.toMap(SysDict::getDictCode ,SysDict::getDictName));
    }
    private List<SysDict> dictList(List<String> dictCodes){
        SysDictRequest.QueryList req = new SysDictRequest.QueryList();
        req.setDictCodes(dictCodes);
        List<SysDict> dicts = dictService.queryList(req);
        if(Objects.isNull(dicts)){
            return Collections.emptyList();
        }
       return dicts;
    }
}
