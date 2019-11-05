package com.oauth.server.controller;

import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ProjectName: hqjcloud
 * @Package: com.oauth.server.controller
 * @ClassName: BootGrantController
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/11/4 16:13
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/4 16:13
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
@SessionAttributes("authorizationRequest")
public class BootGrantController {

    @RequestMapping("/custom/confirm_access")
    public ModelAndView getAccessConfirmation(Map<String, Object> model, HttpServletRequest request) throws Exception {

        AuthorizationRequest authorizationRequest = (AuthorizationRequest) model.get("authorizationRequest");


        ModelAndView view = new ModelAndView();
        view.setViewName("base-grant");

        view.addObject("clientId", authorizationRequest.getClientId());
        view.addObject("scopes",authorizationRequest.getScope());

        return view;
    }

}
