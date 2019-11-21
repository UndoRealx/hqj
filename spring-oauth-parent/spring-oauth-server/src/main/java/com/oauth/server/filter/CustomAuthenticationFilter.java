package com.oauth.server.filter;

import com.oauth.server.common.AuthenticationBean;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * 支持其余登录（json登录）和表单登录的AuthenticationFilter.
 * @author chenhuanming
 */

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    //重写UsernamePasswordAuthenticationFilter  中attemptAuthentication方法
        public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

            if (request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE)//验证接受数据格式和字符集
                  || request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)){

                //use jackson to deserialize json
                ObjectMapper mapper = new ObjectMapper();
                UsernamePasswordAuthenticationToken authRequest = null;

                try (InputStream is = request.getInputStream()){
                    AuthenticationBean authenticationBean = mapper.readValue(is, AuthenticationBean.class); //json赋值给类
                    authRequest = new UsernamePasswordAuthenticationToken(
                            authenticationBean.getUsername(), authenticationBean.getPassword());
                }catch (IOException e) {
                    e.printStackTrace();
                     authRequest = new UsernamePasswordAuthenticationToken("", "");//验证异常给出空串
                }finally {
                    setDetails(request, authRequest);//设置请求体 验证令牌
                    return this.getAuthenticationManager().authenticate(authRequest);//验证令牌
                }
            }

            //传到 UsernamePasswordAuthenticationFilter
            else {
                return super.attemptAuthentication(request, response);
            }
        }
}
