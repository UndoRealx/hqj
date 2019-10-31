package com.hqjcloud.article.controller;

import com.baidu.ueditor.ActionEnter;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.controller
 * @ClassName: ServerController
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/10 14:02
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/10 14:02
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
public class ServerController {
@RequestMapping(value="/com.oauth.server.config")
    public void config(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        String rootPath = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/ueditor/jsp";
        try {
            response.setCharacterEncoding("UTF-8");
            String exec = new ActionEnter(request, rootPath).exec();
            System.out.println(exec);
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    //return "redirect:static/ueditor/jsp/com.oauth.server.config.json";
    }



}