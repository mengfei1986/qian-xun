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
import qian.xun.utils.TimeUtil;
import qian.xun.web.model.DictItemModel;
import qian.xun.web.model.DictModel;
import qian.xun.web.response.AjaxResult;
import qian.xun.web.response.DataResult;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dictItem")
public class DictItemController {
    Logger logger = Logger.getLogger("DictItemController");
    @Resource
    SysDictItemService dictItemService;
    @Resource
    SysDictService dictService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public AjaxResult<DictItemModel.DictItemView> pageList(SysDictItemRequest.PageList req) {
        logger.info("SysDictItemRequest.PageList:"+JSON.toJSONString(req));
        PageResult<SysDictItem> pageResult = dictItemService.pageList(req);

        DataResult<DictItemModel.DictItemView> data = new DataResult<>();
        if(Objects.nonNull(pageResult) && !CollectionUtils.isEmpty(pageResult.getItems())){
            Map<String,String> dictMap = dictMap(pageResult.getItems().stream()
                    .filter(e->{return !StringUtils.isEmpty(e.getDictCode());
                    })
                    .map(e->e.getDictCode())
                    .collect(Collectors.toList()));
            data.setItems( pageResult.getItems().stream().map(e->{
                DictItemModel.DictItemView view = new DictItemModel.DictItemView();
                  view.setId(e.getId());
                  view.setDictCode(e.getDictCode());
                  view.setDictName(dictMap.getOrDefault(e.getDictCode() , ""));
                  view.setItemKey(e.getItemKey());
                  view.setItemVal(e.getItemVal());
                  view.setStatus(e.getStatus());
                  view.setCreateBy(e.getCreateBy());
                  view.setCreateTime(e.getCreateTime());
                  view.setUpdateBy(e.getUpdateBy());
                  view.setUpdateTime(e.getUpdateTime());
                  return view;
              }).collect(Collectors.toList()));
            data.setTotal(pageResult.getTotal());
        }
        return AjaxResult.success(data);
    }
    @RequestMapping(value = "validateItemKey", method = RequestMethod.GET)
    public AjaxResult<Boolean> validateCode(String dictCode ,String itemKey , int id) {
        SysDictItem dictItem = getDictItem(dictCode , itemKey);
        if(Objects.isNull(dictItem) || (id > 0 && dictItem.getId() == id)){
            return AjaxResult.success(true);
        }else{
            return AjaxResult.success(false);
        }
    }
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public AjaxResult<SysDict> create(@RequestBody DictItemModel.DictItemView dictItem) {
        logger.info("create="+JSON.toJSONString(dictItem));
        return AjaxResult.success(save(dictItem));
    }
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public AjaxResult<SysDict> update(@RequestBody DictItemModel.DictItemView dictItem) {
        logger.info("update="+JSON.toJSONString(dictItem));
        return AjaxResult.success(edit(dictItem));
    }
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public AjaxResult<Boolean> delete(int id) {
        logger.info("delete="+id);
        return AjaxResult.success(dictItemService.delete(id));
    }
    private SysDictItem edit(DictItemModel.DictItemView dictItem){
        SysDictItem sysDictItem = new SysDictItem();
        sysDictItem.setId(dictItem.getId());
        sysDictItem.setDictCode(dictItem.getDictCode());
        sysDictItem.setDictName(dictName(dictItem.getDictCode()));
        sysDictItem.setItemKey(dictItem.getItemKey());
        sysDictItem.setItemVal(dictItem.getItemVal());
        sysDictItem.setStatus(dictItem.getStatus());
        sysDictItem.setCreateBy(dictItem.getCreateBy());
        sysDictItem.setCreateTime(TimeUtil.localDateTImeToString(LocalDateTime.now()));
        sysDictItem.setUpdateBy(dictItem.getUpdateBy());
        sysDictItem.setUpdateTime(TimeUtil.localDateTImeToString(LocalDateTime.now()));
        if(!dictItemService.update(sysDictItem)){
            sysDictItem.setId(-1);
        }
        return sysDictItem;
    }
    private SysDictItem save(DictItemModel.DictItemView dictItem){
        SysDictItem sysDictItem = new SysDictItem();
        sysDictItem.setDictCode(dictItem.getDictCode());
        sysDictItem.setDictName(dictName(dictItem.getDictCode()));
        sysDictItem.setItemKey(dictItem.getItemKey());
        sysDictItem.setItemVal(dictItem.getItemVal());
        sysDictItem.setStatus(dictItem.getStatus());
        sysDictItem.setCreateBy(dictItem.getCreateBy());
        sysDictItem.setCreateTime(TimeUtil.localDateTImeToString(LocalDateTime.now()));
        sysDictItem.setUpdateBy(dictItem.getUpdateBy());
        sysDictItem.setUpdateTime(TimeUtil.localDateTImeToString(LocalDateTime.now()));
        sysDictItem.setId(dictItemService.insert(sysDictItem));
        return sysDictItem;
    }
    private String dictName(String dictCode){
        Map<String,String> dictMap = dictMap(Arrays.asList(dictCode));
        if(Objects.isNull(dictMap) || dictMap.size()<=0){
            return "";
        }
        return dictMap.get(dictCode);
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
    private SysDictItem getDictItem(String dictCode , String itemKey){
        SysDictItemRequest.PageList req = new SysDictItemRequest.PageList();
        req.setItemKey(itemKey);
        req.setDictCode(dictCode);
        PageResult<SysDictItem>  pageResult = dictItemService.pageList(req);
        if(Objects.isNull(pageResult) || CollectionUtils.isEmpty(pageResult.getItems())){
            return null;
        }
        return pageResult.getItems().get(0);
    }
}
