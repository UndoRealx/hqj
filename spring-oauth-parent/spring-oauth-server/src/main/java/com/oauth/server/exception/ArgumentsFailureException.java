package com.oauth.server.exception;

/**
 * @ProjectName: hqjcloud
 * @Package: com.oauth.server.exception
 * @ClassName: ArgumentsFailureException
 * @Description: 参数不正确
 * @Author: lic
 * @CreateDate: 2019/11/5 11:52
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/5 11:52
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ArgumentsFailureException extends RuntimeException {

    public ArgumentsFailureException() {
        this("参数错误");
    }

    public ArgumentsFailureException(String message) {
        super(message);
    }
}
