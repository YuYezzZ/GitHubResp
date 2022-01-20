package com.yuye.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuye.mapper.BookMapper;
import com.yuye.pojo.Book;
import com.yuye.service.BookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper,Book> implements BookService {
    @Autowired
    private BookMapper bookMapper;


    @Override
    public IPage<Book> getPage(int pageCurrent, int pageSize, Book book) {
        Page<Book> page = new Page<>(pageCurrent,pageSize);
        LambdaQueryWrapper<Book> bookLambdaQueryWrapper = new LambdaQueryWrapper<>();
        bookLambdaQueryWrapper.like(!Strings.isEmpty(book.getType()),Book::getType,book.getType());
        bookLambdaQueryWrapper.like(!Strings.isEmpty(book.getName()),Book::getName,book.getName());
        bookLambdaQueryWrapper.like(!Strings.isEmpty(book.getDescription()),Book::getDescription,book.getDescription());
        bookMapper.selectPage(page, bookLambdaQueryWrapper);
        if(pageCurrent > page.getPages())
            bookMapper.selectPage(new Page<Book>(page.getPages(),pageSize), bookLambdaQueryWrapper);
        return page;
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
