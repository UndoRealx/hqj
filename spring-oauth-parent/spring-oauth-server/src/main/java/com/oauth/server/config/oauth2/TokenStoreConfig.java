package com.oauth.server.config.oauth2;

import com.oauth.server.support.properities.BootSecurityProperties;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.sql.DataSource;

/**
 * @ProjectName: hqjcloud
 * @Package: com.oauth.server.config.oauth2
 * @ClassName: TokenStoreConfig
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/11/5 11:46
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/5 11:46
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Configuration
public class TokenStoreConfig {

    private BootSecurityProperties properties;

    //private RedisConnectionFactory factory;



    private DataSource dataSource;

    @Autowired(required = false)
    public TokenStoreConfig(BootSecurityProperties properties) {//RedisConnectionFactory factory, ,  DataSource dataSource
        this.properties = properties;
        //this.factory = factory;
        //this.dataSource = dataSource;
    }

    @Bean
    public TokenStore tokenStore() throws Exception {

        TokenStore store = null;

        switch (properties.getTokenStoreType()) {
            case jwt:
                store = new JwtTokenStore(jwtAccessTokenConverter());
                break;
           /* case redis:
                if (factory == null) {
                    throw new BeanCreationException("配置Redis存储Token需要redisConnectionFactory bean，未找到");
                }
                store = new RedisTokenStore(factory);
                break;*/
            case jdbc:
                if(dataSource==null){
                    throw new BeanCreationException("配置jdbc存储Token需要dataSource bean，未找到");
                }
                store=new JdbcTokenStore(dataSource);
                break;
            default:
                store = new InMemoryTokenStore();
        }

        return store;
    }

    @Bean
    @Primary
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();

        converter.setSigningKey(properties.getTokenSigningKey());

        return converter;
    }
}

