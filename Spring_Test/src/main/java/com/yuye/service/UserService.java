package com.yuye.service;

import com.yuye.pojo.User;

import java.util.List;

public interface UserService {

    List<User> userAll();

    void saveUser(User user,Long[] roleIds);

    void deleteUser(Long userId);

    User checkUser(String username,String password);
}
