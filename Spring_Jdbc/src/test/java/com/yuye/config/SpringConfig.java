package com.yuye.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.yuye")
@Import(value={DataSourceConfig.class,JdbcConfig.class})
public class SpringConfig {

}
