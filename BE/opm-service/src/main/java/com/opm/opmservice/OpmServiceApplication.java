package com.opm.opmservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OpmServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpmServiceApplication.class, args);
    }

}
