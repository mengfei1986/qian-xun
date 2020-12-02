package qian.xun.facade.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import qian.xun.facade.po.User;

import java.util.List;
@Mapper
@Repository
public interface UserDao {
    User selectById(String id);

    List<User> selectAll();

    User selectByUserName(String username);

    void insert(User user);

    int update(User user);

    int deleteById(String id);
}
