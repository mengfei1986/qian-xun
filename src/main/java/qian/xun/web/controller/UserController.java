package qian.xun.web.controller;

import org.springframework.util.CollectionUtils;
import qian.xun.facade.po.User;
import qian.xun.facade.service.UserService;
import org.springframework.web.bind.annotation.*;
import qian.xun.utils.TimeUtil;
import qian.xun.web.model.UserModel;
import qian.xun.web.response.AjaxResult;
import qian.xun.web.response.UserListResult;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public AjaxResult<UserModel.UserView> getAll() {
        List<User> users = null;//userService.selectAll();
        UserListResult data=  new UserListResult();
        if(!CollectionUtils.isEmpty(users)){
            data.setItems( users.stream().map(e->{
                  UserModel.UserView view = new UserModel.UserView();
                  view.setId(e.getId());
                  view.setName(e.getName());
                  view.setMobile(e.getMobile());
                  view.setStatus(e.getStatus());
                  view.setSex("男");
                  view.setInTime(e.getInterTime());
                  return view;
              }).collect(Collectors.toList()));
            data.setTotal(users.size());
        }
        return AjaxResult.success(data);
    }


//    @RequestMapping(value = "/user", method = RequestMethod.POST)
//    public User add(@RequestBody User user) {
//        userService.insert(user);
//        return user;
//    }
//
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
//    public User update(@PathVariable String id, @RequestBody User user) {
//        user.setId(id);
//        userService.update(user);
//        return user;
//    }
//
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
//    public boolean delete(@PathVariable String id) {
//        return userService.delete(id);
//    }
}
