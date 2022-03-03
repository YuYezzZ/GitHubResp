package com.yuye.ihrm.controller;

import com.yuye.ihrm.common.entity.Result;
import com.yuye.ihrm.domain.Department;
import com.yuye.ihrm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: yuye
 * @Date: 2022/3/2 - 03 - 02 - 14:39
 * @Description: com.yuye.ihrm.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/company/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping
    public Result getAll(){
        return departmentService.selectList();
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable("id") String id){
        return departmentService.selectById(id);
    }
    @PostMapping
    public Result saveDepartment(@RequestBody Department department){
        return departmentService.insert(department);
    }
    @PutMapping()
    public Result updateDepartment(@RequestBody Department department){
        return departmentService.updateById(department);
    }
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable("id") String id ){
        return departmentService.deleteById(id);
    }
}
