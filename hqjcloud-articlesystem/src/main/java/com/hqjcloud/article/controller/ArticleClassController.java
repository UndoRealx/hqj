package com.hqjcloud.article.controller;

import com.hqjcloud.article.beans.ArticleClass;
import com.hqjcloud.article.beans.ArticleClassExample;
import com.hqjcloud.article.service.ArticleClassService;
import com.hqjcloud.base.ApiResultEntity;
import com.hqjcloud.base.enums.StateCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(description = "")
public class ArticleClassController {
	@Autowired
	private ArticleClassService articleclassService;

    @RequestMapping("/*")
    public void toHtml(){

    }

	@ResponseBody
    @ApiOperation(value = "新增")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ApiResultEntity create(@RequestBody ArticleClass data) {
        articleclassService.add(data);
        return ApiResultEntity.successResult(StateCode.success.get());
    }
    @ResponseBody
    @ApiOperation(value = "修改")
    @RequestMapping(value = "/modify", method = RequestMethod.PUT)
    public  ApiResultEntity modify(@RequestBody ArticleClass data)
    {
        articleclassService.add(data);
        return ApiResultEntity.successResult(StateCode.success.get());
    }

    @ResponseBody
    @ApiOperation(value = "删除")
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public ApiResultEntity del(Long longid)
    {
        articleclassService.del(longid);
        return ApiResultEntity.successResult(StateCode.success.get());
    }
    @ResponseBody
    @ApiOperation(value = "获取单条")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public  ApiResultEntity info(Long longid)
    {
        ArticleClass articleClass=articleclassService.getById(longid);
        return ApiResultEntity.successResult(articleClass);
    }


    @ResponseBody
    @GetMapping(value = "/getByPage")
    @ApiOperation(value = "分页获取", notes = "分页获取")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "page", value = "第几页", dataType = "Integer"),
                    @ApiImplicitParam(paramType ="query", name = "size", value = "每页显示条数", dataType = "Integer")
            })
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

    @ResponseBody
    @ApiOperation(value = "获取所有上架的分类")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public  ApiResultEntity list()
    {
        List<ArticleClass> list=articleclassService.list(1);
        return ApiResultEntity.successResult(list);
    }
}
