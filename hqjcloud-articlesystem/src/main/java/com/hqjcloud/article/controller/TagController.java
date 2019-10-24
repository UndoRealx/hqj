package com.hqjcloud.article.controller;

import com.hqjcloud.article.beans.Tag;
import com.hqjcloud.article.beans.TagExample;
import com.hqjcloud.article.common.ApiResultEntity;
import com.hqjcloud.article.common.TimeUtil;
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

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ApiResultEntity create(Tag data) {
        tagService.add(data);
        return ApiResultEntity.successResult(StateCode.success.get());
    }

    @ResponseBody
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public  ApiResultEntity modify(Tag data)
    {
        tagService.modify(data);
        return ApiResultEntity.successResult(StateCode.success.get());
    }

    /**
     * 更新与添加操作
     * @param data
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/manage", method = RequestMethod.POST)
    public ApiResultEntity manage(Tag data) {
        if (data.getTagName() == null || data.getTagName().trim().isEmpty()) {
            return ApiResultEntity.returnResult(StateCode.ILLEGALREQUESTPARAMETER.get());
        }
        Tag entity = tagService.getByName(data.getTagName());

        if (data.getLongid() == null || data.getLongid() == 0) {
            if (null != entity) {
                return ApiResultEntity.returnResult(StateCode.ARC10031002.get());
            }
            //添加
            data.setAddTime(TimeUtil.GetDate());
            tagService.add(data);
        } else {
            Tag model = tagService.getById(data.getLongid());
            if (null == model) {
                return ApiResultEntity.returnResult(StateCode.NODATAEXIST.get());
            }
            if (null != entity && entity.getLongid() != data.getLongid()) {
                return ApiResultEntity.returnResult(StateCode.ARL10041001.get());
            }
            //修改
            model.setTagName(data.getTagName());
            model.setAddTime(TimeUtil.GetDate());
            model.setTagStatus(data.getTagStatus());
            tagService.modify(model);
        }
        return ApiResultEntity.successResult(StateCode.success.get());
    }



    @ResponseBody
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
