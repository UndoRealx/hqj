package com.hqjcloud.article.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqjcloud.article.beans.Article;
import com.hqjcloud.article.beans.ArticleExample;
import com.hqjcloud.article.common.Layui;
import com.hqjcloud.article.dto.repose.ArticleRep;
import com.hqjcloud.article.mapper.ArticleExMapper;
import com.hqjcloud.article.service.ArticleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Layui queryPageListByExample(ArticleExample example, int page, int size) {
        PageHelper.startPage(page, size, true);// 设置分页参数
        // 查询数据
        List<Article> lists = articleExMapper.selectByExample(example);
        PageInfo<Article> pageInfo=new PageInfo<Article>(lists);
        List<ArticleRep> list = new ArrayList<>();
        for(Article bean:pageInfo.getList())
        {
            ArticleRep item = new ArticleRep();
            BeanUtils.copyProperties(bean,item);
            list.add(item);
        }
        return Layui.data(pageInfo.getTotal(),list);
    }
}
