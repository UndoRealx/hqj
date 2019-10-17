package com.hqjcloud.article.controller;

import com.hqjcloud.article.beans.ArticleClass;
import com.hqjcloud.article.beans.ArticleClassExample;
import com.hqjcloud.article.beans.ArticleClassRelationExample;
import com.hqjcloud.article.beans.ArticleLevel;
import com.hqjcloud.article.common.ApiResultEntity;
import com.hqjcloud.article.common.enums.StateCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/*")
    public void toHtml(){

    }

    @ResponseBody
    @RequestMapping(value = "/manage", method = RequestMethod.POST)
    public ApiResultEntity manage(ArticleLevel data) {

    }

    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public ApiResultEntity del(Long longid) {
        if (null == longid || longid == 0) {
            return ApiResultEntity.returnResult(StateCode.ILLEGALREQUESTPARAMETER.get());
        }

        ArticleClassRelationExample example=new ArticleClassRelationExample();
        ArticleClassRelationExample.Criteria criteria = example.createCriteria();
        criteria.andArticleclassidEqualTo(longid);
        if(articleClassRelationService.countByExample(example)>0L)
        {
            return ApiResultEntity.returnResult(StateCode.ARC10031001.get());
        }
        articleclassService.del(longid);
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
            criteria.andClassnameLike(key);
        }
        return articleclassService.queryPageListByExample(example,page,size);
    }

}
