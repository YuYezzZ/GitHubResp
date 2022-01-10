package com.yuye.service.impl;

import com.yuye.mapper.AccountMapper;
import com.yuye.pojo.Account;
import com.yuye.service.AccountService;
import com.yuye.util.MybatisUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    /*@Resource(name="accountDao")
    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }*/
    private SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();

    @Autowired
    /*@Resource(name="accountMapper")*/
    private AccountMapper accountMapper;

    @Transactional(isolation= Isolation.READ_COMMITTED,propagation= Propagation.REQUIRED)
    public void transfer(String outMan, String inMan, double money) {
        /*accountDao.out(outMan,money);
        int i=1/0;
        accountDao.in(inMan,money);*/

        /*SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        mapper.out(outMan,money);
        mapper.in(inMan,money);
        sqlSession.close();*/

        accountMapper.out(outMan,money);
        /*int i=1/0;*/
        accountMapper.in(inMan,money);
    }

    @Override
    public List<Account> findAll() {
        /*List<Account> accountList = accountDao.findAll();
        return accountList;*/


        /*SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        List<Account> accountList = mapper.findAll();
        sqlSession.close();*/

        List<Account> accountList = accountMapper.findAll();
        return accountList;
    }

    @Override
    public void save(Account account) {
        /*accountDao.save(account);*/


        /*SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        mapper.save(account);
        sqlSession.commit();
        sqlSession.close();*/

        accountMapper.save(account);
    }
}
