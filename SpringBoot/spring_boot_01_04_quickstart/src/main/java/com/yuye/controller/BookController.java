package com.yuye.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: yuye
 * @Date: 2022/1/13 - 01 - 13 - 20:37
 * @Description: springboot 快速入门
 * @version: 1.0
 */
@RestController
@RequestMapping("/books")
public class BookController {
    @GetMapping
    public String hello(){
        System.out.println("springboot running....4");
        return "springboot is running4";
    }
}
