package com.github.yingzhuo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@EnableConfigurationProperties
@Import({
        SpringConfigBase.class
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(new Object[]{Application.class}, args);
    }

}
