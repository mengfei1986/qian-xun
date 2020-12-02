package qian.xun.web.response;

import lombok.Data;
import qian.xun.web.model.UserModel;

import java.util.List;

@Data
public class UserListResult {
    private int total;
    private List<UserModel.UserView> items;
}
