package com.oauth.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: hqjcloud
 * @Package: com.oauth.server.controller
 * @ClassName: TestController
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/11/4 16:47
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/4 16:47
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@RestController
public class TestController {

    @GetMapping("/other")
    public String test(){
        return "other";
    }

}
