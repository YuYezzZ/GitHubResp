package com.yuye.factory;

import com.yuye.dao.UserDao;
import com.yuye.dao.impl.UserDaoImpl;

public class DynamicFactory {
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
