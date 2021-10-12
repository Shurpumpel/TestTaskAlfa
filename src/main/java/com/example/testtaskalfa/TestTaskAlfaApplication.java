package com.example.testtaskalfa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TestTaskAlfaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestTaskAlfaApplication.class, args);
    }

}
