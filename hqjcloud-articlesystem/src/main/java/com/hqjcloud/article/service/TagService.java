package com.hqjcloud.article.service;

import com.hqjcloud.article.beans.Tag;
import com.hqjcloud.article.beans.TagExample;
import com.hqjcloud.base.ApiResultEntity;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.service
 * @ClassName: TagService
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/20 16:28
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/20 16:28
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface TagService {

    public int add(Tag entity);

    public  int modify(Tag entity);

    public  int del(Long longid);

    public  Tag getById(Long longid);

    public ApiResultEntity queryPageListByExample(TagExample example, int page, int size);
}
