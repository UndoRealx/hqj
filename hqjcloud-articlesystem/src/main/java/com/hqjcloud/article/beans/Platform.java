package com.hqjcloud.article.beans;

public class Platform {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hqj_platform.longid
     *
     * @mbg.generated
     */
    private Long longid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hqj_platform.platform_name
     *
     * @mbg.generated
     */
    private String platformName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hqj_platform.addtime
     *
     * @mbg.generated
     */
    private Long addtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hqj_platform.modifytime
     *
     * @mbg.generated
     */
    private Long modifytime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hqj_platform.longid
     *
     * @return the value of hqj_platform.longid
     *
     * @mbg.generated
     */
    public Long getLongid() {
        return longid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hqj_platform.longid
     *
     * @param longid the value for hqj_platform.longid
     *
     * @mbg.generated
     */
    public void setLongid(Long longid) {
        this.longid = longid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hqj_platform.platform_name
     *
     * @return the value of hqj_platform.platform_name
     *
     * @mbg.generated
     */
    public String getPlatformName() {
        return platformName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hqj_platform.platform_name
     *
     * @param platformName the value for hqj_platform.platform_name
     *
     * @mbg.generated
     */
    public void setPlatformName(String platformName) {
        this.platformName = platformName == null ? null : platformName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hqj_platform.addtime
     *
     * @return the value of hqj_platform.addtime
     *
     * @mbg.generated
     */
    public Long getAddtime() {
        return addtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hqj_platform.addtime
     *
     * @param addtime the value for hqj_platform.addtime
     *
     * @mbg.generated
     */
    public void setAddtime(Long addtime) {
        this.addtime = addtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hqj_platform.modifytime
     *
     * @return the value of hqj_platform.modifytime
     *
     * @mbg.generated
     */
    public Long getModifytime() {
        return modifytime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hqj_platform.modifytime
     *
     * @param modifytime the value for hqj_platform.modifytime
     *
     * @mbg.generated
     */
    public void setModifytime(Long modifytime) {
        this.modifytime = modifytime;
    }
}