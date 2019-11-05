package com.oauth.server.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oauth.server.dto.response.BaseResponse;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: hqjcloud
 * @Package: com.oauth.server.common
 * @ClassName: HttpUtils
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/11/5 10:20
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/5 10:20
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class HttpUtils {

    public static void writerError(BaseResponse bs, HttpServletResponse response) throws IOException {
        response.setContentType("application/json,charset=utf-8");
        response.setStatus(bs.getStatus());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getOutputStream(),bs);
    }

}