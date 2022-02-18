package com.yuye.service;

import org.apache.dubbo.config.annotation.Service;

/**
 * @Auther: yuye
 * @Date: 2022/2/18 - 02 - 18 - 10:32
 * @Description: com.yuye.service
 * @version: 1.0
 */
@Service
public interface UserService {
    String sayHello();
}
