package com.teamwork.boutique;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class BoutiqueApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoutiqueApplication.class, args);
    }
}
