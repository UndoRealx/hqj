package com.hqjcloud.article.controller;

import com.hqjcloud.base.ApiResultEntity;
import com.hqjcloud.base.enums.StateCode;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.controller
 * @ClassName: UserController
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/23 9:33
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/23 9:33
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(description = "用户登录")
public class LoginController {

    
    /**
    *@Description  用户登录
    *@Param  * @param userName 用户名
             * @param password 密码
    *@Return com.hqjcloud.base.ApiResultEntity
    *@Author lic
    *@Date 2019/9/23
    *@Time 9:38
    */
    public ApiResultEntity Login(String userName,String password)
    {
        return  ApiResultEntity.returnResult(StateCode.success.get());
    }

    
    /**
    *@Description 用户退出登录
    *@Param  * @param 
    *@Return com.hqjcloud.base.ApiResultEntity
    *@Author lic
    *@Date 2019/9/23
    *@Time 9:52
    */
    public  ApiResultEntity logout()
    {
        return  ApiResultEntity.returnResult(StateCode.success.get());
    }
}
