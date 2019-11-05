package com.oauth.server.support.properities;

import lombok.Getter;
import lombok.Setter;

/**
 * @ProjectName: hqjcloud
 * @Package: com.oauth.server.common
 * @ClassName: BootSmsCodeProperties
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/11/4 16:03
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/4 16:03
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Getter
@Setter
public class BootSmsCodeProperties {

    private Integer expirationTime = 240;
    private Integer length = 4;
    private String mobileParameter = "mobile";


}