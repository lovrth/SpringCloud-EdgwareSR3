package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    /** 解决 Could not resolve placeholder xxx问题 */
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
//        PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
//        c.setIgnoreUnresolvablePlaceholders(true);
//        return c;
//    }
}
