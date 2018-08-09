package com.alexb.empconsumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Slf4j
@EnableJpaRepositories(enableDefaultTransactions = false)
public class EmpConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpConsumerApplication.class, args);
    }
}
