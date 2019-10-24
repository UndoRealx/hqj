package com.hqjcloud.article.controller;

import com.hqjcloud.article.beans.Tag;
import com.hqjcloud.article.beans.TagExample;
import com.hqjcloud.article.common.ApiResultEntity;
import com.hqjcloud.article.common.enums.StateCode;
import com.hqjcloud.article.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/tag") //配置返回值 application/json
public class TagController {
    @Autowired
    private TagService tagService;

    @RequestMapping("/*")
    public void toHtml(){
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ApiResultEntity create(@RequestBody Tag data) {
        tagService.add(data);
        return ApiResultEntity.successResult(StateCode.success.get());
    }


    @RequestMapping(value = "/modify", method = RequestMethod.PUT)
    public  ApiResultEntity modify(@RequestBody Tag data)
    {
        tagService.modify(data);
        return ApiResultEntity.successResult(StateCode.success.get());
    }



    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public ApiResultEntity del(Long longid)
    {
        tagService.del(longid);
        return ApiResultEntity.successResult(StateCode.success.get());
    }


    /**
     *单条获取
     * @param longid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public  ApiResultEntity info(Long longid)
    {
        Tag tag=tagService.getById(longid);
        return ApiResultEntity.successResult(tag);
    }

    /**
     * 批量获取
     * @param page
     * @param size
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/getByPage")
    public ApiResultEntity getByPage(@RequestParam(required = false,defaultValue = "1") Integer page,
                                     @RequestParam(required = false,defaultValue = "15") Integer size)
    {
        TagExample example = new TagExample();
        TagExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("longid desc");
        return tagService.queryPageListByExample(example,page,size);
    }


    
    /**
    *@Description 随机获取几条
    *@Param  * @param page
    * @param
    *@Return com.hqjcloud.article.common.ApiResultEntity
    *@Author lic
    *@Date 2019/10/23
    *@Time 16:50
    */
    @ResponseBody
    @GetMapping(value = "/getByRand")
    public ApiResultEntity getByPage()
    {
        TagExample example = new TagExample();
        TagExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("RAND()");
        return tagService.queryPageListByExample(example,1,10);
    }

    
}
