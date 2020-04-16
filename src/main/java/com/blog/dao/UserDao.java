package com.blog.dao;

import com.blog.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: cgjblog
 * @description: 用户Dao接口
 * @author: 大橙子
 * @create: 2020-04-12 16:15
 **/
@Mapper
@Repository
public interface UserDao {
    //创建用户
    int save(User user);
    //修改用户
    User update(User user);
    //删除用户
    void deleteUser(long id);
    //查询单个用户
    User getUserById(long id);
    //查询用户列表
    List<User> getListUser();
}
