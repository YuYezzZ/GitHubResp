package com.yuye;

import com.yuye.mapper.BookMapper;
import com.yuye.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBoot05MybatisApplicationTests {
    @Autowired
    private BookMapper bookMapper;
    @Test
    void contextLoads() {
    }
    @Test
    void selectAll() {
        List<Book> books = bookMapper.findAll();
        System.out.println(books);
    }


}
