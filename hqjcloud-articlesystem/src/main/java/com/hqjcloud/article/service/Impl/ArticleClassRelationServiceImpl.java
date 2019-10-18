package com.hqjcloud.article.service.Impl;

import com.hqjcloud.article.beans.ArticleClassRelation;
import com.hqjcloud.article.beans.ArticleClassRelationExample;
import com.hqjcloud.article.common.TimeUtil;
import com.hqjcloud.article.mapper.ArticleClassRelationExMapper;
import com.hqjcloud.article.service.ArticleClassRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.service.Impl
 * @ClassName: ArticleClassRelationServiceImpl
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/26 14:03
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/26 14:03
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
public class ArticleClassRelationServiceImpl implements ArticleClassRelationService {

    @Autowired
    private ArticleClassRelationExMapper mapper;


    @Override
    public List<ArticleClassRelation> getByArticleId(Long articleId)
    {
        ArticleClassRelationExample example = new ArticleClassRelationExample();
        ArticleClassRelationExample.Criteria criteria = example.createCriteria();
        criteria.andArticleIdEqualTo(articleId);
        example.setOrderByClause("addtime asc");
        List<ArticleClassRelation> lists = mapper.selectByExample(example);
        return lists;
    }


    /**
    *@Description 根据文章ID 删除该文章的分类
    *@Param  * @param articleId
    *@Return int
    *@Author lic
    *@Date 2019/9/27
    *@Time 11:40
    */
    @Override
    public  int  delByArticleId(Long articleId)
    {
        ArticleClassRelationExample example = new ArticleClassRelationExample();
        ArticleClassRelationExample.Criteria criteria = example.createCriteria();
        criteria.andArticleIdEqualTo(articleId);
        return mapper.deleteByExample(example);       
    }

    @Override
    public  long  add(Long articleId,Long classid)
    {
        ArticleClassRelation classRelation=new  ArticleClassRelation();
        classRelation.setAddTime(TimeUtil.GetDate());
        classRelation.setArticleClassId(classid);
        classRelation.setArticleId(articleId);
        return  mapper.insert(classRelation);
    }


    /**
     *@Description 根据条件统计
     *@Param  * @param example
     *@Return int
     *@Author lic
     *@Date 2019/10/8
     *@Time 10:36
     */
    public long countByExample(ArticleClassRelationExample example)
    {
        return  mapper.countByExample(example);
    }

}
