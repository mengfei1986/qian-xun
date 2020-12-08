package qian.xun.web.model;

import lombok.Data;

@Data
public class DictItemModel {
    @Data
    public static class DictItemView{
        private int id;
        private String dictCode;
        private String dictName;
        private String itemKey;
        private String itemVal;
        private int status;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String updateTime;
    }
}
