package com.oauth.server.config.oauth2;

import com.oauth.server.support.oauth2.BootAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.AuthenticationEntryPoint;


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


    //private AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private BootAccessDeniedHandler handler;
    @Autowired
    private TokenStore tokenStore;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
/*        resources.tokenStore(tokenStore).resourceId("boot-server");

        resources.authenticationEntryPoint(authenticationEntryPoint).accessDeniedHandler(handler);*/
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                // Allows restricting access based upon the {@link HttpServletRequest} using
                .authorizeRequests()
                .antMatchers("/favicon.ico")
                .permitAll()
                .anyRequest()
                .access("#oauth2.hasAnyScope('all','select')");
    }

}
