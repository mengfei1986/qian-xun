package qian.xun.web.response;

import lombok.Data;
import qian.xun.web.model.UserModel;

import java.util.ArrayList;
import java.util.List;

@Data
public class DataResult<T> {
    private int total = 0;
    private List<T> items = new ArrayList<>();
}
