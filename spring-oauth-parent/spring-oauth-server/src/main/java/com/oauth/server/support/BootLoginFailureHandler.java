package com.oauth.server.support;

import com.oauth.server.common.HttpUtils;
import com.oauth.server.dto.response.HttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: hqjcloud
 * @Package: com.oauth.server.support
 * @ClassName: BootLoginFailureHandler
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/11/5 13:59
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/5 13:59
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Component
public class BootLoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        HttpUtils.writerError(HttpResponse.baseResponse(401,exception.getMessage()),response);
    }
}
