package com.yuye.web;

import com.alibaba.fastjson.JSON;
import com.yuye.pojo.Brand;
import com.yuye.pojo.PageBean;
import com.yuye.service.BrandService;
import com.yuye.service.ImplementsBrand;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

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
        Brand brand = JSON.parseObject(s, Brand.class);
        brandService.addBrand(brand);
        response.getWriter().write("true");
    }

    //条件查询
    public void selectCondition(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String brandJson = request.getParameter("brand");
        Brand brand = JSON.parseObject(brandJson, Brand.class);
        if (brand.getBrandName() != null)
            brand.setBrandName("%" + brand.getBrandName() + "%");
        if (brand.getCompanyName() != null)
            brand.setCompanyName("%" + brand.getCompanyName() + "%");
        List<Brand> brands = brandService.selectCondition(brand);
        String brandsJson = JSON.toJSONString(brands);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(brandsJson);
    }

    //通过id查询商品
    public void selectById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        int id = Integer.parseInt(s);
        System.out.println(id);
        Brand brand = brandService.selectById(id);
        String brandJson = JSON.toJSONString(brand);
        System.out.println(brandJson);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(brandJson);
    }

    //    修改信息
    public void updateBrand(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        Brand brand = JSON.parseObject(s, Brand.class);
        System.out.println(brand);
        brandService.updateBrand(brand);
        response.getWriter().write("true");
    }

    //    通过id删除
    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        int id = Integer.parseInt(s);
        System.out.println(id);
        brandService.deleteById(id);
        response.getWriter().write("true");
    }

    //    通过id批量删除
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        int[] ids = JSON.parseObject(s, int[].class);
        brandService.deleteByIds(ids);
        response.getWriter().write("true");
    }

    //分页方式查询
    public void selectLimit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String _pageSize = request.getParameter("pageSize");
        String _currentPage = request.getParameter("currentPage");
        int pageSize = Integer.parseInt(_pageSize);
        int currentPage = Integer.parseInt(_currentPage);
        int begin = (currentPage-1)*pageSize;
        List<Brand> brands = brandService.selectLimit(begin, pageSize);
        int totalCount = brandService.totalCount();
        PageBean<Brand> brandPageBean = new PageBean<>(totalCount, brands);
        System.out.println(brandPageBean);
        String jsonString = JSON.toJSONString(brandPageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }
}
