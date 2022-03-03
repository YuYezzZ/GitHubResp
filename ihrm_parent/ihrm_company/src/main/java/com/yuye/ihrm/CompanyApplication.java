package com.yuye.ihrm;

import com.yuye.ihrm.common.utils.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @Auther: yuye
 * @Date: 2022/3/1 - 03 - 01 - 11:34
 * @Description: com.yuye.ihrm
 * @version: 1.0
 */
@SpringBootApplication(scanBasePackages = "com.yuye.ihrm")
@MapperScan("com.yuye.ihrm.mapper")
public class CompanyApplication {
    //程序入口
    public static void main(String[] args) {
        SpringApplication.run(CompanyApplication.class,args);
    }
    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
