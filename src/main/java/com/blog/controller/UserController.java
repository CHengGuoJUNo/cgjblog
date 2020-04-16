package com.blog.controller;

import com.blog.dao.UserDao;
import com.blog.domain.User;
import com.blog.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: cgjblog
 * @description: 用户Controller
 * @author: 大橙子
 * @create: 2020-04-12 16:42
 **/
@Api(value = "/users",description = "用户操作接口")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    //创建用户
    @ApiOperation(value="创建用户的接口",notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user",value = "用户实体信息",required = true, dataType = "User")
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute User user,Model model){
        int i = userService.save(user);
        List<User> userList = userService.getListUser();
        return new ModelAndView("redirect:/users/list");
    }
    //获取修改用户的界面
    @GetMapping("/update/{id}")
    @ApiOperation(value="获取修改用户的界面",notes="根据用户id修改用户")
    @ApiImplicitParam(name = "id",value = "用户id",required = true, dataType = "Long")
    public ModelAndView update(@PathVariable("id") Long id,Model model){
        User u = userService.getUserById(id);
        model.addAttribute("user",u);
        model.addAttribute("title","修改用户");
        return new ModelAndView("users/form","usermodel",model);
    }

    //删除用户
    @ApiOperation(value="删除用户的接口",notes="根据用户id删除用户")
    @ApiImplicitParam(name = "id",value = "用户id",required = true, dataType = "Long")
    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Long id,Model model){
        userService.deleteUser(id);
        return new ModelAndView("redirect:/users/list");
    }

    //获取创建用户表单页面
    @ApiOperation(value="获取创建用户表单页面",notes="")
    @GetMapping("/form")
    public ModelAndView save(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","创建用户");
        return new ModelAndView("users/form","usermodel",model);
    }

    //查询单个用户
    @ApiOperation(value="查询单个用户",notes="根据用户id查询用户")
    @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "Long")
    @GetMapping("/{id}")
    public ModelAndView getUserById(@PathVariable("id") Long id,Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","查询用户");
        return new ModelAndView("users/view","usermodel",model);
    }

    //查询所有的用户
    @ApiOperation(value="查询所有用户的接口",notes="查询所有用户接口")
    @GetMapping("/list")
    public ModelAndView getListUser(Model model){
        model.addAttribute("userlist",userService.getListUser());
        model.addAttribute("title","用户管理");
        return new ModelAndView("users/list","usermodel",model);
    }
}
