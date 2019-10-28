package com.hqjcloud.article.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MyConfig implements  WebMvcConfigurer {



   /* @Override
    public void addInterceptors(InterceptorRegistry registry) {  // 添加拦截器
        // 定义要拦截和放行的请求、资源
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/login","/error","/static/**","/index");
        //super.addInterceptors(registry);
    }*/




}
