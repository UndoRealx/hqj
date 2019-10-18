package com.hqjcloud.article.controller;

import com.hqjcloud.article.beans.ArticleClass;
import com.hqjcloud.article.beans.ArticleClassExample;
import com.hqjcloud.article.beans.ArticleClassRelationExample;
import com.hqjcloud.article.common.ApiResultEntity;
import com.hqjcloud.article.common.TimeUtil;
import com.hqjcloud.article.common.enums.StateCode;
import com.hqjcloud.article.service.ArticleClassRelationService;
import com.hqjcloud.article.service.ArticleClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 
 * 
 * @author Lic
 * @email hqj@hqj.com
 * @date 2019-09-20 16:22:06
 */
@Controller
@RequestMapping(value = "/articleclass")
public class ArticleClassController {
	@Autowired
	private ArticleClassService articleclassService;
    @Autowired
    private ArticleClassRelationService articleClassRelationService;

    @RequestMapping("/*")
    public void toHtml(){

    }

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ApiResultEntity create(@RequestBody ArticleClass data) {
        articleclassService.add(data);
        return ApiResultEntity.successResult(StateCode.success.get());
    }

    /**
    *@Description 修改
    *@Param  * @param data
    *@Return com.hqjcloud.article.common.ApiResultEntity
    *@Author lic
    *@Date 2019/10/10
    *@Time 15:37
    */
    @ResponseBody
    @RequestMapping(value = "/modify", method = RequestMethod.PUT)
    public  ApiResultEntity modify(@RequestBody ArticleClass data)
    {
        articleclassService.modify(data);
        return ApiResultEntity.successResult(StateCode.success.get());
    }

    /**
    *@Description 分类管理
    *@Param  * @param data
    *@Return com.hqjcloud.article.common.ApiResultEntity
    *@Author lic
    *@Date 2019/10/10
    *@Time 15:37
    */
    @ResponseBody
    @RequestMapping(value = "/manage", method = RequestMethod.POST)
    public  ApiResultEntity manage(ArticleClass data)
    {
        if(data.getClassName()==null||data.getClassName().trim().isEmpty())
        {
            return  ApiResultEntity.returnResult(StateCode.ILLEGALREQUESTPARAMETER.get());
        }
        ArticleClass entity= articleclassService.getByName(data.getClassName());


        if(data.getLongid()==null||data.getLongid()==0)
        {
            if(null!=entity)
            {
                return  ApiResultEntity.returnResult(StateCode.ARC10031002.get());
            }
            data.setAddTime(TimeUtil.GetDate());
            data.setSort(0);
            articleclassService.add(data);
        }
        else
        {
            ArticleClass articleClass=articleclassService.getById(data.getLongid());
            if(null==articleClass)
            {
                return  ApiResultEntity.returnResult(StateCode.NODATAEXIST.get());
            }
            articleClass=articleclassService.getByName(data.getClassName());
            if(null!=articleClass) {
                if (articleClass.getLongid() != data.getLongid()) {
                    return ApiResultEntity.returnResult(StateCode.ARC10031002.get());
                }
            }
            articleClass.setClassName(data.getClassName());
            articleClass.setStatus(data.getStatus());
            articleclassService.modify(data);
        }
        return ApiResultEntity.successResult(StateCode.success.get());
    }

    /**
    *@Description 删除
    *@Param  * @param longid
    *@Return com.hqjcloud.article.common.ApiResultEntity
    *@Author lic
    *@Date 2019/10/10
    *@Time 15:37
    */
    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public ApiResultEntity del(Long longid) {
        if (null == longid || longid == 0) {
            return ApiResultEntity.returnResult(StateCode.ILLEGALREQUESTPARAMETER.get());
        }

        ArticleClassRelationExample example=new ArticleClassRelationExample();
        ArticleClassRelationExample.Criteria criteria = example.createCriteria();
        criteria.andArticleClassIdEqualTo(longid);
        if(articleClassRelationService.countByExample(example)>0L)
        {
            return ApiResultEntity.returnResult(StateCode.ARC10031001.get());
        }
        articleclassService.del(longid);
        return ApiResultEntity.successResult(StateCode.success.get());
    }
    
    /**
    *@Description 获取单条
    *@Param  * @param longid
    *@Return com.hqjcloud.article.common.ApiResultEntity
    *@Author lic
    *@Date 2019/10/10
    *@Time 15:37
    */
    @ResponseBody    
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public  ApiResultEntity info(Long longid)
    {
        if(null==longid||longid==0)
        {
            return  ApiResultEntity.returnResult(StateCode.ILLEGALREQUESTPARAMETER.get());
        }
        ArticleClass articleClass=articleclassService.getById(longid);
        return ApiResultEntity.successResult(articleClass);
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
        ArticleClass articleClass=articleclassService.getById(longid);
        if(articleClass.getStatus()==Byte.parseByte(String.valueOf(status)))
        {
            return  ApiResultEntity.returnResult(StateCode.success.get());
        }
        articleClass.setStatus(Byte.parseByte(String.valueOf(status)));
        articleclassService.modify(articleClass);
        return ApiResultEntity.successResult(articleClass);
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
        ArticleClassExample example = new ArticleClassExample();
        ArticleClassExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("longid desc");
        if(key!=null&&key.trim().isEmpty()==false)
        {
            criteria.andClassNameLike(key);
        }
        return articleclassService.queryPageListByExample(example,page,size);
    }

    
    /**
    *@Description 获取所有上架的分类
    *@Param  * @param 
    *@Return com.hqjcloud.article.common.ApiResultEntity
    *@Author lic
    *@Date 2019/10/10
    *@Time 15:41
    */
    @ResponseBody   
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public  ApiResultEntity list()
    {
        List<ArticleClass> list=articleclassService.list(1);
        return ApiResultEntity.successResult(list);
    }
}
