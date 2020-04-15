package com.blog.service;

import com.blog.domain.User;

import java.util.List;

/**
 * @program: cgjblog
 * @description: 用户service接口
 * @author: 大橙子
 * @create: 2020-04-12 16:30
 **/
public interface UserService {
    //创建用户
    User save(User user);
    //修改用户
    User update(User user);
    //删除用户
    void deleteUser(Long id);
    //查询单个用户
    User getUserById(Long id);
    //查询用户列表
    List<User> getListUser();
}
