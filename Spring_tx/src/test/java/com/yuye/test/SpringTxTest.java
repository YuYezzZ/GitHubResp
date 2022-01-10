package com.yuye.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTxTest {
    @Autowired
    private DataSource dataSource;
    @Test
    public void test1() throws SQLException {
        System.out.println(dataSource);
        System.out.println(dataSource.getConnection());
    }
}
