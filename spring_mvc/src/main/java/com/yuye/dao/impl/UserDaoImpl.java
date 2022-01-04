package com.yuye.dao.impl;

import com.yuye.dao.UserDao;
import org.springframework.stereotype.Repository;


@Repository("userDao")
//@Component("userDao")
public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("UserDaoImpl");
    }
}
