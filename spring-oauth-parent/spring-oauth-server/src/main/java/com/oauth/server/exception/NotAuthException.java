package com.oauth.server.exception;

/**
 * @ProjectName: hqjcloud
 * @Package: com.oauth.server.exception
 * @ClassName: NotAuthException
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/11/5 11:52
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/5 11:52
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class NotAuthException extends RuntimeException {

    public NotAuthException() {
        this("没有认证！");
    }

    public NotAuthException(String message) {
        super(message);
    }
}