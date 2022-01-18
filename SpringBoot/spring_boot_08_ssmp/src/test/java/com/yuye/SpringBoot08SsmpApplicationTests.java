package com.yuye;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuye.mapper.BookMapper;
import com.yuye.pojo.Book;
import com.yuye.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBoot08SsmpApplicationTests {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookService bookService;
    @Test
    void contextLoads() {
    }
    @Test
    void selectList(){
        bookMapper.selectList(null);
    }
    @Test
    void insert(){
        Book book = new Book();
        book.setType("网剧");
        book.setName("雪中悍刀行");
        book.setDescription("网络小说改变成的电视剧");
        book.insert();
    }
    @Test
    void selectPage(){
        Page<Book> bookPage = new Page<Book>(2,1);
        bookMapper.selectPage(bookPage,null);
    }
    @Test
    void selectBy(){
        String type = "网络";
        LambdaQueryWrapper<Book> bookLambdaQueryWrapper = new LambdaQueryWrapper<>();
        bookLambdaQueryWrapper.like(type!=null,Book::getType,type);
        bookMapper.selectList(bookLambdaQueryWrapper);
    }
    @Test
    void service(){
        List<Book> books = bookService.selectList();
        System.out.println(books);
        Book book = bookService.selectById(3);
        System.out.println(book);
    }
}
