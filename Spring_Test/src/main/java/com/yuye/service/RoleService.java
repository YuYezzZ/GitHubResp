package com.yuye.service;

import com.yuye.pojo.Role;

import java.util.List;

public interface RoleService {
    List<Role> roleAll();

    void saveRole(Role role);
}
