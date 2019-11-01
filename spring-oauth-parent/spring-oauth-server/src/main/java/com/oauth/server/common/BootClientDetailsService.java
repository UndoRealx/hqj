package com.oauth.server.common;

import com.oauth.server.beans.Client;
import com.oauth.server.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: hqjcloud
 * @Package: com.oauth.server.common
 * @ClassName: BootClientDetailsService
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/11/1 16:51
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/1 16:51
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Component
public final class BootClientDetailsService implements ClientDetailsService {

    @Autowired
    private IClientService clientService;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

        Client client = this.clientService.findClientByClientId(clientId);

        if(client==null){
            throw new ClientRegistrationException("客户端不存在");
        }

        return new BootClientDetails(client);
    }

}
