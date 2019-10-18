package com.hqjcloud.upms.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

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
public class JwtTokenUtil implements Serializable {
    private static final long serialVersionUID = -3301605591108950415L;

    @Value("${jwt.secret}")
    private  String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    @Value("${jwt.token}")
    private String tokenHeader;

    private Clock clock = DefaultClock.INSTANCE;

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        final Date createdDate = clock.now();
        final Date expirationDate = calculateExpirationDate(createdDate);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    private Date calculateExpirationDate(Date createdDate) {
        return new Date(createdDate.getTime() + expiration);
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        UserDetails user = (UserDetails) userDetails;
        final String username = getUsernameFromToken(token);
        return (username.equals(user.getUsername())
                && !isTokenExpired(token)
        );
    }

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }


    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(clock.now());
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }
    /*
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
    }*/
}
