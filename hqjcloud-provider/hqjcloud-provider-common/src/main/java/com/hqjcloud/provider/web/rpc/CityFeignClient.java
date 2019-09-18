package com.hqjcloud.provider.web.rpc;


import com.hqjcloud.provider.domain.CityEntity;
import com.hqjcloud.provider.service.CityFeignApi;
import com.hqjcloud.provider.service.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.provider.web.rpc
 * @ClassName: CityFeignApi
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/12 10:21
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/12 10:21
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@RestController
@Api(value = "CityFeignClient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CityFeignClient implements CityFeignApi {

    @Autowired
    private CityService cityService;

    @Override
    @ApiOperation(value = "首页", notes = "首页")
    public List<CityEntity> getCityList(Long pid)
    {
      return  cityService.getCityList(pid);
    }
}
