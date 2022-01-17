package com.yuye;

import com.yuye.mapper.BookDao;
import com.yuye.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBoot07DruidApplicationTests {
    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
    }
    @Test
    //Druid mybatis
    public void selectAll(){
        List<Book> all = bookDao.findAll();
        System.out.println(all);
    }
}
