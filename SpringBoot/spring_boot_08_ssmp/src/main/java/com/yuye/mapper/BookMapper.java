package com.yuye.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuye.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
