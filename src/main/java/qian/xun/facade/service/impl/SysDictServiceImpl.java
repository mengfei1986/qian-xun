package qian.xun.facade.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import qian.xun.facade.dao.SysDictDao;
import qian.xun.facade.po.SysDict;
import qian.xun.facade.query.SysDictQuery;
import qian.xun.facade.request.SysDictRequest;
import qian.xun.facade.response.PageResult;
import qian.xun.facade.service.SysDictService;
import qian.xun.utils.TimeUtil;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service("sysDictService")
@Transactional(rollbackFor = Throwable.class)
public class SysDictServiceImpl  implements SysDictService {
    @Resource
    private SysDictDao sysDictDao;

    @Override
    public List<SysDict> queryList(SysDictRequest.QueryList query) {
        return sysDictDao.queryList(SysDictQuery.builder().dictCodes(query.getDictCodes()).build());
    }

    @Override
    public PageResult<SysDict> pageList(SysDictRequest.PageList req) {
        if(Objects.isNull(req.getLimit()) || req.getLimit()<=0){
            req.setLimit(10);
        }
        if(Objects.isNull(req.getPage()) || req.getPage()<=0){
            req.setPage(1);
        }
        SysDictQuery query = SysDictQuery.builder()
                .dictCodes(req.getDictCodes())
                .dictCode(req.getDictCode())
                .dictName(req.getDictName())
                .status(req.getStatus())
                .limit(req.getLimit())
                .offset((req.getPage()-1)*req.getLimit())
                .build();
        PageResult<SysDict> result = new PageResult<>();
        int count = sysDictDao.count(query);
        if(count>0){
            result.setItems(sysDictDao.pageList(query));
        }
        result.setTotal(count);
        return result;
    }


    @Override
    public int insert(SysDict sysDict) {
        sysDict.setCreateTime(TimeUtil.localDateTImeToString(null));
        sysDict.setUpdateBy(sysDict.getCreateBy());
        sysDict.setUpdateTime(TimeUtil.localDateTImeToString(null));
        sysDictDao.insert(sysDict);
        return sysDict.getId();
    }

    @Override
    public boolean update(SysDict sysDict) {
        sysDict.setUpdateTime(TimeUtil.localDateTImeToString(null));
        return sysDictDao.update(sysDict);
    }

    @Override
    public boolean delete(int id) {
        return sysDictDao.delete(id);
    }
}
