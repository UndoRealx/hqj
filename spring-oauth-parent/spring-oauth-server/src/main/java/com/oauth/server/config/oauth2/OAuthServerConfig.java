package com.oauth.server.config.oauth2;

import com.oauth.server.filter.BootBasicAuthenticationFilter;
import com.oauth.server.support.oauth2.BootClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * @ProjectName: hqjcloud
 * @Package: com.oauth.server.config
 * @ClassName: OAuthServerConfig
 * @Description:  开启认证授权中心  都依赖于 security框架 WebSecurityConfigurerAdapter
 * @Author: lic
 * @CreateDate: 2019/10/30 16:58
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/30 16:58
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Configuration
@EnableAuthorizationServer
public class OAuthServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private BootBasicAuthenticationFilter filter;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private BootClientDetailsService clientDetailsService;


    @Autowired
    private WebResponseExceptionTranslator bootWebResponseExceptionTranslator;

    private TokenStore tokenStore;

    private JwtAccessTokenConverter converter;

    private UserDetailsService userDetailsService;

    private AuthenticationEntryPoint authenticationEntryPoint;

   /* @Autowired(required = false)
    public OAuthServerConfig(AuthenticationManager authenticationManager,
                                           BootClientDetailsService clientDetailsService,
                                           TokenStore tokenStore, JwtAccessTokenConverter converter,
                                           AuthenticationEntryPoint authenticationEntryPoint,
                                           BootOAuth2WebResponseExceptionTranslator bootWebResponseExceptionTranslator,
                                           BootBasicAuthenticationFilter filter, BootUserDetailService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.clientDetailsService = clientDetailsService;
        this.tokenStore = tokenStore;
        this.converter = converter;
        this.authenticationEntryPoint = authenticationEntryPoint;
        this.bootWebResponseExceptionTranslator = bootWebResponseExceptionTranslator;
        this.filter = filter;
        this.userDetailsService = userDetailsService;
    }*/

    @Override
    public void configure(final AuthorizationServerSecurityConfigurer security) throws Exception {
        // 允许表单登录
        security.allowFormAuthenticationForClients();

        // 加载client的service
        filter.setClientDetailsService(clientDetailsService);

        // 自定义异常处理端口
        security.authenticationEntryPoint(authenticationEntryPoint);

        // 客户端认证之前的过滤器
        security.addTokenEndpointAuthenticationFilter(filter);

        security.tokenKeyAccess("permitAll()").checkTokenAccess("()");
    }

    /**
     * 添加用户信息
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsService);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                // token 存储方式
                .tokenStore(tokenStore)
                .authenticationManager(authenticationManager)
                // 不配置会导致token无法刷新
                .userDetailsService(userDetailsService)
                .allowedTokenEndpointRequestMethods(HttpMethod.POST,HttpMethod.GET);

        // 判断当前是否使用jwt
        if(!(tokenStore instanceof RedisTokenStore) && this.converter!=null){
            endpoints.accessTokenConverter(converter);
        }

        // 处理 ExceptionTranslationFilter 抛出的异常
        endpoints.exceptionTranslator(bootWebResponseExceptionTranslator);

        // 最后一个参数为替换之后页面的url
        endpoints.pathMapping("/oauth/confirm_access","/custom/confirm_access");
    }

}