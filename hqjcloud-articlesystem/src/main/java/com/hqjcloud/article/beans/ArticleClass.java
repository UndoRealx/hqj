package com.hqjcloud.article.beans;

public class ArticleClass {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hqj_article_class.longid
     *
     * @mbg.generated
     */
    private Long longid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hqj_article_class.class_name
     *
     * @mbg.generated
     */
    private String className;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hqj_article_class.add_time
     *
     * @mbg.generated
     */
    private Long addTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hqj_article_class.sort
     *
     * @mbg.generated
     */
    private Integer sort;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hqj_article_class.status
     *
     * @mbg.generated
     */
    private Byte status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hqj_article_class.longid
     *
     * @return the value of hqj_article_class.longid
     *
     * @mbg.generated
     */
    public Long getLongid() {
        return longid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hqj_article_class.longid
     *
     * @param longid the value for hqj_article_class.longid
     *
     * @mbg.generated
     */
    public void setLongid(Long longid) {
        this.longid = longid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hqj_article_class.class_name
     *
     * @return the value of hqj_article_class.class_name
     *
     * @mbg.generated
     */
    public String getClassName() {
        return className;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hqj_article_class.class_name
     *
     * @param className the value for hqj_article_class.class_name
     *
     * @mbg.generated
     */
    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hqj_article_class.add_time
     *
     * @return the value of hqj_article_class.add_time
     *
     * @mbg.generated
     */
    public Long getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hqj_article_class.add_time
     *
     * @param addTime the value for hqj_article_class.add_time
     *
     * @mbg.generated
     */
    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hqj_article_class.sort
     *
     * @return the value of hqj_article_class.sort
     *
     * @mbg.generated
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hqj_article_class.sort
     *
     * @param sort the value for hqj_article_class.sort
     *
     * @mbg.generated
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hqj_article_class.status
     *
     * @return the value of hqj_article_class.status
     *
     * @mbg.generated
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hqj_article_class.status
     *
     * @param status the value for hqj_article_class.status
     *
     * @mbg.generated
     */
    public void setStatus(Byte status) {
        this.status = status;
    }
}