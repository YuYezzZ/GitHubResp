package com.yuye.controller;

import com.yuye.exception.ExceptionDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
@Controller
public class ExceptionDemo {
    @Resource(name="exceptionDao")
    private ExceptionDao exceptionDao;
    //测试异常
    @RequestMapping("/show")
    public void show1() throws Exception {
        System.out.println("show");
        exceptionDao.show1();
//        exceptionDao.show2();
//        exceptionDao.show3();
//        exceptionDao.show4();
//        exceptionDao.show5();
    }
}
