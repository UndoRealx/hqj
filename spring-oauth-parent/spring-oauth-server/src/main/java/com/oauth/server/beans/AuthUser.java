package com.oauth.server.beans;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * @ProjectName: hqjcloud
 * @Package: com.oauth.server.beans
 * @ClassName: AuthUser
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/11/4 11:14
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/4 11:14
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */

public class AuthUser extends User implements UserDetails  {

    private static final long serialVersionUID = 1L;

    private List<GrantedAuthority> authorities;

    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return getIslocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return getIsenable();
    }
}
