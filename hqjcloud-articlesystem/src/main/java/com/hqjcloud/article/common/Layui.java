package com.hqjcloud.article.common;

import java.util.HashMap;
import java.util.List;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.common
 * @ClassName: Layui
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/24 10:12
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/24 10:12
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Layui extends HashMap<String, Object> {

    public static Layui data(Long count, List<?> data){

        Layui r = new Layui();

        r.put("code", 0);

        r.put("msg", "");

        r.put("count", count);

        r.put("data", data);

        return r;

    }

}