package qian.xun.facade.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import qian.xun.facade.dao.SysDictDao;
import qian.xun.facade.po.SysDict;
import qian.xun.facade.query.SysDictQuery;
import qian.xun.facade.request.SysDictRequest;
import qian.xun.facade.service.SysDictService;
import qian.xun.utils.TimeUtil;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

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
