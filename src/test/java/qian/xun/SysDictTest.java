package qian.xun;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import qian.xun.facade.po.SysDict;
import qian.xun.facade.request.SysDictRequest;
import qian.xun.facade.service.SysDictService;

import java.util.Arrays;

public class SysDictTest extends AbstractTest {
    @Autowired
    private SysDictService service;
    //@Ignore("not ready yet")
    @Test
    public void queryList(){
        SysDictRequest.QueryList req = new SysDictRequest.QueryList();
//        req.setDictCodes(Arrays.asList("1233","123"));
        printlnJson(service.queryList(req));
    }

    @Test
    public void create(){
        SysDict s = new SysDict();
        s.setDictCode("123");
        s.setDictName("1234");
        s.setRemark("2");
        s.setStatus(1);
        s.setCreateBy("aaa");
        printlnJson(service.insert(s));
    }

    @Test
    public void update(){
        SysDict s = new SysDict();
        s.setId(2);
        s.setDictName("123444444");
        s.setStatus(2);
        s.setUpdateBy("33333");
        printlnJson(service.update(s));
    }

    @Test
   public void delete(){
        printlnJson(service.delete(2));
    }
}
