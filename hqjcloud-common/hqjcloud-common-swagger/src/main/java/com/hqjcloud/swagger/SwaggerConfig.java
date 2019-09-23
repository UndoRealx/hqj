package com.hqjcloud.swagger;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.swagger
 * @ClassName: SwaggerConfig
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/12 10:53
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/12 10:53
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig{

    @Value("${swagger.is.enable ?: true}")
    private boolean swagger_is_enable;

    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //.enable(swagger_is_enable)
                .select()
                //加了ApiOperation注解的类，生成接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //包下的类，生成接口文档
                //.apis(RequestHandlerSelectors.basePackage("com.hqjcloud"))
                //.paths(PathSelectors.any())
                .build();
                //.globalOperationParameters(getOperationParameters());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("在线接口")
                .description("rest api 文档构建利器")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }

    public List<Parameter> getOperationParameters() {

        List<Parameter> parameters = new ArrayList();

        Map<String, String> map = new HashMap<String, String>();
        //map.put("token","");

        for (String str:map.keySet())
        {
            ParameterBuilder  pb = new ParameterBuilder();
            pb.parameterType("header").name(str)//Authorization
                    .description(map.get(str))
                    .modelRef(new ModelRef("string"))
                    .parameterType("header")
                    .required(false).build();
            parameters.add(pb.build());
        }

        return parameters;
    }
}
