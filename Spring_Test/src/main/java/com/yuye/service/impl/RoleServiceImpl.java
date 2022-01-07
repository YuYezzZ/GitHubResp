package com.yuye.service.impl;

import com.yuye.dao.RoleDao;
import com.yuye.pojo.Role;
import com.yuye.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Resource(name="roleDao")
    private RoleDao roleDao;
    @Override
    public List<Role> roleAll() {
        List<Role> roleList = roleDao.roleAll();
        return roleList;
    }

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public RoleDao getRoleDao() {
        return roleDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public RoleServiceImpl() {
    }
}
