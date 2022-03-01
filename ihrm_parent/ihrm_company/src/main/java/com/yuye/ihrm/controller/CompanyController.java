package com.yuye.ihrm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuye.ihrm.common.entity.PageResult;
import com.yuye.ihrm.common.entity.Result;
import com.yuye.ihrm.common.entity.ResultCode;
import com.yuye.ihrm.domain.Company;
import com.yuye.ihrm.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: yuye
 * @Date: 2022/3/1 - 03 - 01 - 15:40
 * @Description: com.yuye.ihrm.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyMapper companyMapper;
    @GetMapping
    public Result getAll(){
        List<Company> companies = companyMapper.selectList(null);
        return new Result(ResultCode.SUCCESS,companies);
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable("id") String id){
        Company company = companyMapper.selectById(id);
        return new Result(ResultCode.SUCCESS,company);
    }
    @PostMapping
    public Result saveCompany(@RequestBody Company company){
        int insert = companyMapper.insert(company);
        return insert==1?new Result(ResultCode.SUCCESS):new Result(ResultCode.FAIL);
    }
    @PutMapping()
    public Result updateCompany(@RequestBody Company company){
        int update = companyMapper.updateById(company);
        return update==1?new Result(ResultCode.SUCCESS):new Result(ResultCode.FAIL);
    }
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable("id") String id ){
        int delete = companyMapper.deleteById(id);
        return delete==1?new Result(ResultCode.SUCCESS):new Result(ResultCode.FAIL);
    }
    @PostMapping("/search/{page}/{size}")
    public PageResult<Company> searchPage(@PathVariable("page") int page,@PathVariable("size")int size){
        Page<Company> companyPage = new Page<Company>(page-1, size);
        QueryWrapper<Company> companyQueryWrapper = new QueryWrapper<>();
        Page<Company> pageResult = companyMapper.selectPage(companyPage, null);
        long total = pageResult.getTotal();
        List<Company> companies = pageResult.getRecords();
        return new PageResult<Company>(total,companies);
    }
}
