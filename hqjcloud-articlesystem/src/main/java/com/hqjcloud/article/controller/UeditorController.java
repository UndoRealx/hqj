package com.hqjcloud.article.controller;

import com.hqjcloud.article.beans.PublicMsg;
import com.hqjcloud.article.beans.Ueditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.controller
 * @ClassName: UeditorController
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/29 17:28
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/29 17:28
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
public class UeditorController {

    @RequestMapping("/")
    private String showPage(){
        return "index";
    }

    @RequestMapping(value="/ueditor")
    @ResponseBody
    public String ueditor(HttpServletRequest request) {

        return PublicMsg.UEDITOR_CONFIG;
    }

    @RequestMapping(value="/imgUpload")
    @ResponseBody
    public Ueditor imgUpload(MultipartFile upfile) {
        Ueditor ueditor = new Ueditor();
        return ueditor;
    }
}
