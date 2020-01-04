package com.bdqn.ls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.bdqn.ls.dao")
public class LsApplication {
    public static void main(String[] args) {
        SpringApplication.run(LsApplication.class, args);
    }
}
