package qian.xun;

import com.alibaba.fastjson.JSON;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = QianXunApplication.class)
public class AbstractTest {
    @Before
    public void init() {
        System.out.println("开始测试-----------------");
    }

    @After
    public void after() {
        System.out.println("测试结束-----------------");
    }

    protected void printlnJson(Object obj){
        System.out.println(JSON.toJSONString(obj));
    }

}
