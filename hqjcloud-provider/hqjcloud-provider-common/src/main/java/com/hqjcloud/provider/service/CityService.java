package com.hqjcloud.provider.service;



import com.hqjcloud.provider.domain.CityEntity;

import java.util.List;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.provider.service
 * @ClassName: CityService
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/12 9:52
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/12 9:52
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface CityService{

    public List<CityEntity> getCityList(Long pid);
}
