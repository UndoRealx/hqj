package com.hqjcloud.article.controller;

import com.hqjcloud.article.beans.Tag;
import com.hqjcloud.article.beans.TagExample;
import com.hqjcloud.article.service.TagService;
import com.hqjcloud.base.ApiResultEntity;
import com.hqjcloud.base.enums.StateCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping(value = "/sys/hqjtag", produces = MediaType.APPLICATION_JSON_VALUE) //配置返回值 application/json
@Api(description = "文章标签")
public class TagController {
    @Autowired
    private TagService tagService;


    @ApiOperation(value = "新增")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ApiResultEntity create(@RequestBody Tag data) {
        tagService.add(data);
        return ApiResultEntity.successResult(StateCode.success.get());
    }

    @ApiOperation(value = "修改")
    @RequestMapping(value = "/modify", method = RequestMethod.PUT)
    public  ApiResultEntity modify(@RequestBody Tag data)
    {
        tagService.add(data);
        return ApiResultEntity.successResult(StateCode.success.get());
    }


    @ApiOperation(value = "删除")
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public ApiResultEntity del(Long longid)
    {
        tagService.del(longid);
        return ApiResultEntity.successResult(StateCode.success.get());
    }

    @ApiOperation(value = "获取单条")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public  ApiResultEntity info(Long longid)
    {
        Tag tag=tagService.getById(longid);
        return ApiResultEntity.successResult(tag);
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
        TagExample example = new TagExample();
        TagExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("longid desc");
        return tagService.queryPageListByExample(example,page,size);
    }
}
