package com.yuye.ihrm.mapper;

import com.yuye.ihrm.domain.Company;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: yuye
 * @Date: 2022/3/1 - 03 - 01 - 14:50
 * @Description: com.yuye.ihrm.mapper
 * @version: 1.0
 */
@Repository
public interface CompanyMapper  {
    @Select("select * from co_company")
    @ResultMap("CompanyResultMap")
    List<Company> selectList();

    @Select("select * from co_company where id = #{id}")
    @ResultMap("CompanyResultMap")
    Company selectById(String id);

    int insert(Company company);

    int updateById(Company company);

    @Delete("delete * from co_company where id = #{id}")
    int deleteById(String id);
}
