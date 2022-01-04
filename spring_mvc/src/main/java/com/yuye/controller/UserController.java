package com.yuye.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
