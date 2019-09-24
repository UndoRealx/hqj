package com.hqjcloud.article.controller;

import com.hqjcloud.article.beans.Article;
import com.hqjcloud.article.beans.ArticleExample;
import com.hqjcloud.article.common.Layui;
import com.hqjcloud.article.common.TimeUtil;
import com.hqjcloud.article.service.ArticleService;
import com.hqjcloud.base.ApiResultEntity;
import com.hqjcloud.base.enums.StateCode;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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


    @RequestMapping("/*")
    public void toHtml(){

    }

    @ResponseBody
    @ApiOperation(value = "置顶")
    @RequestMapping(value = "/top", method = RequestMethod.POST)
    public ApiResultEntity top(Long longid,int isTop) {

        Article article=articleService.getById(longid);
        if(null==article)
        {
            return ApiResultEntity.returnResult(StateCode.NODATAEXIST.get());
        }
        article.setIstop(Byte.parseByte(String.valueOf(isTop)));
        article.setModifytime(TimeUtil.GetDate());
        articleService.modify(article);
        return ApiResultEntity.successResult(StateCode.success.get());
    }

    @ApiOperation(value = "新增")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ApiResultEntity create(@RequestBody Article data) {
        articleService.add(data);
        return ApiResultEntity.successResult(StateCode.success.get());
    }

    @ApiOperation(value = "修改")
    @RequestMapping(value = "/modify", method = RequestMethod.PUT)
    public  ApiResultEntity modify(@RequestBody Article data)
    {
        articleService.add(data);
        return ApiResultEntity.successResult(StateCode.success.get());
    }


    @ApiOperation(value = "删除")
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public ApiResultEntity del(Long longid)
    {
        articleService.del(longid);
        return ApiResultEntity.successResult(StateCode.success.get());
    }

    @ApiOperation(value = "获取单条")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public  ApiResultEntity info(Long longid)
    {
        Article article=articleService.getById(longid);
        return ApiResultEntity.successResult(article);
    }

    @ResponseBody
    @GetMapping(value = "/getByPage")
    @ApiOperation(value = "分页获取", notes = "分页获取")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "page", value = "第几页", dataType = "Integer"),
                    @ApiImplicitParam(paramType ="query", name = "size", value = "每页显示条数", dataType = "Integer")
            })
    public Layui getByPage(@RequestParam(required = false,defaultValue = "1") String key,
                           @RequestParam(required = false,defaultValue = "1") Integer page,
                           @RequestParam(required = false,defaultValue = "15") Integer size)
    {
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        if(key!=null||key.trim().isEmpty()==false)
        {
            criteria.andArttitleLike(key);
        }
        example.setOrderByClause("longid desc");
        return articleService.queryPageListByExample(example,page,size);
    }

}
