package qian.xun.facade.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import qian.xun.facade.dao.SysDictDao;
import qian.xun.facade.dao.SysDictItemDao;
import qian.xun.facade.po.SysDict;
import qian.xun.facade.po.SysDictItem;
import qian.xun.facade.query.SysDictItemQuery;
import qian.xun.facade.request.SysDictItemRequest;
import qian.xun.facade.response.PageResult;
import qian.xun.facade.service.SysDictItemService;
import qian.xun.facade.service.SysDictService;
import qian.xun.utils.TimeUtil;

import javax.annotation.Resource;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service("sysDictItemService")
@Transactional(rollbackFor = Throwable.class)
public class SysDictItemServiceImpl implements SysDictItemService {
    @Resource
    private SysDictItemDao sysDictItemDao;


    @Override
    public PageResult<SysDictItem> pageList(SysDictItemRequest.PageList req) {
        if(Objects.isNull(req.getLimit()) || req.getLimit()<=0){
            req.setLimit(10);
        }
        if(Objects.isNull(req.getPage()) || req.getPage()<=0){
            req.setPage(1);
        }
        SysDictItemQuery query = SysDictItemQuery.builder()
                                            .dictCode(req.getDictCode())
                                            .status(req.getStatus())
                                            .itemKey(req.getItemKey())
                                            .limit(req.getLimit())
                                            .offset((req.getPage()-1)*req.getLimit())
                                            .build();
        PageResult<SysDictItem> result = new PageResult<>();
        int count = sysDictItemDao.count(query);
        if(count>0){
            result.setItems(sysDictItemDao.pageList(query));
        }
        result.setTotal(count);
        return result;
    }

    @Override
    public int insert(SysDictItem sysDict) {
        sysDict.setCreateTime(TimeUtil.localDateTImeToString(null));
        sysDict.setUpdateBy(sysDict.getCreateBy());
        sysDict.setUpdateTime(TimeUtil.localDateTImeToString(null));
        sysDictItemDao.insert(sysDict);
        return sysDict.getId();
    }

    @Override
    public boolean update(SysDictItem sysDict) {
        return sysDictItemDao.update(sysDict);
    }

    @Override
    public boolean delete(int id) {
        return sysDictItemDao.delete(id);
    }
}
