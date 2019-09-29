package com.hqjcloud.article.service;

import com.hqjcloud.article.beans.Article;
import com.hqjcloud.article.beans.ArticleExample;
import com.hqjcloud.article.dto.request.ArticleReq;
import com.hqjcloud.base.ApiResultEntity;


/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.service
 * @ClassName: ArticleService
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/20 14:41
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/20 14:41
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface ArticleService {

    public int add(Article entity);

    public int modify(Article entity);

    public  void manage(ArticleReq entity) throws Exception;

    public  int del(Long longid);

    public  Article getById(Long longid);

    public ApiResultEntity queryPageListByExample(ArticleExample example, int page, int size);
}
