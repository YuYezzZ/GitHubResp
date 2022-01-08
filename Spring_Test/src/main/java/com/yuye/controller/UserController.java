package com.yuye.controller;

import com.yuye.pojo.User;
import com.yuye.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource(name="userService")
    private UserService userService;
    @RequestMapping("/list")
    public ModelAndView userAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<User> userList=userService.userAll();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }
    @RequestMapping("/save")
    public String saveUser(User user,Long[] roleIds){
        userService.saveUser(user,roleIds);
        return "redirect:/user/list";
    }
    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return "redirect:/user/list";
    }
    @RequestMapping("/login")
    public String checkUser(String username,String password, HttpSession session){
        User user = userService.checkUser(username,password);
        System.out.println(user);
        if (user!=null){
            session.setAttribute("user",user);
            return "main";
        }
        return "redirect:/login.jsp";
    }
}
