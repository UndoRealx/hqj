package com.hqjcloud.article.controller;


import com.alibaba.fastjson.JSON;
import com.hqjcloud.article.common.TimeUtil;
import com.hqjcloud.article.dto.repose.ReturnUploadImage;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.UUID;

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
@RequestMapping(value="/ueditor")
public class UeditorController {

    @RequestMapping("/*")
    public void toHtml(){

    }

    //src="/Path/2019-10-21/502ae412-7fb6-4c3c-94d6-ecec893f410c.jpg"
    @RequestMapping(value = "/multiUpload", method = RequestMethod.POST)
    @ResponseBody
    public  ReturnUploadImage multiUpload(HttpServletRequest request) throws  IOException {
        MultipartFile file = ((MultipartHttpServletRequest) request).getFile("file");
        Date now=new Date();
        String filePath = "D:/Upload/" + TimeUtil.dateToString(now)+"/";
        File upload = new File(filePath);
        if (!upload.exists()) {
            upload.mkdirs();
        }


        String fileName = file.getOriginalFilename();
        String newFileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."), fileName.length());
        File dest = new File(filePath + newFileName);
        try {
            file.transferTo(dest);

        } catch (IOException e) {
                throw e;
        }

        ReturnUploadImage rui = new ReturnUploadImage();
        if (dest != null) {
            rui.setState("SUCCESS");
            rui.setUrl("/" + TimeUtil.dateToString(now)+"/"+newFileName);
            rui.setTitle("上传成功!");
            rui.setOriginal(fileName);
        }

        return rui;
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
       public  String uploadFile(HttpServletRequest request, HttpServletResponse response) throws  Exception {
        response.setContentType("text/html;charset=UTF-8");

        //转型为MultipartHttpServletRequest
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;

        //获得文件
        MultipartFile file = multipartHttpServletRequest.getFile("upfile")==null?multipartHttpServletRequest.getFile("file"):multipartHttpServletRequest.getFile("upfile");

        //文件存储路径
        String savePath = "\\Upload\\";

        //接收的文件流
        InputStream inputStream = file.getInputStream();

        //接收的文件名
        String fileName = file.getOriginalFilename();

        String newFileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."), fileName.length());

        String urlName = savePath + newFileName;

        File tempFile = new File(urlName);

        try {
            FileUtils.copyInputStreamToFile(inputStream, tempFile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        ReturnUploadImage rui = new ReturnUploadImage();
        if (tempFile != null) {
            rui.setState("SUCCESS");
            rui.setUrl("/ueditor/getfile?fileName=" + newFileName);
            rui.setTitle(fileName);
            rui.setOriginal(fileName);
        }

        String result = JSON.toJSONString(rui);
        response.getWriter().write(result);
        return null;
    }


    @RequestMapping(value = "/getfile",method = RequestMethod.GET)
    public  void  getFile(String fileName, HttpServletResponse response) throws  Exception
    {
        //文件存储路径
        String savePath = "\\Upload\\";
        // 文件路径(windows下是\\，linux下是//，都必须是绝对路径)
        File filePic=new File(savePath+fileName);
        if(filePic.exists())
        {
            FileInputStream inputStream=new FileInputStream(filePic);
            int i=inputStream.available();//得到 文件大小
            byte data[]=new byte[i];
            inputStream.read(data);
            inputStream.close();
            response.setContentType("multipart/form-data");
            OutputStream toClient=response.getOutputStream();
            toClient.write(data);
            toClient.close();
        }
    }

}

