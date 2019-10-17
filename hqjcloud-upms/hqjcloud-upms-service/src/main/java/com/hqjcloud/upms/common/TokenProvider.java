package com.hqjcloud.upms.common;

import com.hqjcloud.upms.beans.Token;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.upms.common
 * @ClassName: TokenProvider
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/15 16:57
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/15 16:57
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Component
public class TokenProvider {
    private  String secretKey;
    private  int tokenValidity;

    public TokenProvider() {

    }
    public TokenProvider(String secretKey, int tokenValidity) {
        this.secretKey = secretKey;
        this.tokenValidity = tokenValidity;
    }
    // 生成token
    public Token createToken(UserDetails userDetails) {
        long expires = System.currentTimeMillis() + 1000L * tokenValidity;
        String token = computeSignature(userDetails, expires);
        return new Token(token, expires);
    }
    // 验证token
    public boolean validateToken(String authToken, UserDetails userDetails) {
        //check token
        return true;
    }
    // 从token中识别用户
    public String getUserNameFromToken(String authToken) {
        // ……
        if(null==authToken)
        {
            return  null;
        }

        if(authToken.contains("_")==false)
        {
            return  null;
        }
        String[] info=authToken.split("_");
        if(info.length!=3)
        {
            return  null;
        }
        return info[0];
    }
    public String computeSignature(UserDetails userDetails, long expires) {
        // 一些特有的信息组装 ,并结合某种加密活摘要算法
        return  userDetails.getUsername()+"_"+expires+"_"+MD5Util.md5(userDetails.getPassword()+String.valueOf(expires)+userDetails.getUsername());
    }
}
