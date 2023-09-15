package com.kxuer.datagenerator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.kxuer.datagenerator.*.mapper")
public class DataGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataGeneratorApplication.class, args);
    }

}
