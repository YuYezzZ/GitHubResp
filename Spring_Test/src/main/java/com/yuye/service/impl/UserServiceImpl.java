package com.yuye.service.impl;

import com.yuye.dao.RoleDao;
import com.yuye.dao.UserDao;
import com.yuye.pojo.Role;
import com.yuye.pojo.User;
import com.yuye.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource(name="roleDao")
    private RoleDao roleDao;
    @Resource(name="userDao")
    private UserDao userDao;
    @Override
    public List<User> userAll() {
        List<User> userList=userDao.userAll();
        for (User user : userList) {
            Long userId = user.getId();
            List<Role> roleList = roleDao.findRoleByUserId(userId);
            user.setRoleList(roleList);
        }
        System.out.println(userList);
        return userList;
    }

    @Override
    public void saveUser(User user,Long[] roleIds) {
        Long userId = userDao.saveUser(user);
        userDao.saveUserRole(userId,roleIds);
    }
}
