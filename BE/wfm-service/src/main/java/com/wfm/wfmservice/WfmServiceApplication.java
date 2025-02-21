package com.wfm.wfmservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.common.commonservice","com.wfm.wfmservice"})
@EnableEurekaClient
public class WfmServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WfmServiceApplication.class, args);
	}

}
