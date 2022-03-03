package com.yuye.ihrm.service;

import com.yuye.ihrm.common.entity.Result;
import com.yuye.ihrm.domain.Company;

/**
 * @Auther: yuye
 * @Date: 2022/3/3 - 03 - 03 - 9:59
 * @Description: com.yuye.ihrm.service
 * @version: 1.0
 */

public interface CompanyService {
    Result selectList();

    Result selectById(String id);

    Result insert(Company company);

    Result updateById(Company company);

    Result deleteById(String id);

//    PageResult<Company> selectPage(int page, int size);
}
