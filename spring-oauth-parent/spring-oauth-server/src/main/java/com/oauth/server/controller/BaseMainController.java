package com.oauth.server.controller;

import com.oauth.server.support.properities.BootSecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ProjectName: hqjcloud
 * @Package: com.oauth.server.controller
 * @ClassName: BaseMainController
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/11/4 15:28
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/4 15:28
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
public class BaseMainController {
    @Autowired
    private BootSecurityProperties properties;

    @GetMapping("/auth/login")
    public String loginPage(Model model){
        model.addAttribute("loginProcessUrl",properties.getLoginProcessUrl());
        return "base-login";
    }
}

