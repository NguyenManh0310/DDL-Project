package com.common.commonservice.Config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.common.commonservice.Entity")
@EnableJpaRepositories(basePackages = {"com.common.commonservice.Repository"})
public class CommonAppConfig {
}