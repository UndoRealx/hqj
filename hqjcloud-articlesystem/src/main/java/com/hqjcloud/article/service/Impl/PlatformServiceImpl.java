package com.hqjcloud.article.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqjcloud.article.beans.Platform;
import com.hqjcloud.article.beans.PlatformExample;
import com.hqjcloud.article.common.ApiResultEntity;
import com.hqjcloud.article.common.enums.StateCode;
import com.hqjcloud.article.common.util.PageUtil;
import com.hqjcloud.article.mapper.PlatformExMapper;
import com.hqjcloud.article.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.service.Impl
 * @ClassName: PlatformServiceImpl
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/22 11:02
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/22 11:02
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
public class PlatformServiceImpl implements PlatformService {

    @Autowired
    private PlatformExMapper mapper;
    @Override
    public int add(Platform entity) {
        return mapper.insert(entity);
    }

    @Override
    public int modify(Platform entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    @Override
    public int del(Long longid) {
        return mapper.deleteByPrimaryKey(longid);
    }

    @Override
    public Platform getById(Long longid) {
        return mapper.selectByPrimaryKey(longid);
    }

    @Override
    public ApiResultEntity queryPageListByExample(String key, int page, int size) {
        PageHelper.startPage(page, size, true);// 设置分页参数
        // 查询数据
        List<Map> lists = mapper.getByPage(key);
        PageInfo<Map> pageInfo = new PageInfo<Map>(lists);



        return ApiResultEntity.returnResult(StateCode.success.get(), PageUtil.returnPageList(pageInfo, lists));
    }

    @Override
    public Platform getByName(String name)
    {
        PlatformExample example = new PlatformExample();
        PlatformExample.Criteria criteria = example.createCriteria();
        criteria.andPlatformNameEqualTo(name.trim());

        List<Platform>  list=mapper.selectByExample(example);
        return  list.size()>0?list.get(0):null;
    }
    @Override
    public List<Platform> getAll()
    {
        PlatformExample example = new PlatformExample();
        PlatformExample.Criteria criteria = example.createCriteria();

        List<Platform>  list=mapper.selectByExample(example);
        return list;
    }
}
