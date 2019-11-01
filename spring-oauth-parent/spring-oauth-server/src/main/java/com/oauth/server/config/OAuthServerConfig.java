package com.oauth.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @ProjectName: hqjcloud
 * @Package: com.oauth.server.config
 * @ClassName: OAuthServerConfig
 * @Description:
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
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        //oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
        // 允许表单登录
        oauthServer.allowFormAuthenticationForClients();
    }

    @Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
        //String secret = passwordEncoder.encode("123");
        //客户端存储信息存储于内存中
        clients.inMemory()
                .withClient("client") //客户端  clientId, 可以类比为用户名
                .secret(passwordEncoder.encode("secret")) //客户端 secret ， 可以类比为密码
                .authorizedGrantTypes("authorization_code")	// 授权类型，这里选择授权码
                .scopes("user_info") // 授权范围
                //.autoApprove(true) // 自动认证
                .redirectUris("http://localhost:8882/login","http://localhost:8883/login")	// 跳转uri
                .accessTokenValiditySeconds(10); // 超时时间，10s
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                // tonken 存储于内存中
                .tokenStore(new InMemoryTokenStore())
                .authenticationManager(authenticationManager);
    }

}