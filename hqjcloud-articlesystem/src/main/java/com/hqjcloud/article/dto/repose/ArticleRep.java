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
        if(getAddTime()==null)
        {
            return "";
        }
        return TimeUtil.longToString(getAddTime(),TimeUtil.DATE_TIME_PATTERN);
    }



    private  String modifyTimes;

    public String getModifyTimes() {
        if(getModifyTime()==null)
        {
            return "";
        }
        return TimeUtil.longToString(getModifyTime(),TimeUtil.DATE_TIME_PATTERN);
    }



    private  String pubTimes;

    public String getPubTimes()
    {
        if(getPubTime()==null||getPubTime()==0)
        {
            return "";
        }
        return TimeUtil.longToString(getPubTime(),TimeUtil.DATE_TIME_PATTERN);
    }



    private  String artStatusName;

    public String getArtStatusName() {
        if(getArtStatus()==null)
        {
            return "";
        }
        return ArtStatusEnum.get(getArtStatus());
    }


    private  String artclass;


    public String getArtclass() {
        return artclass;
    }

    public void setArtclass(String artclass) {
        this.artclass = artclass;
    }

    private String platformName;

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    private  String  artLevelName;

    public String getArtLevelName() {
        return artLevelName;
    }

    public void setArtLevelName(String artLevelName) {
        this.artLevelName = artLevelName;
    }
}
