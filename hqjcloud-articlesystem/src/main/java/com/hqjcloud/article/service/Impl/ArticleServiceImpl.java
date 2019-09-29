package com.hqjcloud.article.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqjcloud.article.beans.Article;
import com.hqjcloud.article.beans.ArticleExample;
import com.hqjcloud.article.common.TimeUtil;
import com.hqjcloud.article.dto.repose.ArticleRep;
import com.hqjcloud.article.dto.request.ArticleReq;
import com.hqjcloud.article.mapper.ArticleExMapper;
import com.hqjcloud.article.service.ArticleClassRelationService;
import com.hqjcloud.article.service.ArticleService;
import com.hqjcloud.base.ApiResultEntity;
import com.hqjcloud.base.enums.StateCode;
import com.hqjcloud.data.util.PageUtil;
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

    @Autowired
    private ArticleClassRelationService articleClassRelationService;

    @Override
    public int add(Article entity) {
        return articleExMapper.insert(entity);
    }

    @Override
    public int modify(Article entity) {
        return articleExMapper.updateByPrimaryKey(entity);
    }

    @Override
    public void manage(ArticleReq req) throws Exception {

        if(null!=req.getLongid())
        {
            articleClassRelationService.delByArticleId(req.getLongid());
        }
        Article entity=(Article)req;
        if(req.getLongid()==null||req.getLongid()<=0L)
        {
            entity.setModifytime(TimeUtil.GetDate());
            entity.setAddtime(TimeUtil.GetDate());
            entity.setVisitcnt(0);
            if(req.getPubTimes()!=null&&req.getPubTimes().trim().isEmpty()==false) {
                entity.setPubtime(TimeUtil.dateToLong(TimeUtil.stringToDate1(req.getPubTimes())));
            }
            entity.setLikes(0);
            entity.setArtsort(0);
            add(entity);
            req.setLongid(entity.getLongid());
        }
        else {
            entity.setModifytime(TimeUtil.GetDate());
            if(req.getPubTimes()!=null&&req.getPubTimes().trim().isEmpty()==false) {
                entity.setPubtime(TimeUtil.dateToLong(TimeUtil.stringToDate1(req.getPubTimes())));
            }
            articleExMapper.updateByPrimaryKeySelective(entity);
        }

        if(req.getArtclass()!=null&&req.getArtclass().trim().isEmpty()==false)
        {
            String[] listClass=req.getArtclass().trim().split(",");
            for(String s :listClass)
            {
                articleClassRelationService.add(req.getLongid(),Long.parseLong(s));
            }
        }

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
        List<ArticleRep> list = new ArrayList<>();
        for(Article bean:pageInfo.getList())
        {
            ArticleRep item = new ArticleRep();
            BeanUtils.copyProperties(bean,item);
            list.add(item);
        }
        return ApiResultEntity.returnResult(StateCode.success.get(), PageUtil.returnPageList(pageInfo,list));
    }
}
