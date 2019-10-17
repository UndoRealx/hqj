package com.hqjcloud.upms.beans;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.upms.beans
 * @ClassName: Token
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/15 17:01
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/15 17:01
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Token {

    private  String token;

    private  long expires;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpires() {
        return expires;
    }

    public void setExpires(long expires) {
        this.expires = expires;
    }

    public Token(String myToken,long myExpires)
    {
        setToken(myToken);
        setExpires(myExpires);
    }
}
