package com.oauth.server.common;

import com.oauth.server.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.oauth.server.beans.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: hqjcloud
 * @Package: com.oauth.server.common
 * @ClassName: BootUserDetailService
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/11/1 15:30
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/1 15:30
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Component
public class BootUserDetailService implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User entity= this.userService.findByUserName(username);

        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(authority);


        if(entity==null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
  /*      user.setAuthorities(authorities);*/

        return new org.springframework.security.core.userdetails.User(entity.getUsername(), passwordEncoder.encode(entity.getPassword()), authorities);
    }
}
