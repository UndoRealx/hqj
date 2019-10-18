package com.hqjcloud.article.dto.repose;

import com.hqjcloud.article.beans.ArticleClass;
import com.hqjcloud.article.common.CommonStatusEnum;
import com.hqjcloud.article.common.TimeUtil;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.dto.repose
 * @ClassName: ArticleClassRep
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/8 10:08
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/8 10:08
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ArticleClassRep extends ArticleClass {

    private String addTimes;

    public String getAddTimes() {
        if(getAddTime()==null)
        {
            return "";
        }
        return TimeUtil.dateToString(TimeUtil.longToDate(getAddTime()));
    }


    private  String artStatusName;

    public String getArtStatusName() {
        if(getStatus()==null)
        {
            return "";
        }
        return CommonStatusEnum.get(getStatus());
    }
}
