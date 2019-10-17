package com.hqjcloud.upms.config;

import com.hqjcloud.upms.beans.User;
import com.hqjcloud.upms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.upms.config
 * @ClassName: CustomUserDetailsService
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/14 17:30
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/14 17:30
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User entity=userService.getByName(userName);
        if(null==entity)
        {
            throw new UsernameNotFoundException("User " + userName + " was not found in db");
        }
        // 2. 设置角色
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" +  "ADMIN");//ADMIN
        GrantedAuthority grantedAuthority2 = new SimpleGrantedAuthority("ROLE_"+ "USER");//USER
        grantedAuthorities.add(grantedAuthority);
        grantedAuthorities.add(grantedAuthority2);

        return new org.springframework.security.core.userdetails.User(entity.getUsername(),
                entity.getPassword(), grantedAuthorities);
    }
}
