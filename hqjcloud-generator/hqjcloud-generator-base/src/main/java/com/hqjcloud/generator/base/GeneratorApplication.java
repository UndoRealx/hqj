package com.hqjcloud.generator.base;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.generator.base
 * @ClassName: GeneratorApplication
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/19 11:38
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/19 11:38
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@SpringBootApplication
@MapperScan("com.hqjcloud.generator.base.dao")
public class GeneratorApplication {
    public static void main(String[] args) {
        SpringApplication.run(GeneratorApplication.class, args);
    }
}
