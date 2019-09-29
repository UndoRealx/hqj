package com.hqjcloud.article.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqjcloud.article.beans.ArticleClass;
import com.hqjcloud.article.beans.ArticleClassExample;
import com.hqjcloud.article.mapper.ArticleClassExMapper;
import com.hqjcloud.article.service.ArticleClassService;
import com.hqjcloud.base.ApiResultEntity;
import com.hqjcloud.base.enums.StateCode;
import com.hqjcloud.data.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.service.Impl
 * @ClassName: ArticleClassServiceImpl
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/20 16:29
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/20 16:29
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
public class ArticleClassServiceImpl implements ArticleClassService {

    @Autowired
    private ArticleClassExMapper mapper;

    @Override
    public int add(ArticleClass entity) {
        return mapper.insert(entity);
    }

    @Override
    public int modify(ArticleClass entity) {
        return  mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int del(Long longid) {
        return mapper.deleteByPrimaryKey(longid);
    }

    @Override
    public ArticleClass getById(Long longid) {
        return mapper.selectByPrimaryKey(longid);
    }

    @Override
    public ApiResultEntity queryPageListByExample(ArticleClassExample example, int page, int size) {
        PageHelper.startPage(page, size, true);// 设置分页参数
        // 查询数据
        List<ArticleClass> lists = mapper.selectByExample(example);
        PageInfo<ArticleClass> pageInfo=new PageInfo<ArticleClass>(lists);
        return ApiResultEntity.returnResult(StateCode.success.get(), PageUtil.returnPageList(pageInfo));
    }

    @Override
    public List<ArticleClass> list(int classStatus) {
        ArticleClassExample example = new ArticleClassExample();
        ArticleClassExample.Criteria criteria = example.createCriteria();
        if(classStatus!=-1) {
            criteria.andStatusEqualTo(Byte.parseByte(String.valueOf(classStatus)));
        }
        example.setOrderByClause("sort asc");
        List<ArticleClass> lists = mapper.selectByExample(example);
        return lists;
    }
}
