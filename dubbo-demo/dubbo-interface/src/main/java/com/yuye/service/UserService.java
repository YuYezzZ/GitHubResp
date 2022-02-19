package com.yuye.service;
import com.yuye.pojo.User;

/**
 * @Auther: yuye
 * @Date: 2022/2/19 - 02 - 19 - 8:23
 * @Description: com.yuye.service
 * @version: 1.0
 */

public interface UserService {
   public String sayHello();

   public User getUserById(int id);
}