package com.hqjcloud.article.controller;

import com.hqjcloud.article.beans.Tag;
import com.hqjcloud.article.beans.TagExample;
import com.hqjcloud.article.common.ApiResultEntity;
import com.hqjcloud.article.common.enums.StateCode;
import com.hqjcloud.article.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * 
 * 
 * @author Lic
 * @email hqj@hqj.com
 * @date 2019-09-20 16:22:06
 */
@RestController
@RequestMapping(value = "/sys/hqjtag", produces = MediaType.APPLICATION_JSON_VALUE) //配置返回值 application/json

public class TagController {
    @Autowired
    private TagService tagService;



    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ApiResultEntity create(@RequestBody Tag data) {
        tagService.add(data);
        return ApiResultEntity.successResult(StateCode.success.get());
    }


    @RequestMapping(value = "/modify", method = RequestMethod.PUT)
    public  ApiResultEntity modify(@RequestBody Tag data)
    {
        tagService.add(data);
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
    @GetMapping(value = "/getByPage")
    public ApiResultEntity getByPage(@RequestParam(required = false,defaultValue = "1") Integer page,
                                     @RequestParam(required = false,defaultValue = "15") Integer size)
    {
        TagExample example = new TagExample();
        TagExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("longid desc");
        return tagService.queryPageListByExample(example,page,size);
    }
}
