package com.oauth.server.exception;

/**
 * @ProjectName: hqjcloud
 * @Package: com.oauth.server.exception
 * @ClassName: NotAuthorityException
 * @Description: 没有权限
 * @Author: lic
 * @CreateDate: 2019/11/5 11:53
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/5 11:53
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class NotAuthorityException extends RuntimeException{

    public NotAuthorityException() {
        this("没有权限！");
    }

    public NotAuthorityException(String message) {
        super(message);
    }
}
