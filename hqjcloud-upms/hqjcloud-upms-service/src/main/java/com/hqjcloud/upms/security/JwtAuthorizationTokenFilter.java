package com.hqjcloud.upms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.upms.common
 * @ClassName: MyTokenFilter
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/16 9:44
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/16 9:44
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Component
public class JwtAuthorizationTokenFilter extends GenericFilterBean {

//private  final  Longger longger= LoggerFactory.getLogger(MyTokenFilter.class);
    private final static String XAUTH_TOKEN_HEADER_NAME = "authtoken";
    private UserDetailsService detailsService;
    @Autowired
    private JwtTokenUtil tokenProvider;
    public JwtAuthorizationTokenFilter(UserDetailsService detailsService, JwtTokenUtil tokenProvider) {
        this.detailsService = detailsService;
        this.tokenProvider = tokenProvider;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {
            HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
            String authToken=httpServletRequest.getHeader(XAUTH_TOKEN_HEADER_NAME);
            if(StringUtils.hasText(authToken))
            {
                //从自定义tokenProvider中解析用户
                String username=this.tokenProvider.getUsernameFromToken(authToken);
                // 这里仍然是调用我们自定义的UserDetailsService，查库，检查用户名是否存在，
                // 如果是伪造的token,可能DB中就找不到username这个人了，抛出异常，认证失败
                UserDetails details = this.detailsService.loadUserByUsername(username);
                if (this.tokenProvider.validateToken(authToken, details)) {
                    //log.debug(" validateToken ok...");
                    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(details, details.getPassword(), details.getAuthorities());
                    // 这里还是上面见过的，存放认证信息，如果没有走这一步，下面的doFilter就会提示登录了
                    SecurityContextHolder.getContext().setAuthentication(token);
                }
            }
            filterChain.doFilter(servletRequest,servletResponse);
        }
        catch (Exception ex)
        {
            throw  new RuntimeException(ex);
        }
    }
}
