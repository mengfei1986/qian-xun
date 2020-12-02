package qian.xun.facade.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import qian.xun.facade.po.SysDict;
import qian.xun.facade.query.SysDictItemQuery;
import qian.xun.facade.query.SysDictQuery;
import qian.xun.facade.request.SysDictRequest;

import java.util.List;

@Mapper
@Repository
public interface SysDictDao {
    public List<SysDict> queryList(SysDictQuery query);
    int insert(SysDict sysDict);
    boolean update(SysDict sysDict);
    boolean delete(int id);
}
