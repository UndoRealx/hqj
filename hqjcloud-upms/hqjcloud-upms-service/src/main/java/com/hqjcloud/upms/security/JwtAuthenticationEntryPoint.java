package com.hqjcloud.upms.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.upms.security
 * @ClassName: JwtAuthenticationEntryPoint
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/17 14:57
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/17 14:57
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    
    /**
    *@Description 实现AuthenticationEntryPoint这个接口，发现没有凭证，往response中放些东西。
    *@Param  * @param request
 * @param response
 * @param authException
    *@Return void
    *@Author lic
    *@Date 2019/10/17
    *@Time 15:20
    */
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException)
            throws IOException, ServletException {

        System.out.println("JwtAuthenticationEntryPoint:"+authException.getMessage());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"没有凭证");
    }
}