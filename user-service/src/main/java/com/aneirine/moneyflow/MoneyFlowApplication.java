package com.aneirine.moneyflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class MoneyFlowApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoneyFlowApplication.class, args);
    }

}
