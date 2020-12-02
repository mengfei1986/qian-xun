package qian.xun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Configuration
@EnableAutoConfiguration
@ComponentScan("qian.xun")
@MapperScan("qian.xun.facade.dao")
@Controller
public class QianXunApplication {

    public static void main(String[] args) {
        SpringApplication.run(QianXunApplication.class, args);
    }

    @RequestMapping({"/", "/index.html"})
    public ModelAndView index() {
        return new ModelAndView("index");
    }


}
