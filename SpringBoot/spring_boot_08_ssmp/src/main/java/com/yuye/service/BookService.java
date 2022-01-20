package com.yuye.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuye.pojo.Book;

public interface BookService extends IService<Book> {

    IPage<Book> getPage(int pageCurrent, int pageSize, Book book);


    /*Boolean save(Book book);
    Boolean update(Book book);
    Boolean delete(Integer id);
    List<Book> selectList();
    Book selectById(Integer id);*/
}
