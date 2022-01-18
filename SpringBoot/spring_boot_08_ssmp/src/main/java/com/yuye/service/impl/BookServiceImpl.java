package com.yuye.service.impl;

import com.yuye.mapper.BookMapper;
import com.yuye.pojo.Book;
import com.yuye.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public Boolean save(Book book) {
        return bookMapper.insert(book) > 0;
    }

    @Override
    public Boolean update(Book book) {
        return bookMapper.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookMapper.deleteById(id) > 0;
    }

    @Override
    public List<Book> selectList() {
        return bookMapper.selectList(null);
    }

    @Override
    public Book selectById(Integer id) {
        return bookMapper.selectById(id);
    }
}
