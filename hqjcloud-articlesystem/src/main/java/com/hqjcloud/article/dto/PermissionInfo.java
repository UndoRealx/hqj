package com.hqjcloud.article.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.dto
 * @ClassName: PermissionInfo
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/9 15:54
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/9 15:54
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class PermissionInfo implements Serializable {

    private static final long serialVersionUID = -1886827721229436347L;

    private String title;

    private String value;

    private boolean checked;

    private boolean disabled;

    private List<PermissionInfo> data = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean getChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public List<PermissionInfo> getData() {
        return data;
    }

    public void setData(List<PermissionInfo> data) {
        this.data = data;
    }

}