package com.yuye.service;

import com.yuye.pojo.Brand;

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
}
