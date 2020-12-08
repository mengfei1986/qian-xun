package qian.xun;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import qian.xun.common.constant.StatusEnum;
import qian.xun.facade.po.SysDictItem;
import qian.xun.facade.request.SysDictItemRequest;
import qian.xun.facade.service.SysDictItemService;

public class SysDictItemTest extends AbstractTest {
    @Autowired
    private SysDictItemService service;
    //@Ignore("not ready yet")
    @Test
    public void pageList(){
        SysDictItemRequest.PageList query = new SysDictItemRequest.PageList();
        query.setPage(2);
        query.setLimit(2);
        printlnJson(service.pageList(query));
    }

    @Test
    public void create(){
        SysDictItem s = new SysDictItem();
        s.setItemKey("123");
        s.setDictCode("1");
        s.setItemVal("1233");
        s.setStatus(1);
        s.setCreateBy("aaa");
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
        printlnJson(service.insert(s));
    }

    @Test
    public void update(){
        SysDictItem s = new SysDictItem();
        s.setId(2);
        s.setItemKey("123444444");
        s.setStatus(StatusEnum.INVALID.value());
        s.setUpdateBy("33333");
        printlnJson(service.update(s));
    }

    @Test
   public void delete(){
        printlnJson(service.delete(2));
    }
}
