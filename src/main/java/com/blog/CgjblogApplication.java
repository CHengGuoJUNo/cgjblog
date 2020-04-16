package com.blog;

import com.blog.domain.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CgjblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(CgjblogApplication.class, args);
    }

}
