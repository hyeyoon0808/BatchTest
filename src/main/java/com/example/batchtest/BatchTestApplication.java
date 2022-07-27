package com.example.batchtest;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing //배치 활성화

public class BatchTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchTestApplication.class, args);
    }

}
