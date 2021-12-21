package com.yuye.web;

import com.alibaba.fastjson.JSON;
import com.yuye.pojo.Brand;
import com.yuye.service.BrandService;
import com.yuye.service.ImplementsBrand;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
    private BrandService brandService = new ImplementsBrand();
    //查新所有
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Brand> brands = brandService.selectAll();
        String brandsJson = JSON.toJSONString(brands);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(brandsJson);
    }
    public void addBrand(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        Brand brand = JSON.parseObject(s,Brand.class);
        brandService.addBrand(brand);
        response.getWriter().write("true");
    }
    //条件查询
    public void selectCondition(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String brandJson = request.getParameter("brand");
        Brand brand = JSON.parseObject(brandJson,Brand.class);
        if(brand.getBrandName()!=null)
            brand.setBrandName("%"+brand.getBrandName()+"%");
        if(brand.getCompanyName()!=null)
            brand.setCompanyName("%"+brand.getCompanyName()+"%");
        List<Brand> brands = brandService.selectCondition(brand);
        String brandsJson = JSON.toJSONString(brands);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(brandsJson);
    }
    //通过id查询商品
    public void selectById(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");
        System.out.println(id);
        Integer id2= Integer.getInteger(id);
        System.out.println(id2);
        Brand brand = brandService.selectById(id2);
        String brandJson = JSON.toJSONString(brand);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(brandJson);
    }
//    修改信息
    public void updateBrand(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String brandUpdateJson = request.getParameter("brandUpdate");
        System.out.println(brandUpdateJson);
        Brand brand = JSON.parseObject(brandUpdateJson,Brand.class);
        System.out.println(brand);
        brandService.updateBrand(brand);
        response.getWriter().write("true");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }
}