package com.oauth.server.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @ProjectName: hqjcloud
 * @Package: com.oauth.server.exception
 * @ClassName: VerificationCodeFailureException
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/11/5 11:53
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/5 11:53
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class VerificationCodeFailureException extends AuthenticationException {

    public VerificationCodeFailureException(String msg, Throwable t) {
        super(msg, t);
    }

    public VerificationCodeFailureException(String msg) {
        super(msg);
    }
}