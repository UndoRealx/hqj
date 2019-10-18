package com.hqjcloud.article.controller;

import com.hqjcloud.article.beans.Article;
import com.hqjcloud.article.beans.ArticleClassRelation;
import com.hqjcloud.article.beans.ArticleExample;
import com.hqjcloud.article.common.ApiResultEntity;
import com.hqjcloud.article.common.TimeUtil;
import com.hqjcloud.article.common.enums.StateCode;
import com.hqjcloud.article.dto.request.ArticleReq;
import com.hqjcloud.article.service.ArticleClassRelationService;
import com.hqjcloud.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.controller
 * @ClassName: ArticleController
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/20 11:30
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/20 11:30
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleClassRelationService articleClassRelationService;

    @RequestMapping("/*")
    public void toHtml(){

    }

    /**
    *@Description  置顶
    *@Param  * @param longid
 * @param isTop
    *@Return com.hqjcloud.article.common.ApiResultEntity
    *@Author lic
    *@Date 2019/10/10
    *@Time 15:38
    */
    @ResponseBody    
    @RequestMapping(value = "/top", method = RequestMethod.POST)
    public ApiResultEntity top(Long longid, Integer isTop) {

        if(null==longid||isTop==null)
        {
            return ApiResultEntity.returnResult(StateCode.ILLEGALREQUESTPARAMETER.get());
        }
        Article article=articleService.getById(longid);
        if(null==article)
        {
            return ApiResultEntity.returnResult(StateCode.NODATAEXIST.get());
        }
        article.setIsTop(Byte.parseByte(String.valueOf(isTop)));
        article.setModifyTime(TimeUtil.GetDate());
        articleService.modify(article);
        return ApiResultEntity.successResult(StateCode.success.get());
    }

    
    /**
    *@Description 新增
    *@Param  * @param data
    *@Return com.hqjcloud.article.common.ApiResultEntity
    *@Author lic
    *@Date 2019/10/10
    *@Time 15:39
    */
    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ApiResultEntity create(@RequestBody Article data) {
        articleService.add(data);
        return ApiResultEntity.successResult(StateCode.success.get());
    }
     /**
     *@Description 修改
     *@Param  * @param data
     *@Return com.hqjcloud.article.common.ApiResultEntity
     *@Author lic
     *@Date 2019/10/10
     *@Time 15:39
     */
    @ResponseBody
    @RequestMapping(value = "/manage", method = RequestMethod.POST)
    public  ApiResultEntity manage(ArticleReq data) throws Exception
    {
        articleService.manage(data);
        return ApiResultEntity.successResult(StateCode.success.get());
    }


    /**
    *@Description 批量删除
    *@Param  * @param longid
    *@Return com.hqjcloud.article.common.ApiResultEntity
    *@Author lic
    *@Date 2019/10/10
    *@Time 15:39
    */
    @ResponseBody
    @RequestMapping(value = "/batchDel", method = RequestMethod.POST)
    public ApiResultEntity batchDel(@RequestParam(value="longid", required=true) String  longid)
    {
        return ApiResultEntity.successResult(StateCode.success.get());
    }
    
    /**
    *@Description 删除
    *@Param  * @param longid
    *@Return com.hqjcloud.article.common.ApiResultEntity
    *@Author lic
    *@Date 2019/10/10
    *@Time 15:39
    */
    @ResponseBody    
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public ApiResultEntity del(@RequestParam(value="longid", required=true) String  longid)
    {
        if(null==longid)
        {
            return ApiResultEntity.returnResult(StateCode.ILLEGALREQUESTPARAMETER.get());
        }
        Article article=articleService.getById(Long.parseLong(longid));
        if(null==article)
        {
            return ApiResultEntity.returnResult(StateCode.NODATAEXIST.get());
        }
        article.setArtStatus(100);
        article.setModifyTime(TimeUtil.GetDate());
        articleService.modify(article);
        return ApiResultEntity.successResult(StateCode.success.get());
    }

    /**
    *@Description 获取单条
    *@Param  * @param longid
    *@Return com.hqjcloud.article.common.ApiResultEntity
    *@Author lic
    *@Date 2019/10/10
    *@Time 15:39
    */
    @ResponseBody  
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public  ApiResultEntity info(@RequestParam("longid") Long longid)
    {
        if(null==longid)
        {
            return ApiResultEntity.returnResult(StateCode.ILLEGALREQUESTPARAMETER.get());
        }
        Article article=articleService.getById(longid);
        return ApiResultEntity.successResult(article);
    }

    /**
    *@Description 分页获取
    *@Param  * @param key
 * @param page
 * @param size
    *@Return com.hqjcloud.article.common.ApiResultEntity
    *@Author lic
    *@Date 2019/10/10
    *@Time 15:39
    */
    @ResponseBody
    @GetMapping(value = "/getByPage")     
    public ApiResultEntity getByPage(@RequestParam(required = false,defaultValue = "") String key,
                           @RequestParam(required = false,defaultValue = "1") Integer page,
                           @RequestParam(required = false,defaultValue = "15") Integer size)
    {
        //andArtstatusNotEqualTo
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andArtStatusNotEqualTo(100);//已删除不显示
        if(key!=null&&key.trim().isEmpty()==false)
        {
            criteria.andArtTitleLike(key);
        }
        example.setOrderByClause("longid desc");
        return articleService.queryPageListByExample(example,page,size);
    }
    
    
    
    /**
    *@Description 根据文章ID 获取该文章的分类
    *@Param  * @param longid
    *@Return com.hqjcloud.base.ApiResultEntity
    *@Author lic
    *@Date 2019/9/26
    *@Time 14:01
    */
    @ResponseBody
    @RequestMapping(value = "/getArticleClassById", method = RequestMethod.GET)
    public  ApiResultEntity getArticleClassById(@RequestParam("longid") Long longid)
    {
        if(null==longid)
        {
            return ApiResultEntity.returnResult(StateCode.ILLEGALREQUESTPARAMETER.get());
        }
        List<ArticleClassRelation> list=articleClassRelationService.getByArticleId(longid);
        return ApiResultEntity.successResult(list);
    }

}
