package com.hqjcloud.article.dto.repose;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.dto.repose
 * @ClassName: ReturnUploadImage
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/12 11:11
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/12 11:11
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ReturnUploadImage {

    private  String state;

    private  String url;

    private  String title;

    private  String original;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }
}
