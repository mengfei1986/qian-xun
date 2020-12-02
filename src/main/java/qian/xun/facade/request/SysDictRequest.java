package qian.xun.facade.request;

import lombok.Data;

import java.util.List;

@Data
public class SysDictRequest {
    private SysDictRequest(){}
    @Data
    public static class QueryList{
        private List<String> dictCodes;
    }
}
