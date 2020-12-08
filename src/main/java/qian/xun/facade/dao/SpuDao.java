package qian.xun.facade.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import qian.xun.facade.po.Spu;
import qian.xun.facade.po.User;
import qian.xun.facade.query.SpuQuery;
import qian.xun.facade.query.SysDictItemQuery;

import java.util.List;

@Mapper
@Repository
public interface SpuDao {
    Spu get(SpuQuery query);
    List<Spu> pageList(SpuQuery query);
    int count(SysDictItemQuery query);
    void create(Spu spu);
    void update(Spu spu);
    void delete(int id);
}
