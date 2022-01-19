package com.yuye.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuye.pojo.Book;

import java.util.List;

public interface BookService extends IService<Book> {
    List<Book> getByCondition(Book book);


    /*Boolean save(Book book);
    Boolean update(Book book);
    Boolean delete(Integer id);
    List<Book> selectList();
    Book selectById(Integer id);*/
}
