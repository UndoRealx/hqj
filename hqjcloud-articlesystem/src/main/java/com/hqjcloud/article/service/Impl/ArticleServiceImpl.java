package com.hqjcloud.article.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqjcloud.article.beans.Article;
import com.hqjcloud.article.beans.ArticleExample;
import com.hqjcloud.article.mapper.ArticleExMapper;
import com.hqjcloud.article.service.ArticleService;
import com.hqjcloud.base.ApiResultEntity;
import com.hqjcloud.base.enums.StateCode;
import com.hqjcloud.data.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.service.Impl
 * @ClassName: ArticleServiceImpl
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/20 14:43
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/20 14:43
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleExMapper articleExMapper;

    @Override
    public int add(Article entity) {
        return articleExMapper.insert(entity);
    }

    @Override
    public int modify(Article entity) {
        return  articleExMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int del(Long longid) {
        return articleExMapper.deleteByPrimaryKey(longid);
    }

    @Override
    public Article getById(Long longid) {
        return articleExMapper.selectByPrimaryKey(longid);
    }

    @Override
    public ApiResultEntity queryPageListByExample(ArticleExample example, int page, int size) {
        PageHelper.startPage(page, size, true);// 设置分页参数
        // 查询数据
        List<Article> lists = articleExMapper.selectByExample(example);
        PageInfo<Article> pageInfo=new PageInfo<Article>(lists);
        return ApiResultEntity.returnResult(StateCode.success.get(),PageUtil.returnPageList(pageInfo));
    }
}
