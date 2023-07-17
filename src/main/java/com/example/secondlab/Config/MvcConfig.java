package com.example.secondlab.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{

    public void addViewControllers(@NonNull ViewControllerRegistry viewControllerRegistry) {
        viewControllerRegistry.addViewController("/auth/register").setViewName("registration");
    }
}
