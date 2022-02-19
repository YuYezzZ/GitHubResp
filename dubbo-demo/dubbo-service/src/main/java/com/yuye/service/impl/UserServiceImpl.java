package com.yuye.service.impl;

import com.yuye.pojo.User;
import com.yuye.service.UserService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @Auther: yuye
 * @Date: 2022/2/18 - 02 - 18 - 10:33
 * @Description: com.yuye.service.impl
 * @version: 1.0
 */
@Service(timeout = 3000 , retries = 0)
public class UserServiceImpl implements UserService {

    @Override
    public String sayHello() {
        System.out.println("hello");
        return "hello dubbo~";
    }

    @Override
    public User getUserById(int id) {
        return new User(1,"zhangsan",25);
    }
}
