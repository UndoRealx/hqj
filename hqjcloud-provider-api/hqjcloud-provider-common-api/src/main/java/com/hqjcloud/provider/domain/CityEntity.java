package com.hqjcloud.provider.domain;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.provider.domain
 * @ClassName: CityEntity
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/12 9:04
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/12 9:04
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CityEntity {

    private  long id;

    private  String  cityName;

    private  long pid;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }
}
