package com.yuye;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther: yuye
 * @Date: 2022/2/18 - 02 - 18 - 10:18
 * @Description: com.yuye
 * @version: 1.0
 */
@EnableDubbo
@SpringBootApplication
public class DubboWebApplication {
    //程序入口
    public static void main(String[] args) {
        SpringApplication.run(DubboWebApplication.class,args);
    }
}
