package qian.xun.facade.query;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SysDictItemQuery {
    private String dictCode;
    private String itemKey;
    private int offset;
    private int limit;
    private String order;
    private int status;
}
