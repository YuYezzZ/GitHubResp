package com.yuye;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuye.mapper.BookMapper;
import com.yuye.pojo.Book;
import com.yuye.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IserviceTest {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookService bookService;
    @Test
    void contextLoads() {
    }
    @Test
    void selectList(){
        bookService.list();
    }
    @Test
    void insert(){
        Book book = new Book();
        book.setType("网剧1");
        book.setName("雪中悍刀行1");
        book.setDescription("网络小说改变成的电视剧1");

        bookService.save(book);
    }
    @Test
    void selectPage(){
        Page<Book> bookPage = new Page<Book>(2,1);
        bookService.page(bookPage);
        System.out.println(bookPage.getTotal());
    }
    @Test
    void service(){
        Book book = new Book();
        book.setType("网剧");
        book.setName("雪中悍刀行2");
        book.setDescription("网络小说改变成的电视剧1");
        book.setId(4);
        bookService.updateById(book);
    }
}
