package com.yuye.service.impl;

import com.yuye.service.UserService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @Auther: yuye
 * @Date: 2022/2/18 - 02 - 18 - 10:33
 * @Description: com.yuye.service.impl
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public String sayHello() {
        return "hello dubbo ~";
    }
}
