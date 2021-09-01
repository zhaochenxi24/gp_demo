package com.zcx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
@MapperScan("com.zcx.dao")
public class GpDemoApplication  {
    public static void main(String[] args) {
        SpringApplication.run(GpDemoApplication.class, args);
    }
}
