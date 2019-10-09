package com.hqjcloud.article.service;

import com.hqjcloud.article.beans.ArticleClass;
import com.hqjcloud.article.beans.ArticleClassExample;
import com.hqjcloud.base.ApiResultEntity;

import java.util.List;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.service
 * @ClassName: ArticleClassService
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/20 16:28
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/20 16:28
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface ArticleClassService {

    public int add(ArticleClass entity);

    public  int modify(ArticleClass entity);

    public  int del(Long longid);

    public  ArticleClass getById(Long longid);

    public  ArticleClass getByName(String className);

    public ApiResultEntity queryPageListByExample(ArticleClassExample example, int page, int size);


    public List<ArticleClass> list(int classStatus);
}
