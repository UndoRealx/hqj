package com.hqjcloud.article.service;

import com.hqjcloud.article.beans.ArticleLevel;
import com.hqjcloud.article.beans.ArticleLevelExample;
import com.hqjcloud.article.common.ApiResultEntity;
import com.hqjcloud.article.dto.request.ArticleLevelReq;

import java.util.List;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.service
 * @ClassName: ArticleLevelService
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/17 17:20
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/17 17:20
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface ArticleLevelService {
    public int add(ArticleLevel entity);

    public int modify(ArticleLevel entity);

    public  void manage(ArticleLevelReq entity) throws Exception;

    public  int del(Long longid);

    public  ArticleLevel getById(Long longid);

    public  ArticleLevel getByName(String name,Long parentId);

    public ApiResultEntity queryPageListByExample(ArticleLevelExample example, int page, int size);


    public List<ArticleLevel> list(Long platformId, Long parentId);
}
