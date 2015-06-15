package com.github.yingzhuo;

import com.github.yingzhuo.aop.ServiceLoggingAop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfigAop {

    @Bean
    public ServiceLoggingAop serviceLoggingAop() {
        return new ServiceLoggingAop();
    }

}
