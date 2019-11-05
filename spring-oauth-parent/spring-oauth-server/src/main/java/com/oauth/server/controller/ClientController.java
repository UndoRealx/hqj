package com.oauth.server.controller;

import com.oauth.server.dto.response.BaseResponse;
import com.oauth.server.beans.Client;
import com.oauth.server.dto.response.HttpResponse;
import com.oauth.server.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Console;

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
    
    @PostMapping("/passTest")
    public  String  Pass(@RequestParam String key)
    {
        String  value=passwordEncoder.encode(key);
        System.out.println(value);
        return  value;
    }

}
