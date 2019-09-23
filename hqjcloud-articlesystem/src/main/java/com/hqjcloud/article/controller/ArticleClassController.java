package com.hqjcloud.article.controller;

import com.hqjcloud.article.beans.ArticleClass;
import com.hqjcloud.article.beans.ArticleClassExample;
import com.hqjcloud.article.service.ArticleClassService;
import com.hqjcloud.base.ApiResultEntity;
import com.hqjcloud.base.enums.StateCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * 
 * 
 * @author Lic
 * @email hqj@hqj.com
 * @date 2019-09-20 16:22:06
 */
@Controller
@RequestMapping(value = "/articleclass", produces = MediaType.APPLICATION_JSON_VALUE) //配置返回值 application/json
@Api(description = "")
public class ArticleClassController {
	@Autowired
	private ArticleClassService articleclassService;


    @ApiOperation(value = "新增")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ApiResultEntity create(@RequestBody ArticleClass data) {
        articleclassService.add(data);
        return ApiResultEntity.successResult(StateCode.success.get());
    }

    @ApiOperation(value = "修改")
    @RequestMapping(value = "/modify", method = RequestMethod.PUT)
    public  ApiResultEntity modify(@RequestBody ArticleClass data)
    {
        articleclassService.add(data);
        return ApiResultEntity.successResult(StateCode.success.get());
    }


    @ApiOperation(value = "删除")
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public ApiResultEntity del(Long longid)
    {
        articleclassService.del(longid);
        return ApiResultEntity.successResult(StateCode.success.get());
    }

    @ApiOperation(value = "获取单条")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public  ApiResultEntity info(Long longid)
    {
        ArticleClass articleClass=articleclassService.getById(longid);
        return ApiResultEntity.successResult(articleClass);
    }

    @GetMapping(value = "/getByPage")
    @ApiOperation(value = "分页获取", notes = "分页获取")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "page", value = "第几页", dataType = "Integer"),
                    @ApiImplicitParam(paramType ="query", name = "size", value = "每页显示条数", dataType = "Integer")
            })
    public ApiResultEntity getByPage(@RequestParam(required = false,defaultValue = "1") Integer page,
                                     @RequestParam(required = false,defaultValue = "15") Integer size)
    {
        ArticleClassExample example = new ArticleClassExample();
        ArticleClassExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("longid desc");
        return articleclassService.queryPageListByExample(example,page,size);
    }
}
