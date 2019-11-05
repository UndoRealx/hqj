package com.oauth.server.support.oauth2;

import com.oauth.server.beans.Client;
import com.oauth.server.common.CommonUtils;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @ProjectName: hqjcloud
 * @Package: com.oauth.server.common
 * @ClassName: BootClientDetails
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/11/1 17:17
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/1 17:17
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Data
public final class BootClientDetails implements ClientDetails {

    private Client client;

    public BootClientDetails(Client client) {
        this.client = client;
    }

    public BootClientDetails() {
    }

    @Override
    public String getClientId() {
        return client.getClientid();
    }

    @Override
    public Set<String> getResourceIds() {
        return client.getResourceids()!=null?
                CommonUtils.transformStringToSet(client.getResourceids(),String.class):null;
    }

    @Override
    public boolean isSecretRequired() {
        return client.getIssecretrequired();
    }

    @Override
    public String getClientSecret() {
        return client.getClientsecret();
    }

    @Override
    public boolean isScoped() {
        return client.getIsscoped();
    }

    @Override
    public Set<String> getScope() {
        return client.getScope()!=null?
                CommonUtils.transformStringToSet(client.getScope(),String.class):null;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return client.getAuthorizedgranttypes()!=null?
                CommonUtils.transformStringToSet(client.getAuthorizedgranttypes(),String.class):null;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return client.getRegisteredredirecturi()!=null?
                CommonUtils.transformStringToSet(client.getRegisteredredirecturi(),String.class):null;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return (client.getAuthorities()!=null&&client.getAuthorities().trim().length()>0)?
                AuthorityUtils.commaSeparatedStringToAuthorityList(client.getAuthorities()):null;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return client.getAccesstokenvalidityseconds();
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return client.getRefreshtokenvalidityseconds();
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return client.getIsautoapprove();
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}
