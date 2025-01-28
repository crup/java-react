package com.acme.java_react;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Map all requests to static resources inside "frontend/client"
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/frontend/client/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Map the root path to index.html
        registry.addViewController("/").setViewName("forward:/index.html");
    }
}
