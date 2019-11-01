package com.oauth.server.beans;

import lombok.Data;

/**
 * @ProjectName: hqjcloud
 * @Package: com.oauth.server.beans
 * @ClassName: BaseResponse
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/11/1 17:48
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/1 17:48
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Data
public  class BaseResponse  {

    private int status;
    private String msg;

    protected BaseResponse() {
    }

    protected BaseResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}