package com.hqjcloud.upms;

/*import org.mybatis.spring.annotation.MapperScan;*/

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.upms
 * @ClassName: UpmsApplication
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/14 15:45
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/14 15:45
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@SpringBootApplication
@MapperScan(basePackages = "com.hqjcloud.upms.mapper")
public class UpmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(UpmsApplication.class, args);
    }
}
