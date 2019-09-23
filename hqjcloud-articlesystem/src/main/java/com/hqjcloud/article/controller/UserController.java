package com.hqjcloud.article.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.controller
 * @ClassName: IndexController
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/23 11:03
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/23 11:03
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
@RequestMapping(value = "/user")
@Api(description = "首页")
public class UserController {

    @RequestMapping("/*")
    public void toHtml(){

    }
}
