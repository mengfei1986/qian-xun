package qian.xun.web.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import qian.xun.common.constant.Constant;
import qian.xun.common.constant.StatusEnum;
import qian.xun.facade.po.SysDict;
import qian.xun.facade.request.SysDictRequest;
import qian.xun.facade.response.PageResult;
import qian.xun.facade.service.SysDictService;
import qian.xun.utils.TimeUtil;
import qian.xun.web.model.DictModel;
import qian.xun.web.response.AjaxResult;
import qian.xun.web.response.DataResult;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dict")
public class DictController {
    Logger logger = Logger.getLogger("DictItemController");
    @Resource
    SysDictService dictService;
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public AjaxResult<DictModel.DictView> pageList(SysDictRequest.PageList req) {
        logger.info("SysDictItemRequest.PageList:"+JSON.toJSONString(req));
        PageResult<SysDict> pageResult = dictService.pageList(req);

        DataResult<DictModel.DictView> data = new DataResult<>();
        if(Objects.nonNull(pageResult) && !CollectionUtils.isEmpty(pageResult.getItems())){
            data.setItems( pageResult.getItems().stream().map(e->{
                DictModel.DictView view = new DictModel.DictView();
                view.setId(e.getId());
                view.setDictCode(e.getDictCode());
                view.setDictName(e.getDictName());
                view.setRemark(e.getRemark());
                view.setStatus(e.getStatus());
                view.setUpdateBy(e.getUpdateBy());
                view.setUpdateTime(e.getUpdateTime());
                view.setCreateBy(e.getCreateBy());
                view.setCreateTime(e.getCreateTime());
                return view;
            }).collect(Collectors.toList()));
            data.setTotal(pageResult.getTotal());
        }
        return AjaxResult.success(data);
    }
    @RequestMapping(value = "/simple-list", method = RequestMethod.GET)
    public AjaxResult<DictModel.DictView> simpleList() {
        logger.info("SysDictItemRequest.simpleList:");
        SysDictRequest.QueryList query = new SysDictRequest.QueryList();
        query.setStatus(StatusEnum.NORMAL.value());
        List<SysDict> list = dictService.queryList(query);

        List<DictModel.SimpleDictView> datas = new ArrayList<>();
        datas.add(ofSimple("","全部"));
        Set<String> handled=new HashSet<>();
        if(Objects.nonNull(list) && !CollectionUtils.isEmpty(list)){
            for (SysDict sysDict : list) {
                if(!handled.contains(sysDict.getDictCode())){
                    datas.add(ofSimple(sysDict.getDictCode() , sysDict.getDictName()));
                    handled.add(sysDict.getDictCode());
                }
            }
        }
        return AjaxResult.success(datas);
    }
    @RequestMapping(value = "validateCode", method = RequestMethod.GET)
    public AjaxResult<Boolean> validateCode(String dictCode ,int id) {
        SysDict dict = getDict(dictCode);
        if(Objects.isNull(dict) || (id > 0 && dict.getId() == id)){
            return AjaxResult.success(true);
        }else{
            return AjaxResult.success(false);
        }
    }
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public AjaxResult<SysDict> create(@RequestBody DictModel.DictView dict) {
        logger.info("create="+JSON.toJSONString(dict));
        return AjaxResult.success(save(dict));
    }
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public AjaxResult<SysDict> update(@RequestBody DictModel.DictView dict) {
        logger.info("update="+JSON.toJSONString(dict));
        return AjaxResult.success(edit(dict));
    }
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public AjaxResult<Boolean> delete(int id) {
        logger.info("delete="+id);
        return AjaxResult.success(dictService.delete(id));
    }
    private DictModel.SimpleDictView ofSimple(String code , String name){
        DictModel.SimpleDictView simpleDictView = new DictModel.SimpleDictView();
        simpleDictView.setDictCode(code);
        simpleDictView.setDictName(name);
        return simpleDictView;
    }
    private SysDict edit(DictModel.DictView dict){
        SysDict sysDict = new SysDict();
        sysDict.setId(dict.getId());
        sysDict.setDictCode(dict.getDictCode());
        sysDict.setDictName(dict.getDictName());
        sysDict.setRemark(dict.getRemark());
        sysDict.setStatus(dict.getStatus());
        sysDict.setCreateBy(dict.getCreateBy());
        sysDict.setCreateTime(TimeUtil.localDateTImeToString(LocalDateTime.now()));
        sysDict.setUpdateBy(dict.getUpdateBy());
        sysDict.setUpdateTime(TimeUtil.localDateTImeToString(LocalDateTime.now()));
        if(!dictService.update(sysDict)){
            dict.setId(-1);
        }
        return sysDict;
    }
    private SysDict save(DictModel.DictView dict){
        SysDict sysDict = new SysDict();
        sysDict.setDictCode(dict.getDictCode());
        sysDict.setDictName(dict.getDictName());
        sysDict.setRemark(dict.getRemark());
        sysDict.setStatus(dict.getStatus());
        sysDict.setCreateBy(dict.getCreateBy());
        sysDict.setCreateTime(TimeUtil.localDateTImeToString(LocalDateTime.now()));
        sysDict.setUpdateBy(dict.getUpdateBy());
        sysDict.setUpdateTime(TimeUtil.localDateTImeToString(LocalDateTime.now()));
        sysDict.setId(dictService.insert(sysDict));
        return sysDict;
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
    private SysDict getDict(String dictCode){
        List<SysDict> dicts = dictList(Arrays.asList(dictCode));
        if(CollectionUtils.isEmpty(dicts)){
            return null;
        }
        return dicts.get(0);
    }
}
