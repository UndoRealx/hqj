package com.hqjcloud.upms.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.upms.common
 * @ClassName: SecurityConfigurerAdapter
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/16 9:54
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/16 9:54
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MyAuthTokenConfigurer  extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    @Autowired
    private TokenProvider tokenProvider; // 我们之前自定义的 token功能类
    private UserDetailsService detailsService;// 也是我实现的UserDetailsService
    public MyAuthTokenConfigurer(UserDetailsService detailsService, TokenProvider tokenProvider) {
        this.detailsService = detailsService;
        this.tokenProvider = tokenProvider;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        MyTokenFilter customerFilter=new MyTokenFilter(detailsService,tokenProvider);
        http.addFilterBefore(customerFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
