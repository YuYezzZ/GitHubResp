package com.yuye.mapper;

import com.yuye.pojo.Brand;
import org.apache.ibatis.annotations.*;

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

    @Delete("delete from tb_brand where id = #{id} ")
    void deleteById(int id);

    void deleteByIds(@Param("ids")int[] ids);

    @Select("select * from tb_brand limit #{begin},#{pageSize}")
    @ResultMap("BrandResultMap")
    List<Brand> selectLimit(@Param("begin") int begin,@Param("pageSize") int pageSize);

    @Select("select count(*) from tb_brand")
    int totalCount();
}
