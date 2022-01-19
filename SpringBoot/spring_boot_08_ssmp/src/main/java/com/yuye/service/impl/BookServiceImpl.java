package com.yuye.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuye.mapper.BookMapper;
import com.yuye.pojo.Book;
import com.yuye.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper,Book> implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getByCondition(Book book) {
        LambdaQueryWrapper<Book> bookLambdaQueryWrapper = new LambdaQueryWrapper<>();
        bookLambdaQueryWrapper.like(Book::getType,book.getType()).like(Book::getName,book.getName()).like(Book::getDescription,book.getDescription());
        List<Book> books = bookMapper.selectList(bookLambdaQueryWrapper);

        return books;
    }
    /*@Override
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
    public List<Book> selectList(Book book) {
        return bookMapper.selectList(null);
    }

    @Override
    public Book selectById(Integer id) {
        return bookMapper.selectById(id);
    }*/
}
