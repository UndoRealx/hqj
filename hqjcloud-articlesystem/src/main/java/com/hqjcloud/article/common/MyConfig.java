/*
package com.hqjcloud.article.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.*;

*/
/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.common
 * @ClassName: MyConfig
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/11 10:18
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/11 10:18
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 *//*

@Configuration
public class MyConfig implements  WebMvcConfigurer {



    @Override
    public void addInterceptors(InterceptorRegistry registry) {  // 添加拦截器
        // 定义要拦截和放行的请求、资源
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/login","/error","/static/**","/index");
        //super.addInterceptors(registry);
    }

}*/
