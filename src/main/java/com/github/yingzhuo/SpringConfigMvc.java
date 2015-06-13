package com.github.yingzhuo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/*
 * @see WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter
 */

@Configuration
public class SpringConfigMvc extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/info.json");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("/WEB-INF/image");
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/css");
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/js");
        registry.addResourceHandler("/icon/**").addResourceLocations("/WEB-INF/icon");
    }
}
