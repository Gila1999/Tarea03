package com.example.t03e3.configuracion;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {  

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/enlaces-externos").setViewName("linksView");
    }
}
