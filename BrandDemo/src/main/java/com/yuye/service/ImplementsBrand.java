package com.yuye.service;

import com.yuye.mapper.BrandMapper;
import com.yuye.pojo.Brand;
import com.yuye.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ImplementsBrand implements BrandService {
    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public List<Brand> selectAll() {
        SqlSession session = sqlSessionFactory.openSession();
        BrandMapper mapper = session.getMapper(BrandMapper.class);
        List<Brand> brands =mapper.selectAll();
        session.close();
        return brands;
    }

    @Override
    public List<Brand> selectCondition(Brand brand) {
        SqlSession session = sqlSessionFactory.openSession();
        BrandMapper mapper = session.getMapper(BrandMapper.class);
        List<Brand> brands =mapper.selectCondition(brand);
        session.close();
        return brands;
    }

    @Override
    public void addBrand(Brand brand) {
        SqlSession session = sqlSessionFactory.openSession();
        BrandMapper mapper = session.getMapper(BrandMapper.class);
        mapper.addBrand(brand);
        session.commit();
        session.close();
    }

    @Override
    public Brand selectById(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        BrandMapper mapper = session.getMapper(BrandMapper.class);
        Brand brand =mapper.selectById(id);
        session.close();
        return brand;
    }

    @Override
    public void updateBrand(Brand brand) {
        SqlSession session = sqlSessionFactory.openSession();
        BrandMapper mapper = session.getMapper(BrandMapper.class);
        mapper.updateBrand(brand);
        session.commit();
        session.close();
    }
}
