package com.oauth.server.exception;

/**
 * @ProjectName: hqjcloud
 * @Package: com.oauth.server.exception
 * @ClassName: AuthFailureException
 * @Description: 认证失败
 * @Author: lic
 * @CreateDate: 2019/11/5 11:52
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/5 11:52
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class AuthFailureException extends RuntimeException {

    public AuthFailureException() {
        this("认证失败！");
    }

    public AuthFailureException(String message) {
        super(message);
    }
}

