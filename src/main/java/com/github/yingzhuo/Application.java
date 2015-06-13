package com.github.yingzhuo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableConfigurationProperties
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(new Object[]{Application.class}, args);
    }

}
