package com.oauth.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ProjectName: hqjcloud
 * @Package: com.oauth.server.controller
 * @ClassName: LoginController
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/31 11:31
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/31 11:31
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
public class LoginController {

    /**
     * 自定义登录页面
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

}