package com.hqjcloud.base;

import com.hqjcloud.base.enums.StateCode;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.base
 * @ClassName: ApiResultEntity
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/20 11:37
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/20 11:37
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ApiResultEntity {
    private int code;
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    private Object data;
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    private String msg;
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

    //统一返回状态码
    public static ApiResultEntity returnResult(int code) {
        ApiResultEntity returnVal = new ApiResultEntity();
        String msg = StateCode.get(code);
        returnVal.setCode(code);
        returnVal.setMsg(msg);
        returnVal.setData(null);
        return returnVal;
    }

    public static ApiResultEntity successResult(Object data) {
        ApiResultEntity returnVal = new ApiResultEntity();
        String msg = StateCode.get(StateCode.success.get());
        returnVal.setCode(StateCode.success.get());
        returnVal.setMsg(msg);
        returnVal.setData(data);
        return returnVal;
    }

    public static ApiResultEntity returnResult(int code,Object obj) {
        ApiResultEntity returnVal = new ApiResultEntity();
        String msg = StateCode.get(code);
        returnVal.setCode(code);
        returnVal.setMsg(msg);
        returnVal.setData(obj);
        return returnVal;
    }

}
