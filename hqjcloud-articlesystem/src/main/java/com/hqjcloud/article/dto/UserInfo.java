package com.hqjcloud.article.dto;

import com.hqjcloud.article.beans.SysUser;

import java.io.Serializable;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.dto
 * @ClassName: UserInfo
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/9 15:50
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/9 15:50
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class UserInfo extends SysUser implements Serializable {

    private RoleInfo roleInfo;

    public RoleInfo getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(RoleInfo roleInfo) {
        this.roleInfo = roleInfo;
    }

    /**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
        return this.getUserName() + this.getSalt();
    }
    //重新对盐重新进行了定义，用户名+salt，这样就更加不容易被破解
}