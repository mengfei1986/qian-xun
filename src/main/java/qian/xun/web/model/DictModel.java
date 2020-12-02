package qian.xun.web.model;

import lombok.Data;

@Data
public class DictModel {
    @Data
    public static class DictItemView{
        private Integer id;
        private String dictCode;
        private String dictName;
        private String itemKey;
        private String itemVal;
        private Integer status;
    }
}
