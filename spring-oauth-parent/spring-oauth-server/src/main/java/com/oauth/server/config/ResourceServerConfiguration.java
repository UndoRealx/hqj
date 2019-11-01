package com.oauth.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @ProjectName: hqjcloud
 * @Package: com.oauth.server.config
 * @ClassName: ResourceServerConfiguration
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/31 16:15
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/31 16:15
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        super.configure(resources);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }

}
