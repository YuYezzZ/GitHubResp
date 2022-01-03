package com.yuye.dao.impl;

import com.yuye.dao.UserDao;
import com.yuye.pojo.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl3 implements UserDao {
    private List<String> strList;
    private Map<String, User> map;
    private Properties properties;

    public List<String> getStrList() {
        return strList;
    }

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public Map<String, User> getMap() {
        return map;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public void save() {
        System.out.println(strList);
        System.out.println(map);
        System.out.println(properties);
        System.out.println("UserDaoImpl3");
    }

    public UserDaoImpl3() {
    }

    public UserDaoImpl3(List<String> strList, Map<String, User> map, Properties properties) {
        this.strList = strList;
        this.map = map;
        this.properties = properties;
    }
}
