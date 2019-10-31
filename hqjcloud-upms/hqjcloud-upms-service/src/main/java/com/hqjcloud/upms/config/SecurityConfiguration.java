package com.hqjcloud.upms.config;

import com.hqjcloud.upms.security.JwtAuthenticationEntryPoint;
import com.hqjcloud.upms.security.JwtAuthorizationTokenFilter;
import com.hqjcloud.upms.security.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.upms.com.oauth.server.config
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
@EnableWebSecurity// 这个注解必须加，开启Security
@EnableGlobalMethodSecurity(prePostEnabled = true)//保证post之前的注解可以使用
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    JwtAuthorizationTokenFilter authenticationTokenFilter;
    
    /**
    *@Description 这个方法是我们配置拦截的地方
    *@Param  * @param http
    *@Return void
    *@Author lic
    *@Date 2019/10/17
    *@Time 10:08
    */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //禁用frame
        http.headers().frameOptions().disable();

        http.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint) //这里面主要配置如果没有凭证，可以进行一些操作
                .and()
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()//允许所有人访问
                .antMatchers("/test/**").permitAll()//允许所有人访问
                .antMatchers(HttpMethod.OPTIONS, "/**").anonymous() ////允许匿名访问 这个配置是为了方便后面写前后端分离的时候前端过来的第一次验证请求，这样做，会减少这种请求的时间和资源使用
                .anyRequest().authenticated()       // 剩下所有的验证都需要验证
                .and()
                .csrf().disable()              // 禁用 Spring Security 自带的跨域处理
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                // 定制我们自己的 session 策略：调整为让 Spring Security 不创建和使用 session

        // 禁用缓存
        http.headers().cacheControl();
        //禁止记住我
        http.rememberMe().disable();

        http.addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);


        //不创建不使用session
       /* http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http

                .authorizeRequests()//定义哪些URL需要被保护、哪些不需要被保护
            *//*    .antMatchers("/product/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")*//*
                .antMatchers("/auth/**").permitAll()
                .anyRequest().authenticated();
          *//*      .and()
                .formLogin().and()
                .httpBasic().and()*//*
        http.apply(securityConfigurerAdapter());// 这里增加securityConfigurerAdapter
        http.csrf().disable(); // 禁用 Spring Security 自带的跨域处理
        // 禁用缓存
        http.headers().cacheControl();*/
    }

    
    /**
    *@Description 这个方法主要用于访问一些静态的东西控制。其中ignoring()方法可以让访问跳过filter验证。
    *@Param  * @param web
    *@Return void
    *@Author lic
    *@Date 2019/10/17
    *@Time 10:24
    */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**");
        web.ignoring().antMatchers("/images/**");
        web.ignoring().antMatchers("/js/**");
        //忽略登录界面
        web.ignoring().antMatchers("/login");
        //注册地址不拦截
        web.ignoring().antMatchers("/reg");
    }

    
    /**
    *@Description 这个方法是主要进行验证的地方
    *@Param  * @param auth
    *@Return void
    *@Author lic
    *@Date 2019/10/17
    *@Time 10:27
    */
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(jwtUserDetailsService) // 设置自定义的userDetailsService
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
/*    private MyAuthTokenConfigurer securityConfigurerAdapter() {
        return new MyAuthTokenConfigurer(jwtUserDetailsService, tokenProvider);
    }*/

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}