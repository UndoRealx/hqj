package com.hqjcloud.article.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.common
 * @ClassName: MyWebAppConfiguration
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/21 10:48
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/21 10:48
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Configuration
public class MyWebAppConfiguration extends WebMvcConfigurerAdapter {
    /**
     * 添加一些虚拟路径的映射
     * 静态资源路径和上传文件的路径
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * @Description: 对文件的路径进行配置, 创建一个虚拟路径/Path/** ，即只要在< img src="/Path/picName.jpg" />便可以直接引用图片
         *这是图片的物理路径  "file:/+本地图片的地址"
         */
        registry.addResourceHandler("/Path/**").addResourceLocations("file:/D:/Upload/");
        super.addResourceHandlers(registry);
    }
}