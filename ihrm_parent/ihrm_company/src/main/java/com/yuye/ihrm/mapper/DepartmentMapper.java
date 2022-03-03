package com.yuye.ihrm.mapper;

import com.yuye.ihrm.domain.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: yuye
 * @Date: 2022/3/2 - 03 - 02 - 14:38
 * @Description: com.yuye.ihrm.mapper
 * @version: 1.0
 */
@Repository
public interface DepartmentMapper  {
    @Select("select * from co_department")
    @ResultMap(value = "companyResultMap")
    List<Department> selectList();

    @Select("select * from co_department where id = #{id}")
    @ResultMap("departmentResultMap")
    Department selectById(String id);

    int insert(Department department);

    int updateById(Department department);

    @Delete("delete * from co_department where id = #{id}")
    int deleteById(String id);
}
