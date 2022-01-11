package com.yuye.service;

import com.yuye.pojo.Account;

import java.util.List;

public interface AccountService {

    public void transfer(String outMan,String inMan,double money);

    List<Account> findAll();

    void save(Account account);
}
