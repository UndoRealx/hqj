package com.oauth.client2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

/**
 * @ProjectName: hqjcloud
 * @Package: PACKAGE_NAME
 * @ClassName: OAuthClientApplication
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/30 17:30
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/30 17:30
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@SpringBootApplication
public class OAuthClient2Application {

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

    public static void main(String[] args) {
        SpringApplication.run(OAuthClient2Application.class, args);
    }
}