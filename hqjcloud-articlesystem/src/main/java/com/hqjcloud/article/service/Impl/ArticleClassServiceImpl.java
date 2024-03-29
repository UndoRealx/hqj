package com.hqjcloud.article.service.Impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqjcloud.article.beans.ArticleClass;
import com.hqjcloud.article.beans.ArticleClassExample;
import com.hqjcloud.article.common.ApiResultEntity;
import com.hqjcloud.article.common.enums.StateCode;
import com.hqjcloud.article.common.util.PageUtil;
import com.hqjcloud.article.dto.repose.ArticleClassRep;
import com.hqjcloud.article.mapper.ArticleClassExMapper;
import com.hqjcloud.article.service.ArticleClassService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public  ArticleClass getByName(String className)
    {
        ArticleClassExample example = new ArticleClassExample();
        ArticleClassExample.Criteria criteria = example.createCriteria();
        criteria.andClassNameEqualTo(className.trim());
        List<ArticleClass>  list=mapper.selectByExample(example);
        return  list.size()>0?list.get(0):null;
    }

    @Override
    public ApiResultEntity queryPageListByExample(ArticleClassExample example, int page, int size) {
        PageHelper.startPage(page, size, true);// 设置分页参数
        // 查询数据
        List<ArticleClass> lists = mapper.selectByExample(example);
        PageInfo<ArticleClass> pageInfo=new PageInfo<ArticleClass>(lists);

        List<ArticleClassRep> list = new ArrayList<ArticleClassRep>();
        for(ArticleClass bean:pageInfo.getList())
        {
            ArticleClassRep item = new ArticleClassRep();
            BeanUtils.copyProperties(bean,item);
            list.add(item);
        }
        return ApiResultEntity.returnResult(StateCode.success.get(), PageUtil.returnPageList(pageInfo,list));
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
