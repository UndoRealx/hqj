package com.hqjcloud.article.service;

import com.hqjcloud.article.beans.Platform;
import com.hqjcloud.article.common.ApiResultEntity;

import java.util.List;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.service
 * @ClassName: Platform
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/22 11:01
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/22 11:01
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface PlatformService {

    public int add(Platform entity);

    public  int modify(Platform entity);

    public  int del(Long longid);

    public Platform getById(Long longid);

    public List<Platform> getAll();

    public ApiResultEntity queryPageListByExample(String key, int page, int size);


    public Platform getByName(String name);
}
