package qian.xun.web.model;

import lombok.Data;

@Data
public class DictModel {
    @Data
    public static class DictView{
        private int id;
        private String dictCode;
        private String dictName;
        private String remark;
        private int status;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String updateTime;
    }
    @Data
    public static class SimpleDictView{
        private String dictCode;
        private String dictName;
    }
}
