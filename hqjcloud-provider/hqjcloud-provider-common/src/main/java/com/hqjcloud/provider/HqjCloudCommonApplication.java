package com.hqjcloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.provider
 * @ClassName: HqjCloudCommonApplication
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/12 9:17
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/12 9:17
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */

/*@EnableHystrix*/
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages =("com.hqjcloud.swagger"))
public class HqjCloudCommonApplication {
    public static void main(String[] args) {
        SpringApplication.run(HqjCloudCommonApplication.class, args);
    }
}
