package com.yuye.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuye.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: yuye
 * @Date: 2022/1/17 - 01 - 17 - 19:52
 * @Description: com.yuye.mapper
 * @version: 1.0
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {
    @Select("select * from t_book")
    List<Book> findAll();
}

