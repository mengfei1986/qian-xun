package qian.xun.facade.response;

import lombok.Data;

import java.util.List;
@Data
public class PageResult<T> {
    private int total;
    private List<T> items;
}
