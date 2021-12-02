package com.chinafree;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.chinafree.mapper")
@SpringBootApplication
public class ChinafreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChinafreeApplication.class, args);
    }

}
