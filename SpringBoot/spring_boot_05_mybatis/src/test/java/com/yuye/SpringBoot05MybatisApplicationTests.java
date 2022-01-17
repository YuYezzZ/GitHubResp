package com.yuye;

import com.yuye.mapper.BookDao;
import com.yuye.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBoot05MybatisApplicationTests {
    @Autowired
    private BookDao bookDao;
    @Test
    void contextLoads() {
    }
    @Test
    void selectAll() {
        List<Book> books = bookDao.findAll();
        System.out.println(books);
    }

}
