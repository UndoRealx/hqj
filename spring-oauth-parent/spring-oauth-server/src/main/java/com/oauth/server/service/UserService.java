package com.oauth.server.service;


import com.oauth.server.beans.User;

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

    public User findByUserName(String userName);

}
