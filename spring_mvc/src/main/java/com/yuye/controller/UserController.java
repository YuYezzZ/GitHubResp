package com.yuye.controller;

import com.alibaba.fastjson.JSON;
import com.yuye.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    //
    @RequestMapping(value = "/quick", method = RequestMethod.GET, params = {"username", "money"})
    public String save() {
        System.out.println("Controller save running");
        //配置viewResolver前
        /*return "redirect:/jsp/success.jsp";*/
        //    配置viewResolver后
        return "success";
    }
    @RequestMapping( "/quick2")
    public String save2() {

        return "success";
    }
    @RequestMapping( "/quick3")
    public ModelAndView save3() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        return modelAndView;
    }
    @RequestMapping( "/quick4")
    public ModelAndView save4() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","张三");
        modelAndView.setViewName("success");
        return modelAndView;
    }
    @RequestMapping( "/quick5")
    public ModelAndView save5(ModelAndView modelAndView) {
        modelAndView.addObject("name","李四");
        modelAndView.setViewName("success");
        return modelAndView;
    }
    @RequestMapping( "/quick6")
    public String save6(Model model) {
        model.addAttribute("name","王五");
        return "success";
    }
    @RequestMapping( "/quick7")
    public String save7(HttpServletRequest request) {
        request.setAttribute("name","小明");
        return "success";
    }
    @RequestMapping( "/quick8")
    public void save8(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello response");
    }
    @RequestMapping("/quick9")
    @ResponseBody
    public String save9(){
        return "hello world!";
    }
    @RequestMapping("/quick10")
    @ResponseBody
    public String save10(){
        User user = new User("zs", 12);
        User user2 = new User("ls", 13);
        return "[{\"username\":\""+user.getName()+"\",\"age\":\""+user.getAge()+"\" },{\"username\":\""+user2.getName()+"\",\"age\":\""+user2.getAge()+"\" }]";
    }
    @RequestMapping("/quick11")
    @ResponseBody
    public String save11(){
        User user = new User("zs", 12);
        User user2 = new User("ls", 13);
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        String json = JSON.toJSONString(users);
        return json;
    }
}
