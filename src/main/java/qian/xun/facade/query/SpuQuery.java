package qian.xun.facade.query;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SpuQuery {
    private String name;
    private String modelNo;
    private String specs;
    private String headUrl;
    private String seller;
    private Integer minPrice;
    private Integer maxPrice;
    private Integer status;
}
