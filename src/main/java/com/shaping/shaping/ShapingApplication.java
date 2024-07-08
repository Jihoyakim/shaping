package com.shaping.shaping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@MapperScan("com.shaping.shaping.mapper")
public class ShapingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShapingApplication.class, args);
    }

}
