package com.hqjcloud.article.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
@RequestMapping(value = "/")
@Api(description = "首页")
public class IndexController{

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }


}
