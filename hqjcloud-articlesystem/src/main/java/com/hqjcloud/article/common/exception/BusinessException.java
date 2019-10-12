/*
package com.hqjcloud.article.common.exception;


import com.hqjcloud.article.common.enums.StateCode;

*/
/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.base.exception
 * @ClassName: BusinessException
 * @Description:业务异常
 * @Author: lic
 * @CreateDate: 2019/9/11 16:33
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/11 16:33
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 *//*

public class BusinessException extends RuntimeException{
    */
/**
     * 异常码
     *//*

    protected StateCode code;

    private static final long serialVersionUID = 3160241586346324994L;

    public BusinessException() {
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(StateCode code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(StateCode code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
    }

    public BusinessException(StateCode codeEnum, Object... args) {
        super(String.format(codeEnum.msg(), args));
        this.code = codeEnum;
    }

    public StateCode getCode() {
        return code;
    }

    public void setCode(StateCode code) {
        this.code = code;
    }
}
*/
