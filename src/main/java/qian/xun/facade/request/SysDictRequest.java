package qian.xun.facade.request;

import lombok.Data;

import java.util.List;

@Data
public class SysDictRequest {
    private SysDictRequest(){}

    @Data
    public static class PageList{
        private Integer page;
        private Integer limit;
        private List<String> dictCodes;
        private String dictCode;
        private String dictName;
        private int status;
    }
    @Data
    public static class QueryList{
        private List<String> dictCodes;
        private int status;
    }
}
