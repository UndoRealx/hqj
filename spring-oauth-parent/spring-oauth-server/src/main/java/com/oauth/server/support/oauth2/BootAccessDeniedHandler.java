package com.oauth.server.support.oauth2;

import com.oauth.server.dto.response.HttpResponse;
import com.oauth.server.common.HttpUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: hqjcloud
 * @Package: com.oauth.server.config.oauth2
 * @ClassName: BootAccessDeniedHandler
 * @Description: 请求拒绝，没有权限
 * @Author: lic
 * @CreateDate: 2019/11/5 11:39
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/5 11:39
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Component
public class BootAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException ex) throws IOException, ServletException {
        HttpUtils.writerError(HttpResponse.baseResponse(HttpStatus.FORBIDDEN.value(),"没有权限"),response);
    }
}
