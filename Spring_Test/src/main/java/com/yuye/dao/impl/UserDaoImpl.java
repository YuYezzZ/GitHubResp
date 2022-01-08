package com.yuye.dao.impl;

import com.yuye.dao.UserDao;
import com.yuye.pojo.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Resource(name="jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<User> userAll() {
        List<User> userList = jdbcTemplate.query("select * from sys_user ", new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    @Override
    public Long saveUser(User user) {
        /*jdbcTemplate.update("insert into sys_user value (?,?,?,?,?)",null,user.getUsername(),user.getEmail(),user.getPassword(),user.getPhoneNum());*/
        PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement("insert into sys_user values(?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1,null);
                preparedStatement.setString(2,user.getUsername());
                preparedStatement.setString(3,user.getEmail());
                preparedStatement.setString(4,user.getPassword());
                preparedStatement.setString(5,user.getPhoneNum());
                return preparedStatement;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator,generatedKeyHolder);
        long userId = generatedKeyHolder.getKey().longValue();
        return userId;
    }

    @Override
    public void saveUserRole(Long userId,Long[] roleIds) {
        for (Long roleId : roleIds) {
            jdbcTemplate.update("insert into sys_user_role values (?,?)",userId,roleId);
        }
    }

    @Override
    public void deleteUser(Long userId) {
        jdbcTemplate.update("delete from sys_user_role where userId=?",userId);
        jdbcTemplate.update("delete from sys_user where id=?",userId);
    }

    @Override
    public User checkUser(String username,String password) throws EmptyResultDataAccessException {
        User user = jdbcTemplate.queryForObject("select * from sys_user where username=? and password=?",new BeanPropertyRowMapper<User>(User.class), username,password);
        return user;
    }

}

