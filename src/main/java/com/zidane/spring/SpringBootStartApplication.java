package com.zidane.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

/**
 * 启动配置类
 *
 * @author Zidane
 * @since 2018-04-08
 */
@SpringBootApplication
@ImportResource("classpath:transaction.xml")
@MapperScan("com.zidane.spring.dao.mapper")
public class SpringBootStartApplication  extends SpringBootServletInitializer {
    public static void main(String args[]) {
        SpringApplication.run(SpringBootStartApplication .class, args);
    }
}