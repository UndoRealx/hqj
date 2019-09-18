package com.hqjcloud.provider.service;

import com.hqjcloud.provider.domain.CityEntity;
import com.hqjcloud.provider.service.hystrix.CityFeignHystrix;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.provider.service
 * @ClassName: CityFeignApi
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/11 17:31
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/11 17:31
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@FeignClient(value = "hqjcloud-provider-common", fallback = CityFeignHystrix.class)
public interface CityFeignApi {
    
    /**
    *@Description  获取城市列表
    *@Param  * @param pid
    *@Return java.util.List<com.hqjcloud.provider.domain.CityEntity>
    *@Author lic
    *@Date 2019/9/12
    *@Time 9:07
    */

    @PostMapping(value = "/api/city/getCityList")
    public List<CityEntity> getCityList(Long pid);

   
}
