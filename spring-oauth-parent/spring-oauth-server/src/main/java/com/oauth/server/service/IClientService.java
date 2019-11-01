package com.oauth.server.service;

import com.oauth.server.beans.Client;
import org.apache.ibatis.annotations.Param;

/**
 * @ProjectName: hqjcloud
 * @Package: com.oauth.server.service
 * @ClassName: IClientService
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/11/1 17:12
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/1 17:12
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface IClientService {
    Client findClientByClientId(@Param("id") String clientId);

    boolean Save(Client client);
}
