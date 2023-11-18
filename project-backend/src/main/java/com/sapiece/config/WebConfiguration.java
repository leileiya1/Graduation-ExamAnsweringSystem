package com.sapiece.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author SAPiece
 * @Create 2023-11-18 19:13
 * @Package com.sapiece.config
 * @Project GraduationDesign
 * @Filename WebConfiguration
 * @Version 1.0
 */
@Configuration
public class WebConfiguration {
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
