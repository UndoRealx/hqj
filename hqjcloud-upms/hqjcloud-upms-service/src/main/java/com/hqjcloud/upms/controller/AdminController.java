package com.hqjcloud.upms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.upms.controller
 * @ClassName: AdminController
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/14 16:13
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/14 16:13
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("/home")
    @ResponseBody
    public String productInfo(){
        return " admin home page ";
    }
}