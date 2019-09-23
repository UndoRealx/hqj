package com.hqjcloud.provider.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.provider.controller
 * @ClassName: LoginController
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/19 16:32
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/19 16:32
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(description = "登录")
public class LoginController {

    @ApiOperation(value = "首页", notes = "首页")
    @GetMapping(value = "/index")
    @ResponseBody
    public Object index()
    {
        return  "Success";
    }
}
