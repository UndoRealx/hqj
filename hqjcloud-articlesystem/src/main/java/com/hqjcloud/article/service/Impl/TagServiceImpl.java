package com.hqjcloud.article.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqjcloud.article.beans.Tag;
import com.hqjcloud.article.beans.TagExample;
import com.hqjcloud.article.common.ApiResultEntity;
import com.hqjcloud.article.common.enums.StateCode;
import com.hqjcloud.article.common.util.PageUtil;
import com.hqjcloud.article.mapper.TagExMapper;
import com.hqjcloud.article.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.service.Impl
 * @ClassName: TagServiceImpl
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/20 16:29
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/20 16:29
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagExMapper mapper;

    @Override
    public int add(Tag entity) {
        return mapper.insert(entity);
    }

    @Override
    public int modify(Tag entity) {
        return  mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int del(Long longid) {
        return mapper.deleteByPrimaryKey(longid);
    }

    @Override
    public Tag getById(Long longid) {
        return mapper.selectByPrimaryKey(longid);
    }

    @Override
    public ApiResultEntity queryPageList(String key, int page, int size) {
        PageHelper.startPage(page, size, true);// 设置分页参数
        // 查询数据
        List<Map> lists = mapper.getByPage(key);
        PageInfo<Map> pageInfo=new PageInfo<Map>(lists);
        return ApiResultEntity.returnResult(StateCode.success.get(), PageUtil.returnPageList(pageInfo,lists));
    }

    @Override
    public ApiResultEntity queryPageListByExample(TagExample example, int page, int size) {
        PageHelper.startPage(page, size, true);// 设置分页参数
        // 查询数据
        List<Tag> lists = mapper.selectByExample(example);
        PageInfo<Tag> pageInfo=new PageInfo<Tag>(lists);
        return ApiResultEntity.returnResult(StateCode.success.get(), PageUtil.returnPageList(pageInfo));
    }

    @Override
    public Tag getByName(String name) {
        TagExample tagExample = new TagExample();
        TagExample.Criteria criteria = tagExample.createCriteria();
        criteria.andTagNameEqualTo(name.trim());

        List<Tag> list = mapper.selectByExample(tagExample);
        return  list.size()>0?list.get(0):null;
    }
}
