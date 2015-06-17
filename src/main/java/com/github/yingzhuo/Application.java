package com.github.yingzhuo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;


@SpringBootApplication
@EnableConfigurationProperties
@EnableTransactionManagement
@EnableAspectJAutoProxy
@EnableScheduling
@EnableJms
public class Application {

    private final static Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Resource
    private ApplicationContext ac;

    @PostConstruct
    public void init() {
        String[] profiles = ac.getEnvironment().getActiveProfiles();
        if (profiles == null || profiles.length == 0) {
            LOGGER.info("no active profiles");
        } else {
            LOGGER.info("active profile: ");
            LOGGER.info("========================");
            for (String profile : profiles) {
                LOGGER.info(profile);
            }
            LOGGER.info("========================");
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(new Object[]{Application.class}, args);
    }

}
