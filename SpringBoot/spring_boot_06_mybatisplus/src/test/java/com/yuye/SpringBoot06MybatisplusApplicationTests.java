package com.yuye;

import com.yuye.mapper.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBoot06MybatisplusApplicationTests {
    @Autowired
    private BookDao bookDao;
    @Test
    void contextLoads() {
    }
    @Test
    //mybatis plus 测试
    public void selectList(){
        List list = bookDao.selectList(null);
        System.out.println(list);
    }
}
