package com.hqjcloud.article.dto.request;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.dto.request
 * @ClassName: ArticleClassReq
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/8 16:47
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/8 16:47
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ArticleClassReq {

    private Long longid;
    private  String className;
    private  Integer status;

    public Long getLongid() {
        return longid;
    }

    public void setLongid(Long longid) {
        this.longid = longid;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
