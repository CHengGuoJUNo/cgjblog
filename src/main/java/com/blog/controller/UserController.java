package com.blog.controller;

import com.blog.dao.UserDao;
import com.blog.domain.User;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: cgjblog
 * @description: 用户Controller
 * @author: 大橙子
 * @create: 2020-04-12 16:42
 **/
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    //创建用户
    @PostMapping("/save")
    public ModelAndView save(User user,Model model){
        User u = userService.save(user);
        model.addAttribute("user",u);
        model.addAttribute("title","新增用户");
        return new ModelAndView("users/form","userModel",model);

    }
    //获取修改用户的界面
    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable("id") Long id,Model model){
        User u = userService.getUserById(id);
        model.addAttribute("user",u);
        model.addAttribute("title","修改用户");
        return new ModelAndView("users/form","userModel",model);
    }
    //修改用户
    @PostMapping("/update")
    public ModelAndView update(User user,Model model){
        User u = userService.update(user);
        model.addAttribute("user",u);
        return new ModelAndView("users/form","userModel",model);
    }
    //删除用户
    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Long id,Model model){
        userService.deleteUser(id);
        return new ModelAndView("redirect:/users");
    }

    //获取创建用户表单页面
    @GetMapping("/form")
    public ModelAndView save(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","创建用户");
        return new ModelAndView("users/form","userModel",model);
    }

    //查询单个用户
    @GetMapping("/{id}")
    public ModelAndView getUserById(@PathVariable("id") Long id,Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","查询用户");
        return new ModelAndView("users/view","usermodel",model);
    }

    //查询所有的用户
    @GetMapping("/list")
    public ModelAndView getListUser(Model model){
        model.addAttribute("userlist",userService.getListUser());
        model.addAttribute("title","用户管理");
        return new ModelAndView("users/list","usermodel",model);
    }
}
