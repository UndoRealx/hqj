package com.hqjcloud.article.dto.repose;

import com.hqjcloud.article.beans.Article;
import com.hqjcloud.article.common.ArtStatusEnum;
import com.hqjcloud.article.common.TimeUtil;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.dto.repose
 * @ClassName: ArticleRep
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/24 14:45
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/24 14:45
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ArticleRep extends Article {

    private String addTimes;

    public String getAddTimes() {
        if(getAddtime()==null)
        {
            return "";
        }
        return TimeUtil.dateToString(TimeUtil.longToDate(getAddtime()));
    }



    private  String modifyTimes;

    public String getModifyTimes() {
        if(getModifytime()==null)
        {
            return "";
        }
        return TimeUtil.dateToString(TimeUtil.longToDate(getModifytime()));
    }



    private  String pubTimes;

    public String getPubTimes()
    {
        if(getPubtime()==null)
        {
            return "";
        }
        return TimeUtil.dateToString(TimeUtil.longToDate(getPubtime()));
    }



    private  String artStatusName;

    public String getArtStatusName() {
        if(getArtstatus()==null)
        {
            return "";
        }
        return ArtStatusEnum.get(getArtstatus());
    }


    private  String artclass;


    public String getArtclass() {
        return artclass;
    }

    public void setArtclass(String artclass) {
        this.artclass = artclass;
    }
}
