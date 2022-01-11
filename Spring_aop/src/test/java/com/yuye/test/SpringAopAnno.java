package com.yuye.test;

import com.yuye.aop.anno.TargetInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:anno.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringAopAnno {
    @Autowired
    private TargetInterface target;
    @Test
    public void test1(){
        target.save();
    }
}
