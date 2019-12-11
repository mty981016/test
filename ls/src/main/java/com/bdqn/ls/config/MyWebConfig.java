package com.bdqn.ls.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {
    //添加视图解析器(自定义,且必须有thymeleaf依赖才可以正常使用)
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("main").setViewName("main");
    }
}
