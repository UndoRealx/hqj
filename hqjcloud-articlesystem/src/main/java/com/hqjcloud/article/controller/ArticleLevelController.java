package com.hqjcloud.article.controller;

import com.hqjcloud.article.beans.ArticleExample;
import com.hqjcloud.article.beans.ArticleLevel;
import com.hqjcloud.article.beans.ArticleLevelExample;
import com.hqjcloud.article.common.ApiResultEntity;
import com.hqjcloud.article.common.TimeUtil;
import com.hqjcloud.article.common.enums.StateCode;
import com.hqjcloud.article.dto.request.ArticleLevelReq;
import com.hqjcloud.article.service.ArticleLevelService;
import com.hqjcloud.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.controller
 * @ClassName: ArticleLevel
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/12 17:29
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/12 17:29
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
@RequestMapping(value = "/articlelevel")
public class ArticleLevelController {

    @Autowired
    private ArticleLevelService articleLevelService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/*")
    public void toHtml(){

    }

    @ResponseBody
    @RequestMapping(value = "/manage", method = RequestMethod.POST)
    public ApiResultEntity manage(ArticleLevelReq data) {
        if(data.getLevelName()==null||data.getLevelName().trim().isEmpty())
        {
            return  ApiResultEntity.returnResult(StateCode.ILLEGALREQUESTPARAMETER.get());
        }
        ArticleLevel entity= articleLevelService.getByName(data.getLevelName(),data.getLongid());

        if(data.getLongid()==null||data.getLongid()==0)
        {
            if(null!=entity)
            {
                return  ApiResultEntity.returnResult(StateCode.ARC10031002.get());
            }
            data.setAddtime(TimeUtil.GetDate());
            data.setModifytime(TimeUtil.GetDate());
            articleLevelService.add(data);
        }
        else
        {
            ArticleLevel articleLevel=articleLevelService.getById(data.getLongid());
            if(null==articleLevel)
            {
                return  ApiResultEntity.returnResult(StateCode.NODATAEXIST.get());
            }
            ArticleLevel newArticleLevel=articleLevelService.getByName(data.getLevelName(),data.getLevelParentid());
            if(null!=newArticleLevel)
            {
                //不是同一个上级栏目
                if(newArticleLevel.getLevelParentid()!=articleLevel.getLevelParentid()) {
                    //栏目名称已存在
                    return ApiResultEntity.returnResult(StateCode.ARL10041001.get());
                }
                else {
                    if (newArticleLevel.getLongid() != data.getLongid()) {
                        //栏目名称已存在
                        return ApiResultEntity.returnResult(StateCode.ARL10041001.get());
                    }
                }
            }

            articleLevel.setLevelName(data.getLevelName());
            articleLevel.setModifytime(TimeUtil.GetDate());
            articleLevel.setLevelParentid(data.getLevelParentid());
            articleLevel.setLevelStatus(data.getLevelStatus());
            articleLevelService.modify(data);
        }
        return ApiResultEntity.successResult(StateCode.success.get());
    }

    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public ApiResultEntity del(Long longid) {
        if (null == longid || longid == 0) {
            return ApiResultEntity.returnResult(StateCode.ILLEGALREQUESTPARAMETER.get());
        }
        ArticleLevel articleLevel=articleLevelService.getById(longid);
        if(null==articleLevel)
        {
            return  ApiResultEntity.returnResult(StateCode.NODATAEXIST.get());
        }

        List<ArticleLevel> childrenLevel=new ArrayList<>();
        if(articleLevel.getLevelParentid()==0) //顶级目录
        {
            childrenLevel=articleLevelService.list(articleLevel.getPlatformId(),articleLevel.getLongid());
            if(childrenLevel.isEmpty()==false)
            {
                return  ApiResultEntity.returnResult(StateCode.ARL10041003.get());
            }
        }
        ArticleExample example=new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andArtLevelIdEqualTo(longid);
        criteria.andArtStatusNotEqualTo(100);
        long cnt=articleService.countByExample(example);
        if(cnt>0)
        {
            return ApiResultEntity.returnResult(StateCode.ARL10041002.get());
        }
        if(childrenLevel.isEmpty()==false)
        {
           List<Long> listChildLd=childrenLevel.stream().map(ArticleLevel::getLongid).collect(Collectors.toList());
            criteria = example.createCriteria();
            criteria.andArtLevelIdIn(listChildLd);
            criteria.andArtStatusNotEqualTo(100);
            cnt=articleService.countByExample(example);
            if(cnt>0)
            {
                return ApiResultEntity.returnResult(StateCode.ARL10041004.get());
            }
        }
        articleLevelService.del(longid);
        return ApiResultEntity.successResult(StateCode.success.get());
    }

    @ResponseBody
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public  ApiResultEntity info(Long longid)
    {
        if(null==longid||longid==0)
        {
            return  ApiResultEntity.returnResult(StateCode.ILLEGALREQUESTPARAMETER.get());
        }
        ArticleLevel articleLevel=articleLevelService.getById(longid);
        return ApiResultEntity.successResult(articleLevel);
    }

    /**
     *@Description 更新状态
     *@Param  * @param longid
     * @param status
     *@Return com.hqjcloud.article.common.ApiResultEntity
     *@Author lic
     *@Date 2019/10/10
     *@Time 15:37
     */
    @ResponseBody
    @RequestMapping(value = "/doStatus", method = RequestMethod.POST)
    public ApiResultEntity doStatus(Long longid,Integer status)
    {
        if(null==longid||status==null||longid==0)
        {
            return  ApiResultEntity.returnResult(StateCode.ILLEGALREQUESTPARAMETER.get());
        }
        ArticleLevel articleLevel=articleLevelService.getById(longid);
        if(articleLevel.getLevelStatus()==Byte.parseByte(String.valueOf(status)))
        {
            return  ApiResultEntity.returnResult(StateCode.success.get());
        }
        articleLevel.setLevelStatus(Byte.parseByte(String.valueOf(status)));
        articleLevelService.modify(articleLevel);
        return ApiResultEntity.successResult(articleLevel);
    }

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public  ApiResultEntity list(Long platformId,Long parentId)
    {
        List<ArticleLevel> list=articleLevelService.list(platformId,parentId);
        return ApiResultEntity.successResult(list);
    }

    /**
     *@Description 分页获取
     *@Param  * @param key
     * @param page
     * @param size
     *@Return com.hqjcloud.article.common.ApiResultEntity
     *@Author lic
     *@Date 2019/10/10
     *@Time 15:37
     */
    @ResponseBody
    @GetMapping(value = "/getByPage")
    public ApiResultEntity getByPage(@RequestParam(required = false,defaultValue = "") String key,
                                     @RequestParam(required = false,defaultValue = "1") Integer page,
                                     @RequestParam(required = false,defaultValue = "15") Integer size)
    {
        ArticleLevelExample example = new ArticleLevelExample();
        ArticleLevelExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("longid desc");
        if(key!=null&&key.trim().isEmpty()==false)
        {
            criteria.andLevelNameLike(key);
        }
        return articleLevelService.queryPageList(key,page,size);
    }

    

}
