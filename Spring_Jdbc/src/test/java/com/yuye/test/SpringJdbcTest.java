package com.yuye.test;

import com.yuye.config.SpringConfig;
import com.yuye.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@ContextConfiguration(classes = {SpringConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringJdbcTest {
    @Autowired
    private DataSource dataSource;
    @Resource(name="jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
   @Test
   public void test1() throws SQLException {

       int row = jdbcTemplate.update("insert into tb_user value (?,?)", "张三", 14);
       System.out.println(row);
   }
    @Test
    public void test2() throws SQLException {
        int row = jdbcTemplate.update("update tb_user set username=? where age=?", "小明", 14);
        System.out.println(row);
    }
    @Test
    public void test3() throws SQLException {
        int row = jdbcTemplate.update("delete from tb_user where age=?", 12);
        System.out.println(row);
    }
    @Test
    public void test4() throws SQLException {
        List<Account> accountList = jdbcTemplate.query("select * from tb_user", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(accountList);
    }
    @Test
    public void test5() throws SQLException {
        List<Account> accountList = jdbcTemplate.query("select * from tb_user where age=?", new BeanPropertyRowMapper<Account>(Account.class),12);
        System.out.println(accountList);
    }
    @Test
    public void test6() throws SQLException {
        Account account = jdbcTemplate.queryForObject("select * from tb_user where username=?", new BeanPropertyRowMapper<Account>(Account.class), "张三");
        System.out.println(account);
    }
    @Test
    public void test7() throws SQLException {
        Integer integer = jdbcTemplate.queryForObject("select count(*) from tb_user ", Integer.class);
        System.out.println(integer);
    }

}
