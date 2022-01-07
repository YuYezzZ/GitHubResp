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

    @Override
    public void save(Role role) {
        jdbcTemplate.update("insert into sys_role values(?,?,?)",null,role.getRoleName(),role.getRoleDesc());
    }



    @Override
    public List<Role> findRoleByUserId(Long userId) {
       /* List<Long> roleIds = jdbcTemplate.query("select roleId from sys_user_role where userId=?", new BeanPropertyRowMapper<Long>(Long.class), userId);
        List<Role> roleList = new ArrayList<>();
        for (Long roleId : roleIds) {
            Role role = jdbcTemplate.queryForObject("select * from sys_role where id = ?", Role.class, roleId);
            roleList.add(role);
        }*/
        List<Role> roleList = jdbcTemplate.query("select * from sys_user_role ur,sys_role r where ur.roleId=r.id and ur.userId=?", new BeanPropertyRowMapper<Role>(Role.class), userId);
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
