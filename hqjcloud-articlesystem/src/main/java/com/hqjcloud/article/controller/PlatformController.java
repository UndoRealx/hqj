package com.hqjcloud.article.controller;

import com.hqjcloud.article.beans.ArticleClassRelationExample;
import com.hqjcloud.article.beans.Platform;
import com.hqjcloud.article.beans.PlatformExample;
import com.hqjcloud.article.common.ApiResultEntity;
import com.hqjcloud.article.common.TimeUtil;
import com.hqjcloud.article.common.enums.StateCode;
import com.hqjcloud.article.dto.request.PlatformReq;
import com.hqjcloud.article.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.controller
 * @ClassName: PlatformController
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/22 10:58
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/22 10:58
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
@RequestMapping(value = "/platform")
public class PlatformController {

    @Autowired
    private PlatformService platformService;

    @RequestMapping("/*")
    public void toHtml(){

    }

    @ResponseBody
    @RequestMapping(value = "/manage", method = RequestMethod.POST)
    public ApiResultEntity manage(PlatformReq data) {
        if(data.getPlatformName()==null||data.getPlatformName().trim().isEmpty())
        {
            return  ApiResultEntity.returnResult(StateCode.ILLEGALREQUESTPARAMETER.get());
        }
        Platform entity= platformService.getByName(data.getPlatformName());

        if(data.getLongid()==null||data.getLongid()==0)
        {
            if(null!=entity)
            {
                return  ApiResultEntity.returnResult(StateCode.ARC10031002.get());
            }
            data.setAddtime(TimeUtil.GetDate());
            data.setModifytime(TimeUtil.GetDate());
            platformService.add(data);
        }
        else
        {
            Platform model=platformService.getById(data.getLongid());
            if(null==model)
            {
                return  ApiResultEntity.returnResult(StateCode.NODATAEXIST.get());
            }
            if(null!=entity && entity.getLongid()!=data.getLongid())
            {
                return ApiResultEntity.returnResult(StateCode.ARL10041001.get());
            }

            model.setPlatformName(data.getPlatformName());
            model.setModifytime(TimeUtil.GetDate());
            platformService.modify(model);
        }
        return ApiResultEntity.successResult(StateCode.success.get());
    }

    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public ApiResultEntity del(Long longid) {
        if (null == longid || longid == 0) {
            return ApiResultEntity.returnResult(StateCode.ILLEGALREQUESTPARAMETER.get());
        }

        ArticleClassRelationExample example=new ArticleClassRelationExample();
        ArticleClassRelationExample.Criteria criteria = example.createCriteria();
        criteria.andArticleClassIdEqualTo(longid);
       /* if(articleLevelService.countByExample(example)>0L)
        {
            return ApiResultEntity.returnResult(StateCode.ARC10031001.get());
        }*/
        platformService.del(longid);
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
        Platform entity=platformService.getById(longid);
        return ApiResultEntity.successResult(entity);
    }

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public  ApiResultEntity list()
    {
        List<Platform> list=platformService.getAll();
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
        PlatformExample example = new PlatformExample();
        PlatformExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("longid desc");
        if(key!=null&&key.trim().isEmpty()==false)
        {
            criteria.andPlatformNameLike(key);
        }
        return platformService.queryPageListByExample(example,page,size);
    }
}
