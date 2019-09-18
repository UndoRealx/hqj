package com.hqjcloud.provider.service.hystrix;

import com.hqjcloud.provider.domain.CityEntity;
import com.hqjcloud.provider.service.CityFeignApi;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.provider.service.hystrix
 * @ClassName: CityFeignHystrix
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/12 9:10
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/12 9:10
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Component
public class CityFeignHystrix implements CityFeignApi {
    
    /**
    *@Description 获取城市列表
    *@Param  * @param pid
    *@Return java.util.List<com.hqjcloud.provider.domain.CityEntity>
    *@Author lic
    *@Date 2019/9/12
    *@Time 9:37
    */
    @Override
    public List<CityEntity> getCityList(Long pid) {
        return null;
    }
}
