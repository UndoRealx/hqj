package com.hqjcloud.article;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article
 * @ClassName: ArticleApplication
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/20 9:29
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/20 9:29
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@SpringBootApplication
@MapperScan(basePackages = "com.hqjcloud.article.mapper")
public class ArticleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArticleApplication.class, args);
    }
}
