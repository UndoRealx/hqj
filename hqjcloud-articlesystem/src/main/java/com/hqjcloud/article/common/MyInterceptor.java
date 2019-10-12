/*
package com.hqjcloud.article.common;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

*/
/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.common
 * @ClassName: MyFilter
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/11 10:13
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/11 10:13
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 *//*

public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String url = request.getRequestURI();

        System.out.println(request.getContextPath());
        return  true;
      */
/*  System.out.println(url);
        if (url.contains(request.getContextPath()+"/js/utf8-jsp/jsp/controller.jsp"))
        {
            System.out.println("使用自定义过滤器");
            return  true;
        }else{
            System.out.println("使用默认过滤器");
            return  true;
        }*//*



    }

   */
/* @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        String url = request.getRequestURI();
        System.out.println(url);
        if (url.contains(request.getContextPath()+"/js/utf8-jsp/jsp/controller.jsp")) {
            System.out.println("使用自定义过滤器");
            chain.doFilter(req, res);
        }else{
            System.out.println("使用默认过滤器");
            super.doFilter(req, res, chain);
        }
    }*//*


}
*/
