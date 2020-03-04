package com.kai.zuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseConfig {

    @Bean
    public MyZuulFilter zuulFilter(){
       return new MyZuulFilter();
    }
}
