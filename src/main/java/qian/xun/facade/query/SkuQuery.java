package qian.xun.facade.query;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SkuQuery {
    private String spuId;
    private String colorNo;
    private String colorDesc;
    private Integer status;
}
