package com.shaping.shaping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.shaping.shaping.mapper")
public class ShapingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShapingApplication.class, args);
    }

}
