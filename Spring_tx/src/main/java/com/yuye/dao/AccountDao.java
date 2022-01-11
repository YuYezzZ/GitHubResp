package com.yuye.dao;

import com.yuye.pojo.Account;

import java.util.List;

public interface AccountDao {

    public void out(String outMan,double money);
    public void in(String inMan,double money);

    List<Account> findAll();

    void save(Account account);
}
