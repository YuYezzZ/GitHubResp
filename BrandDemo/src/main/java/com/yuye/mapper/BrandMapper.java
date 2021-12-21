package com.yuye.mapper;

import com.yuye.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Auther: yuye
 * @Date: 2021-12-19 - 12 - 19 - 13:12
 * @Description: com.yuye.mapper ,数据库映射
 * @version: 1.0
 */
public interface BrandMapper {
    @Select("select * from tb_brand ")
    @ResultMap("BrandResultMap")
    List<Brand> selectAll();

    List<Brand> selectCondition(Brand brand);

    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void addBrand(Brand brand);

    @Select("select * from tb_brand where id = #{id}")
    @ResultMap("BrandResultMap")
    Brand selectById(int id);

    @Update("update tb_brand set brand_name=#{brandName},company_name=#{companyName},ordered=#{ordered},description=#{description},status=#{status} where id =#{id} ")
    void updateBrand(Brand brand);
}
