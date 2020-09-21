package com.exp.spike.config.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * @ClassName: WebConfig
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-09-21 20:56
 * @Version: 1.0
 **/
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Autowired
    private UserArgumentResolver userArgumentResolver;

    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(userArgumentResolver);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/templates/");
        super.addResourceHandlers(registry);
    }
}
