package com.oauth.server.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @ProjectName: hqjcloud
 * @Package: com.oauth.server.common
 * @ClassName: OAuth2Exception
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/11/5 10:08
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/5 10:08
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@JsonSerialize(using = BootOAuthExceptionJacksonSerializer.class)
public class BootOAuth2Exception extends OAuth2Exception {
    public BootOAuth2Exception(String msg, Throwable t) {
        super(msg, t);
    }

    public BootOAuth2Exception(String msg) {
        super(msg);
    }
}