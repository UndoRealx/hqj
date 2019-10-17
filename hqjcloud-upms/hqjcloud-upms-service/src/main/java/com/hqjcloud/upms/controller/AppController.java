package com.hqjcloud.upms.controller;

import com.hqjcloud.upms.beans.Token;
import com.hqjcloud.upms.common.MD5Util;
import com.hqjcloud.upms.common.TokenProvider;
import com.hqjcloud.upms.common.lichenglicheng;
import com.hqjcloud.upms.config.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.upms.controller
 * @ClassName: AppController
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/14 15:47
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/14 15:47
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
@RequestMapping("/auth")
public class AppController {
    @RequestMapping("/hello")
    @ResponseBody
    String home() {
        return "Hello ,spring security!";
    }



    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private lichenglicheng sanba;

    @Autowired
    private CustomUserDetailsService userDetailsService;


    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping("/login")
    public ResponseEntity<?> refreshAndGetAuthenticationToken(
            @RequestParam String username,
            @RequestParam String password) throws AuthenticationException {
        return ResponseEntity.ok(generateToken(username, password));
    }

    /**
     * 登陆与授权.
     *
     * @param username .
     * @param password .
     * @return
     */
    private String generateToken(String username, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Reload password post-security so we can generate token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        // 持久化的redis
        String token = MD5Util.md5(userDetails.getUsername());
        //redisTemplate.opsForValue().set(token, userDetails.getUsername());
        return token;
    }

    @RequestMapping(value = "/authenticate",method = RequestMethod.GET)
    @ResponseBody
    public Token authorize(@RequestParam String username, @RequestParam String password)
    {

        // 1 创建UsernamePasswordAuthenticationToken
        UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(username,password);
        //认证
        Authentication authentication=authenticationManager.authenticate(token);

        //3 保存认证信息
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //4 加载UserDetails

        UserDetails details=this.userDetailsService.loadUserByUsername(username);

        //5 生成自定义的token
        return  tokenProvider.createToken(details);

    }
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    @ResponseBody
    public String hi()
    {
       return sanba.test();

    }

}