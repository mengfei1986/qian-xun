package qian.xun.facade.query;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SysDictQuery {
    private List<String> dictCodes;
    private int offset;
    private int limit;
    private String dictCode;
    private String dictName;
    private int status;
}
