package qian.xun.facade.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import qian.xun.facade.dao.UserDao;
import qian.xun.facade.service.UserService;

import javax.annotation.Resource;
import java.util.List;
@Service("userService")
@Transactional(rollbackFor = Throwable.class)
public class UserServiceImpl  implements UserService {
    @Resource
    UserDao userDao;
    @Override
    public List pageList() {
        return null;
    }
}
