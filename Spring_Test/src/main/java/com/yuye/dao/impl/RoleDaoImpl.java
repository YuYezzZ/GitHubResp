package com.yuye.dao.impl;

import com.yuye.dao.RoleDao;
import com.yuye.pojo.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("roleDao")
public class RoleDaoImpl implements RoleDao {
    @Resource(name="jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Role> roleAll() {
        List<Role> roleList = jdbcTemplate.query("select * from sys_role ", new BeanPropertyRowMapper<Role>(Role.class));
        return roleList;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public RoleDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public RoleDaoImpl() {
    }
}
