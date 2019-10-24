package com.hqjcloud.article.dto.request;

import com.hqjcloud.article.beans.Article;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.dto.request
 * @ClassName: ArticleReq
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/27 9:49
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/27 9:49
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ArticleReq extends Article {



    private  String artClass;

    private  String pubTimes;

    public ArticleReq() {
    }


    public String getPubTimes() {
        return pubTimes;
    }

    public void setPubTimes(String pubTimes) {
        this.pubTimes = pubTimes;
    }





    public String getArtclass() {
        return artClass;
    }

    public void setArtclass(String artclass) {
        this.artClass = artclass;
    }


    private Long topLevelId;
    private Long  secLevelId;


    public Long getTopLevelId() {
        return topLevelId;
    }

    public void setTopLevelId(Long topLevelId) {
        this.topLevelId = topLevelId;
    }

    public Long getSecLevelId() {
        return secLevelId;
    }

    public void setSecLevelId(Long secLevelId) {
        this.secLevelId = secLevelId;
    }
}
