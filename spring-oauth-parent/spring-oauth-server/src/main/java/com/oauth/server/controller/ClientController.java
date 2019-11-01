package com.oauth.server.controller;

import com.oauth.server.beans.BaseResponse;
import com.oauth.server.beans.Client;
import com.oauth.server.service.IClientService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @ProjectName: hqjcloud
 * @Package: com.oauth.server.controller
 * @ClassName: ClientController
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/11/1 17:45
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/1 17:45
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public BaseResponse clientRegistered(@RequestBody @Valid Client client){
        client.setClientsecret(passwordEncoder.encode(client.getClientsecret()));
        boolean i = clientService.Save(client);
        return HttpResponse.baseResponse(200);
    }

}
