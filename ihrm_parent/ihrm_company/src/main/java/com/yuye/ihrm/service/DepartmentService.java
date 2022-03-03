package com.yuye.ihrm.service;

import com.yuye.ihrm.common.entity.Result;
import com.yuye.ihrm.domain.Department;

/**
 * @Auther: yuye
 * @Date: 2022/3/3 - 03 - 03 - 10:00
 * @Description: com.yuye.ihrm.service
 * @version: 1.0
 */
public interface DepartmentService {
    Result selectList();

    Result selectById(String id);

    Result insert(Department company);

    Result updateById(Department department);

    Result deleteById(String id);

}
