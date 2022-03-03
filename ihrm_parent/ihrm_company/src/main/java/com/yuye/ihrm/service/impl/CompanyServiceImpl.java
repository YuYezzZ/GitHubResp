package com.yuye.ihrm.service.impl;

import com.yuye.ihrm.common.entity.Result;
import com.yuye.ihrm.common.entity.ResultCode;
import com.yuye.ihrm.common.utils.IdWorker;
import com.yuye.ihrm.domain.Company;
import com.yuye.ihrm.mapper.CompanyMapper;
import com.yuye.ihrm.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yuye
 * @Date: 2022/3/3 - 03 - 03 - 9:59
 * @Description: com.yuye.ihrm.service.impl
 * @version: 1.0
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private IdWorker idWorker;
    @Override
    public Result selectList() {
        List<Company> companys = companyMapper.selectList();
        return new Result(ResultCode.SUCCESS,companys);
    }

    @Override
    public Result selectById(String id) {
        Company company = companyMapper.selectById(id);
        return new Result(ResultCode.SUCCESS,company);
    }

    @Override
    public Result insert(Company company) {
        String id = String.valueOf(idWorker.nextId());
        company.setId(id);
        int insert = companyMapper.insert(company);
        return insert==1?new Result(ResultCode.SUCCESS):new Result(ResultCode.FAIL);
    }

    @Override
    public Result updateById(Company company) {
        int update = companyMapper.updateById(company);
        return update==1?new Result(ResultCode.SUCCESS):new Result(ResultCode.FAIL);
    }

    @Override
    public Result deleteById(String id) {
        int delete = companyMapper.deleteById(id);
        return delete==1?new Result(ResultCode.SUCCESS):new Result(ResultCode.FAIL);
    }

    /*@Override
    public PageResult<Company> selectPage(int page,int size) {
        PageHelper.startPage(page,size);
        List<Company> companies = companyMapper.selctList();
        PageInfo<Company> companyPageInfo = new PageInfo<Company>(companies);
        return new PageResult<Company>(companyPageInfo.getTotal(),companyPageInfo.getList());
    }*/
}
