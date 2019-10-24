package com.hqjcloud.article.dto.repose;

import com.hqjcloud.article.beans.ArticleLevel;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.dto.repose
 * @ClassName: ArticleLevelRep
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/22 16:29
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/22 16:29
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ArticleLevelRep extends ArticleLevel {

    private  String platformName;

    private  String parentLevelName;

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getParentLevelName() {
        return parentLevelName;
    }

    public void setParentLevelName(String parentLevelName) {
        this.parentLevelName = parentLevelName;
    }
}
