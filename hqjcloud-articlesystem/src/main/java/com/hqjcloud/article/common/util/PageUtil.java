package com.hqjcloud.article.common.util;


import com.hqjcloud.article.common.BasePageList;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.data.util
 * @ClassName: PageUtil
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/20 15:10
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/20 15:10
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class PageUtil {
    //统一返回状态码
    public static BasePageList returnPageList(com.github.pagehelper.PageInfo pageInfo) {
        BasePageList pageList = new BasePageList();
        pageList.setPageNum(pageInfo.getPageNum());
        pageList.setPageSize(pageInfo.getPageSize());
        pageList.setTotal(pageInfo.getTotal());
        pageList.setList(pageInfo.getList());
        return pageList;
    }

    public static BasePageList returnPageList(com.github.pagehelper.PageInfo pageInfo, List<?> newList) {
        BasePageList pageList = new BasePageList();
        pageList.setPageNum(pageInfo.getPageNum());
        pageList.setPageSize(pageInfo.getPageSize());
        pageList.setTotal(pageInfo.getTotal());
        pageList.setList(newList);
        return pageList;
    }

    public static BasePageList returnPageList(com.github.pagehelper.PageInfo pageInfo, Map map) {
        BasePageList pageList = new BasePageList();
        pageList.setPageNum(pageInfo.getPageNum());
        pageList.setPageSize(pageInfo.getPageSize());
        pageList.setTotal(pageInfo.getTotal());
        pageList.setList(map);
        return pageList;
    }
}
