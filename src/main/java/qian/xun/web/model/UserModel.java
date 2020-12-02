package qian.xun.web.model;

import lombok.Data;
@Data
public class UserModel {
    @Data
    public static class UserView{
        private int id;
        private String name;
        private String sex;
        private String mobile;
        private Integer status;
        private String inTime;
    }
}
