package qian.xun.facade.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import qian.xun.facade.po.SysDict;
import qian.xun.facade.po.SysDictItem;
import qian.xun.facade.query.SysDictItemQuery;

import java.util.List;

@Mapper
@Repository
public interface SysDictItemDao {
    List<SysDictItem> pageList(SysDictItemQuery query);
    int count(SysDictItemQuery query);
    int insert(SysDictItem item);
    boolean update(SysDictItem item);
    boolean delete(int id);
}
