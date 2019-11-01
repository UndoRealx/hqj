package com.oauth.server;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ProjectName: hqjcloud
 * @Package: PACKAGE_NAME
 * @ClassName: OAuthServerApplication
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/30 17:01
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/30 17:01
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@SpringBootApplication
@MapperScan(basePackages = "com.oauth.server.mapper")
public class OAuthServerApplication{

    public static void main(String[] args) {
        SpringApplication.run(OAuthServerApplication.class, args);
    }

}