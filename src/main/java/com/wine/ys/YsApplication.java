package com.wine.ys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.wine.ys.mapper")
public class YsApplication {

    public static void main(String[] args) {
        SpringApplication.run(YsApplication.class, args);
    }

}
