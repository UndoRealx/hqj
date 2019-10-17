package com.hqjcloud.upms.config;

import com.hqjcloud.upms.common.MyAuthTokenConfigurer;
import com.hqjcloud.upms.common.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.upms.config
 * @ClassName: SecurityConfiguration
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/14 16:07
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/14 16:07
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private TokenProvider tokenProvider;
    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //不创建不使用session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http

                .authorizeRequests()//定义哪些URL需要被保护、哪些不需要被保护
            /*    .antMatchers("/product/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")*/
                .antMatchers("/auth/**").permitAll()
                .anyRequest().authenticated();
          /*      .and()
                .formLogin().and()
                .httpBasic().and()*/
        http.apply(securityConfigurerAdapter());// 这里增加securityConfigurerAdapter
        http.csrf().disable();
        // 禁用缓存
        http.headers().cacheControl();


    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(userDetailsService) // 设置自定义的userDetailsService
                .passwordEncoder(new MyPasswordEncoder());
               /* auth.inMemoryAuthentication()
                        .passwordEncoder(new MyPasswordEncoder())//可以设置内存指定的登录的账号密码,指定角色
                .withUser("admin1").password("admin1").roles("ADMIN","USER") //// 管理员，同事具有 ADMIN,USER权限，可以访问所有资源
                .and()
                .withUser("user1").password("user1").roles("USER");// 普通用户，只能访问 /product/***/
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 增加方法
    private MyAuthTokenConfigurer securityConfigurerAdapter() {
        return new MyAuthTokenConfigurer(userDetailsService, tokenProvider);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}