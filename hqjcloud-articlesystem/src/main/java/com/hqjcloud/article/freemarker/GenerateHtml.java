package com.hqjcloud.article.freemarker;


import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用freemarker生成HTML文件
 */
public class GenerateHtml {

    /**
     * 根据模板生成html文件
     * @param request
     * @param templateName	模板名称
     * @param htmlName	html文件名称
     */
    public static void generate(HttpServletRequest request, String templateName, String htmlName){
        FileOutputStream fos = null;
        Writer writer = null;
        try {
            HttpSession session = request.getSession();
            String root = session.getServletContext().getRealPath("templates/*/*");// 根目录

            // 设置相关配置
            Configuration configuration = new Configuration();
            configuration.setDirectoryForTemplateLoading(new File(root + File.separator + "template"));//	模板存放地址
            configuration.setObjectWrapper(new DefaultObjectWrapper());
            configuration.setDefaultEncoding("UTF-8");// 默认编码

            // 根据模板名称获取模板
            Template template = configuration.getTemplate(templateName);

            // 设置模板参数
            Map<String, Object> paramMap = new HashMap<String, Object>();// 模板参数
            if ("newsAdd.html".equals(templateName)) {// 文章
                paramMap.put("student", request.getAttribute("student"));// 学生
                paramMap.put("awardList", request.getAttribute("awardList"));// 获奖记录列表
            }

            // 生成输出流
            File html = new File(root + File.separator + "html/student", htmlName);// html文件
            if (html.exists()) {// 文件已存在时删除原有文件
                html.delete();
            }
            fos = new FileOutputStream(html);
            writer = new OutputStreamWriter(fos,"UTF-8");

            // 生成模板
            template.process(paramMap, writer);

            System.out.println("成功生成html文件--" + htmlName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
