package com.hqjcloud.article.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqjcloud.article.beans.*;
import com.hqjcloud.article.common.ApiResultEntity;
import com.hqjcloud.article.common.ArtStatusEnum;
import com.hqjcloud.article.common.TimeUtil;
import com.hqjcloud.article.common.enums.StateCode;
import com.hqjcloud.article.common.util.PageUtil;
import com.hqjcloud.article.dto.repose.ArticleRep;
import com.hqjcloud.article.dto.request.ArticleReq;
import com.hqjcloud.article.mapper.ArticleExMapper;

import com.hqjcloud.article.service.ArticleLevelService;
import com.hqjcloud.article.service.ArticleService;
import com.hqjcloud.article.service.PlatformService;
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
    private ArticleLevelService articleLevelService;

    @Autowired
    private PlatformService platformService;

  /*  @Autowired
    private ArticleClassRelationService articleClassRelationService;

    @Autowired
    private ArticleClassService articleClassService;*/

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

       /* if (null != req.getLongid()) {
            articleClassRelationService.delByArticleId(req.getLongid());
        }*/
        Article entity = (Article) req;
        entity.setModifyTime(TimeUtil.GetDate());
        if (req.getPubTimes() != null && req.getPubTimes().trim().isEmpty() == false) {
            entity.setPubTime(TimeUtil.dateToLong(TimeUtil.stringToDate1(req.getPubTimes())));
        }
        if(entity.getArtStatus()!= ArtStatusEnum.TimingPub.get())
        {
            entity.setPubTime(null);
        }
        entity.setArtLevelId((req.getSecLevelId()!=null&&req.getSecLevelId()>0)?req.getSecLevelId():req.getTopLevelId());
        if (req.getLongid() == null || req.getLongid() <= 0L) {

            entity.setAddTime(TimeUtil.GetDate());
            entity.setVisitCnt(0);

            entity.setLikes(0);
            entity.setArtSort(0);
            add(entity);
            req.setLongid(entity.getLongid());
        } else {
            articleExMapper.updateByPrimaryKeySelective(entity);
        }

    /*  if (req.getArtclass() != null && req.getArtclass().trim().isEmpty() == false) {
            String[] listClass = req.getArtclass().trim().split(",");
            for (String s : listClass) {
                articleClassRelationService.add(req.getLongid(), Long.parseLong(s));
            }
        }*/

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
        PageInfo<Article> pageInfo = new PageInfo<Article>(lists);
        List<ArticleRep> list = new ArrayList<ArticleRep>();

        List<Platform>  platformList=platformService.getAll();

        List<ArticleLevel> levelList=articleLevelService.list(null,null);


        for (Article bean : pageInfo.getList()) {
            ArticleRep item = new ArticleRep();
            BeanUtils.copyProperties(bean, item);
            item.setPlatformName(platformList.stream().filter(f->f.getLongid()==bean.getPlatformId()).findFirst().get().getPlatformName());
            item.setArtLevelName(levelList.stream().filter(f->f.getLongid()==bean.getArtLevelId()).findFirst().get().getLevelName());
            list.add(item);
        }
        return ApiResultEntity.returnResult(StateCode.success.get(), PageUtil.returnPageList(pageInfo, list));
    }

    /**
     * @Description 根据条件统计
     * @Param * @param example
     * @Return int
     * @Author lic
     * @Date 2019/10/8
     * @Time 10:35
     */
    @Override
    public long countByExample(ArticleExample example)
    {
       return  articleExMapper.countByExample(example);
    }
}
