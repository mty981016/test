package com.bdqn.ls.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyPicConfig implements WebMvcConfigurer {
    @Override    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploadimg/**").addResourceLocations("file:/E:/GIt代码仓库/test/ls/src/main/resources/static/uploadimg/");
    }}
