package com.yuye.ihrm.controller;

import com.yuye.ihrm.common.entity.Result;
import com.yuye.ihrm.domain.Company;
import com.yuye.ihrm.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: yuye
 * @Date: 2022/3/1 - 03 - 01 - 15:40
 * @Description: com.yuye.ihrm.controller
 * @version: 1.0
 */
//解决跨域
@CrossOrigin
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @GetMapping
    public Result getAll(){
//        int i = 1 / 0;
        return companyService.selectList();
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable("id") String id) /*throws CommonException*/ {
//        throw new CommonException(ResultCode.FAIL);
        return companyService.selectById(id);
    }
    @PostMapping
    public Result saveCompany(@RequestBody Company company){
        return companyService.insert(company);
    }
    @PutMapping()
    public Result updateCompany(@RequestBody Company company){
        return companyService.updateById(company);
    }
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable("id") String id ){
        return companyService.deleteById(id);
    }
    /*@PostMapping("/search/{page}/{size}")
    public PageResult<Company> searchPage(@PathVariable("page") int page,@PathVariable("size")int size){

        return companyService.selectPage(page,size);
    }*/
}
