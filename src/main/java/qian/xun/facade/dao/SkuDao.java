package qian.xun.facade.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import qian.xun.facade.po.Sku;
import qian.xun.facade.query.SkuQuery;

import java.util.List;

@Mapper
@Repository
public interface SkuDao {
    Sku get(SkuQuery query);
    List<Sku> findList(SkuQuery query);
    void create(Sku spu);
    void update(Sku spu);
}
