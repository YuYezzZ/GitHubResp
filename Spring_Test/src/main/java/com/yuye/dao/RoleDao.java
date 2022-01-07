package com.yuye.dao;

import com.yuye.pojo.Role;

import java.util.List;

public interface RoleDao {
    List<Role> roleAll();

    void save(Role role);

    List<Role> findRoleByUserId(Long userId);
}