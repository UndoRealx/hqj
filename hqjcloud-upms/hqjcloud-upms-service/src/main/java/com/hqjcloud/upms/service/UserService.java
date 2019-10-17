package com.hqjcloud.upms.service;

import com.hqjcloud.upms.beans.User;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.upms.service
 * @ClassName: UserService
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/15 14:45
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/15 14:45
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface UserService {

    public User getByName(String userName);

}
