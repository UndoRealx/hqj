package com.hqjcloud.provider.service.Impl;

//import com.hqjcloud.provider.domain.CityEntity;
import com.hqjcloud.provider.domain.CityEntity;
import com.hqjcloud.provider.mapper.CityExMapper;
import com.hqjcloud.provider.service.CityService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.provider.service.Impl
 * @ClassName: CityServiceImpl
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/12 9:57
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/12 9:57
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
public class CityServiceImpl implements CityService {


    private CityExMapper cityExMapper;
    /**
    *@Description
    *@Param  * @param pid
    *@Return java.util.List<com.hqjcloud.provider.domain.CityEntity>
    *@Author lic
    *@Date 2019/9/12
    *@Time 15:33
    */
    @Override
    public List<CityEntity> getCityList(Long pid)
    {
        return  new ArrayList<CityEntity>();
    }
}
