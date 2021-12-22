package com.yuye.service;

import com.yuye.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: yuye
 * @Date: 2021-12-19 - 12 - 19 - 13:14
 * @Description: com.yuye.service
 * @version: 1.0
 */
public interface BrandService {
    List<Brand> selectAll();

    List<Brand> selectCondition(Brand brand);

    void addBrand(Brand brand);

    Brand selectById(int id);

    void updateBrand(Brand brand);

    void deleteById(int id);

    void deleteByIds(int[] ids);

    List<Brand> selectLimit(int begin, int pageSize);

    int totalCount();
}
