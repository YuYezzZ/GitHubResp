package com.yuye.controller;

import com.yuye.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: yuye
 * @Date: 2022/2/18 - 02 - 18 - 10:51
 * @Description: com.yuye.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /*@Autowired*/
    @Reference //dubbo远程注入
    private UserService userService;

    @GetMapping("/sayHello")
    //say hello
    public String sayHello(){
        return userService.sayHello();
    }

}
