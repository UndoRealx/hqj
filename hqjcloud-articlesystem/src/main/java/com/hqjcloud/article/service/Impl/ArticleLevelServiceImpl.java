package com.hqjcloud.article.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqjcloud.article.beans.*;
import com.hqjcloud.article.common.ApiResultEntity;
import com.hqjcloud.article.common.enums.StateCode;
import com.hqjcloud.article.common.util.PageUtil;
import com.hqjcloud.article.dto.repose.ArticleLevelRep;
import com.hqjcloud.article.dto.request.ArticleLevelReq;
import com.hqjcloud.article.mapper.ArticleLevelExMapper;
import com.hqjcloud.article.service.ArticleLevelService;
import com.hqjcloud.article.service.PlatformService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.service.Impl
 * @ClassName: ArticleLevelServiceImpl
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/17 17:24
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/17 17:24
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
public class ArticleLevelServiceImpl implements ArticleLevelService {

    @Autowired
    private ArticleLevelExMapper mapper;

    @Autowired
    private PlatformService platformService;

    @Override
    public int add(ArticleLevel entity) {
        return mapper.insert(entity);
    }

    @Override
    public int modify(ArticleLevel entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public void manage(ArticleLevelReq entity) throws Exception {

    }

    @Override
    public int del(Long longid) {
        return mapper.deleteByPrimaryKey(longid);
    }

    @Override
    public ArticleLevel getById(Long longid) {
        return mapper.selectByPrimaryKey(longid);
    }

    @Override
    public  ArticleLevel getByName(String name,Long parentId)
    {
        ArticleLevelExample example = new ArticleLevelExample();
        ArticleLevelExample.Criteria criteria = example.createCriteria();
        criteria.andLevelNameEqualTo(name.trim());
        if(parentId!=null)
        {
            criteria.andLevelParentidEqualTo(parentId);
        }
        List<ArticleLevel>  list=mapper.selectByExample(example);
        return  list.size()>0?list.get(0):null;
    }

    @Override
    public ApiResultEntity queryPageListByExample(ArticleLevelExample example, int page, int size) {
        PageHelper.startPage(page, size, true);// 设置分页参数
        // 查询数据
        List<ArticleLevel> lists = mapper.selectByExample(example);
        PageInfo<ArticleLevel> pageInfo = new PageInfo<ArticleLevel>(lists);

        List<ArticleLevelRep>  list=new ArrayList<ArticleLevelRep>();

        for (ArticleLevel bean : pageInfo.getList()) {
            ArticleLevelRep item = new ArticleLevelRep();
            BeanUtils.copyProperties(bean, item);
            item.setPlatformName("");
            item.setParentLevelName("-----");
            if(item.getPlatformId()!=null&&item.getPlatformId()>0L)
            {
                Platform platform=platformService.getById(item.getPlatformId());
                if(null!=platform)
                {
                    item.setPlatformName(platform.getPlatformName());
                }
            }
            if(item.getLevelParentid()!=null&&item.getLevelParentid()>0L)
            {
                ArticleLevel articleLevel=getById(item.getLevelParentid());
                if(null!=articleLevel)
                {
                    item.setParentLevelName(articleLevel.getLevelName());
                }
            }
            list.add(item);
        }

        return ApiResultEntity.returnResult(StateCode.success.get(), PageUtil.returnPageList(pageInfo, list));
    }

    @Override
    public List<ArticleLevel> list(Long platformId, Long parentId)
    {
        ArticleLevelExample example = new ArticleLevelExample();
        ArticleLevelExample.Criteria criteria = example.createCriteria();
        if(parentId!=null)
        {
            criteria.andLevelParentidEqualTo(parentId);
        }

        if(platformId!=null&&platformId>0)
        {
            criteria.andPlatformIdEqualTo(platformId);
        }

        List<ArticleLevel>  list=mapper.selectByExample(example);
        return  list;
    }
}
