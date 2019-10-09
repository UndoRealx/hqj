package com.hqjcloud.article.service;

import com.hqjcloud.article.beans.ArticleClassRelation;
import com.hqjcloud.article.beans.ArticleClassRelationExample;

import java.util.List;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.service
 * @ClassName: ArticleClassRelationService
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/26 14:03
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/26 14:03
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface ArticleClassRelationService {

    public List<ArticleClassRelation>  getByArticleId(Long articleId);

    public  int  delByArticleId(Long articleId);


    public  long  add(Long articleId,Long classid);

    /**
     *@Description 根据条件统计
     *@Param  * @param example
     *@Return int
     *@Author lic
     *@Date 2019/10/8
     *@Time 10:36
     */
    public long countByExample(ArticleClassRelationExample example);
}
