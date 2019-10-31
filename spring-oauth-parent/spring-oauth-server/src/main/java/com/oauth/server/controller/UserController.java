package com.oauth.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @ProjectName: hqjcloud
 * @Package: com.oauth.server.controller
 * @ClassName: UserController
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/31 11:31
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/31 11:31
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@RestController
public class UserController {

    /**
     * 资源服务器提供的受保护接口
     * @param principal
     * @return
     */
    @RequestMapping("/user")
    public Principal user(Principal principal) {
        System.out.println(principal);
        return principal;
    }

}