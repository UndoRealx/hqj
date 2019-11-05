package com.oauth.server.filter;

import com.oauth.server.dto.response.BaseResponse;
import com.oauth.server.dto.response.HttpResponse;


import com.oauth.server.common.HttpUtils;
import com.oauth.server.support.oauth2.BootClientDetails;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.ClientDetailsService;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;
/**
 * @ProjectName: hqjcloud
 * @Package: com.oauth.server.common
 * @ClassName: BootBasicAuthenticationFilter
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/11/5 10:18
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/5 10:18
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Component
public class BootBasicAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private ClientDetailsService clientDetailsService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        if (!request.getRequestURI().equals("/oauth/token") ||
                !request.getParameter("grant_type").equals("password")) {
            filterChain.doFilter(request, response);
            return;
        }

        String[] clientDetails = this.isHasClientDetails(request);

        if (clientDetails == null) {
            BaseResponse bs = HttpResponse.baseResponse(HttpStatus.UNAUTHORIZED.value(), "请求中未包含客户端信息");
            HttpUtils.writerError(bs, response);
            return;
        }

        this.handle(request,response,clientDetails,filterChain);


    }

    private void handle(HttpServletRequest request, HttpServletResponse response, String[] clientDetails,FilterChain filterChain) throws IOException, ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            filterChain.doFilter(request,response);
            return;
        }


        BootClientDetails details = (BootClientDetails) this.clientDetailsService.loadClientByClientId(clientDetails[0]);
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(details.getClientId(), details.getClientSecret(), details.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(token);


        filterChain.doFilter(request,response);
    }

    // 判断请求头中是否包含client信息，不包含返回false
    private String[] isHasClientDetails(HttpServletRequest request) {

        String[] params = null;

        String header = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (header != null) {

            String basic = header.substring(0, 5);

            if (basic.toLowerCase().contains("basic")) {

                String tmp = header.substring(6);
                String defaultClientDetails = new String(Base64.getDecoder().decode(tmp));

                String[] clientArrays = defaultClientDetails.split(":");

                if (clientArrays.length != 2) {
                    return params;
                } else {
                    params = clientArrays;
                }

            }
        }

        String id = request.getParameter("client_id");
        String secret = request.getParameter("client_secret");

        if (header == null && id != null) {
            params = new String[]{id, secret};
        }


        return params;
    }

    public ClientDetailsService getClientDetailsService() {
        return clientDetailsService;
    }

    public void setClientDetailsService(ClientDetailsService clientDetailsService) {
        this.clientDetailsService = clientDetailsService;
    }
}
