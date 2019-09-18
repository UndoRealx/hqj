package com.hqjcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.eureka
 * @ClassName: HqjCloudEurekaApplication
 * @Description: 注册中心
 * @Author: lic
 * @CreateDate: 2019/9/11 17:04
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/11 17:04
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@EnableEurekaServer
@SpringBootApplication
public class HqjCloudEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(HqjCloudEurekaApplication.class, args);
    }
}
