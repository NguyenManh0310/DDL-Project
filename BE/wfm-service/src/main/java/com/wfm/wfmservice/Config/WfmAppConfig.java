package com.wfm.wfmservice.Config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration// Thay đổi package đúng với module common của bạn
@EntityScan(basePackages = "com.wfm.wfmservice.Entity") // Nếu có entity trong module common
@EnableJpaRepositories(basePackages = "com.wfm.wfmservice.Repository") // Thay đổi package phù hợp
public class WfmAppConfig {
}
