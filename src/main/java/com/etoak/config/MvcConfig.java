package com.etoak.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by w on 2020/4/22.
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer{

    @Value("${upload.mapping}")
    private String imgMapping;

    @Value("${upload.dir}")
    private String imgLocation;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(imgMapping)
                .addResourceLocations("file:"+imgLocation);
    }
}
