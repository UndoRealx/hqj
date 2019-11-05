package com.oauth.server.service.impl;

import com.oauth.server.beans.Client;
import com.oauth.server.beans.ClientExample;
import com.oauth.server.mapper.ClientExMapper;
import com.oauth.server.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: hqjcloud
 * @Package: com.oauth.server.service.impl
 * @ClassName: ClientServiceImpl
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/11/1 17:13
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/1 17:13
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
public class ClientServiceImpl implements IClientService{

    @Autowired
    private ClientExMapper mapper;

   @Override
   public Client findClientByClientId(String clientId)
   {
       ClientExample example = new ClientExample();
       ClientExample.Criteria criteria = example.createCriteria();
       criteria.andClientidEqualTo(clientId);
       List<Client> lists = mapper.selectByExample(example);
       return lists.isEmpty()==false?lists.get(0):null;
   }

    @Override
    public boolean Save(Client client)
    {
        return  mapper.insertSelective(client)>0;
    }
}
