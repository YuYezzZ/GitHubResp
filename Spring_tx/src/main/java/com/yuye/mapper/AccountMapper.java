package com.yuye.mapper;

import com.yuye.pojo.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {
    void out(@Param("outMan")String outMan,@Param("money")double money);
    void in(@Param("inMan")String inMan,@Param("money") double money);

    List<Account> findAll();

    void save(Account account);
}
