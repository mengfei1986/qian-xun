package qian.xun.facade.request;

import lombok.Data;
@Data
public class SysDictItemRequest {
    private SysDictItemRequest(){}
    @Data
    public static class PageList{
        private Integer page;
        private Integer limit;
        private String sort;
        private String dictCode;
        private String itemKey;
    }
}
