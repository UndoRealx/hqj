package com.hqjcloud.article.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqjcloud.article.beans.Tag;
import com.hqjcloud.article.beans.TagExample;
import com.hqjcloud.article.mapper.TagExMapper;
import com.hqjcloud.article.service.TagService;
import com.hqjcloud.base.ApiResultEntity;
import com.hqjcloud.base.enums.StateCode;
import com.hqjcloud.data.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ApiResultEntity queryPageListByExample(TagExample example, int page, int size) {
        PageHelper.startPage(page, size, true);// 设置分页参数
        // 查询数据
        List<Tag> lists = mapper.selectByExample(example);
        PageInfo<Tag> pageInfo=new PageInfo<Tag>(lists);
        return ApiResultEntity.returnResult(StateCode.success.get(), PageUtil.returnPageList(pageInfo));
    }
}
