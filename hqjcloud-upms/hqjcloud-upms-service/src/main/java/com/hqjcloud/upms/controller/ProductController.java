package com.hqjcloud.upms.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.upms.controller
 * @ClassName: ProductController
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/14 16:12
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/14 16:12
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @RequestMapping("/info")
    @ResponseBody
    public String productInfo(){
        String currentUser="";
        Object principl= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principl instanceof UserDetails)
        {
            currentUser=((UserDetails)principl).getUsername();
        }
        else
        {
            currentUser=principl.toString();
        }
        return   " some product info,currentUser is: "+currentUser;
    }

    @RequestMapping("/info")
    @ResponseBody
    @PreAuthorize("isAnonymous()")
    public String test(){
         return  "1-9";
    }
}