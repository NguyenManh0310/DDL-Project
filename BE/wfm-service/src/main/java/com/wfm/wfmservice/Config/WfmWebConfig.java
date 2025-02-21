package com.wfm.wfmservice.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WfmWebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Cho phép tất cả các endpoint
                .allowedOrigins("http://127.0.0.1:5501") // Cho phép domain front-end
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Cho phép các HTTP method
                .allowedHeaders("*") // Cho phép tất cả header
                .allowCredentials(true); // Cho phép gửi thông tin xác thực (cookies, headers, etc.)
    }
}