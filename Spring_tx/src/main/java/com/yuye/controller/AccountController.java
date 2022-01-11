package com.yuye.controller;

import com.yuye.pojo.Account;
import com.yuye.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Resource(name="accountService")
    private AccountService accountService;

    /*public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
       AccountService accountService = app.getBean(AccountService.class);
        accountService.transfer("tom","lucy",500);
    }*/
    //转账方法
    @RequestMapping("/transfer")
    public String transfer(String outMan, String inMan, double money){
        accountService.transfer(outMan,inMan,money);
        return "redirect:/account/findAll";
    }
    
    //查询方法
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<Account> accountList = accountService.findAll();
        modelAndView.addObject("accountList",accountList);
        modelAndView.setViewName("findAll");
        return modelAndView;
    }
    //保存方法
    @RequestMapping(value = "/save",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String save(Account account){
        accountService.save(account);
        return "保存成功";
    }
}
