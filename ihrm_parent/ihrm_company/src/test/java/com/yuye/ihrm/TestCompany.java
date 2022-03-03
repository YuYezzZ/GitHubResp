package com.yuye.ihrm;

import com.yuye.ihrm.domain.Company;
import com.yuye.ihrm.mapper.CompanyMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Auther: yuye
 * @Date: 2022/3/1 - 03 - 01 - 14:47
 * @Description: com.yuye.ihrm
 * @version: 1.0
 */
@SpringBootTest
public class TestCompany {
    @Autowired
    private CompanyMapper companyMapper;
    @Test
    //测试链接数据库
    public void testConn(){
        List<Company> companies = companyMapper.selectList();
        System.out.println(companies);
    }
}
