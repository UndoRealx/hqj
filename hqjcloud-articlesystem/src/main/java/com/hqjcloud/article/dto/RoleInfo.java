package com.hqjcloud.article.dto;

import com.hqjcloud.article.beans.SysPermission;
import com.hqjcloud.article.beans.SysRole;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.dto
 * @ClassName: RoleInfo
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/9 15:51
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/9 15:51
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class RoleInfo extends SysRole implements Serializable {

    private List<SysPermission> permissions;

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }
}
