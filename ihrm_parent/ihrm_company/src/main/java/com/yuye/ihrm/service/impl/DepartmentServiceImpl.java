package com.yuye.ihrm.service.impl;

import com.yuye.ihrm.common.entity.Result;
import com.yuye.ihrm.common.entity.ResultCode;
import com.yuye.ihrm.common.utils.IdWorker;
import com.yuye.ihrm.domain.Department;
import com.yuye.ihrm.mapper.DepartmentMapper;
import com.yuye.ihrm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yuye
 * @Date: 2022/3/3 - 03 - 03 - 10:00
 * @Description: com.yuye.ihrm.service.impl
 * @version: 1.0
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private IdWorker idWorker;
    @Override
    public Result selectList() {
        List<Department> departments = departmentMapper.selectList();
        return new Result(ResultCode.SUCCESS,departments);
    }

    @Override
    public Result selectById(String id) {
        Department department = departmentMapper.selectById(id);
        return new Result(ResultCode.SUCCESS,department);
    }

    @Override
    public Result insert(Department department) {
        String id = String.valueOf(idWorker.nextId());
        department.setId(id);
        int insert = departmentMapper.insert(department);
        return insert==1?new Result(ResultCode.SUCCESS):new Result(ResultCode.FAIL);
    }

    @Override
    public Result updateById(Department department) {
        int update = departmentMapper.updateById(department);
        return update==1?new Result(ResultCode.SUCCESS):new Result(ResultCode.FAIL);
    }

    @Override
    public Result deleteById(String id) {
        int delete = departmentMapper.deleteById(id);
        return delete==1?new Result(ResultCode.SUCCESS):new Result(ResultCode.FAIL);
    }
}
