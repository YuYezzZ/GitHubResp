package com.yuye.service;

import com.yuye.pojo.Book;

import java.util.List;

public interface BookService {
    Boolean save(Book book);
    Boolean update(Book book);
    Boolean delete(Integer id);
    List<Book> selectList();
    Book selectById(Integer id);
}
