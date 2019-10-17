package com.hqjcloud.upms.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.upms.config
 * @ClassName: MyPasswordEncoder
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/14 16:46
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/14 16:46
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
