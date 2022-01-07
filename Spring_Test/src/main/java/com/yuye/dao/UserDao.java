package com.yuye.dao;

import com.yuye.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> userAll();

    Long saveUser(User user);

    void saveUserRole(Long userId,Long[] roleIds);
}
