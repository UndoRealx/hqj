package com.hqjcloud.article.beans;

public class Article {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hqj_article.longid
     *
     * @mbg.generated
     */
    private Long longid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hqj_article.art_title
     *
     * @mbg.generated
     */
    private String artTitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hqj_article.art_abstract
     *
     * @mbg.generated
     */
    private String artAbstract;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hqj_article.art_level
     *
     * @mbg.generated
     */
    private Long artLevel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hqj_article.art_icletag
     *
     * @mbg.generated
     */
    private String artIcletag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hqj_article.art_image
     *
     * @mbg.generated
     */
    private String artImage;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hqj_article.visit_cnt
     *
     * @mbg.generated
     */
    private Integer visitCnt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hqj_article.art_status
     *
     * @mbg.generated
     */
    private Integer artStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hqj_article.likes
     *
     * @mbg.generated
     */
    private Integer likes;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hqj_article.author
     *
     * @mbg.generated
     */
    private String author;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hqj_article.art_sort
     *
     * @mbg.generated
     */
    private Integer artSort;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hqj_article.is_top
     *
     * @mbg.generated
     */
    private Byte isTop;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hqj_article.add_time
     *
     * @mbg.generated
     */
    private Long addTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hqj_article.modify_time
     *
     * @mbg.generated
     */
    private Long modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hqj_article.pub_time
     *
     * @mbg.generated
     */
    private Long pubTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hqj_article.art_content
     *
     * @mbg.generated
     */
    private String artContent;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hqj_article.longid
     *
     * @return the value of hqj_article.longid
     *
     * @mbg.generated
     */
    public Long getLongid() {
        return longid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hqj_article.longid
     *
     * @param longid the value for hqj_article.longid
     *
     * @mbg.generated
     */
    public void setLongid(Long longid) {
        this.longid = longid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hqj_article.art_title
     *
     * @return the value of hqj_article.art_title
     *
     * @mbg.generated
     */
    public String getArtTitle() {
        return artTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hqj_article.art_title
     *
     * @param artTitle the value for hqj_article.art_title
     *
     * @mbg.generated
     */
    public void setArtTitle(String artTitle) {
        this.artTitle = artTitle == null ? null : artTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hqj_article.art_abstract
     *
     * @return the value of hqj_article.art_abstract
     *
     * @mbg.generated
     */
    public String getArtAbstract() {
        return artAbstract;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hqj_article.art_abstract
     *
     * @param artAbstract the value for hqj_article.art_abstract
     *
     * @mbg.generated
     */
    public void setArtAbstract(String artAbstract) {
        this.artAbstract = artAbstract == null ? null : artAbstract.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hqj_article.art_level
     *
     * @return the value of hqj_article.art_level
     *
     * @mbg.generated
     */
    public Long getArtLevel() {
        return artLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hqj_article.art_level
     *
     * @param artLevel the value for hqj_article.art_level
     *
     * @mbg.generated
     */
    public void setArtLevel(Long artLevel) {
        this.artLevel = artLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hqj_article.art_icletag
     *
     * @return the value of hqj_article.art_icletag
     *
     * @mbg.generated
     */
    public String getArtIcletag() {
        return artIcletag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hqj_article.art_icletag
     *
     * @param artIcletag the value for hqj_article.art_icletag
     *
     * @mbg.generated
     */
    public void setArtIcletag(String artIcletag) {
        this.artIcletag = artIcletag == null ? null : artIcletag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hqj_article.art_image
     *
     * @return the value of hqj_article.art_image
     *
     * @mbg.generated
     */
    public String getArtImage() {
        return artImage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hqj_article.art_image
     *
     * @param artImage the value for hqj_article.art_image
     *
     * @mbg.generated
     */
    public void setArtImage(String artImage) {
        this.artImage = artImage == null ? null : artImage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hqj_article.visit_cnt
     *
     * @return the value of hqj_article.visit_cnt
     *
     * @mbg.generated
     */
    public Integer getVisitCnt() {
        return visitCnt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hqj_article.visit_cnt
     *
     * @param visitCnt the value for hqj_article.visit_cnt
     *
     * @mbg.generated
     */
    public void setVisitCnt(Integer visitCnt) {
        this.visitCnt = visitCnt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hqj_article.art_status
     *
     * @return the value of hqj_article.art_status
     *
     * @mbg.generated
     */
    public Integer getArtStatus() {
        return artStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hqj_article.art_status
     *
     * @param artStatus the value for hqj_article.art_status
     *
     * @mbg.generated
     */
    public void setArtStatus(Integer artStatus) {
        this.artStatus = artStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hqj_article.likes
     *
     * @return the value of hqj_article.likes
     *
     * @mbg.generated
     */
    public Integer getLikes() {
        return likes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hqj_article.likes
     *
     * @param likes the value for hqj_article.likes
     *
     * @mbg.generated
     */
    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hqj_article.author
     *
     * @return the value of hqj_article.author
     *
     * @mbg.generated
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hqj_article.author
     *
     * @param author the value for hqj_article.author
     *
     * @mbg.generated
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hqj_article.art_sort
     *
     * @return the value of hqj_article.art_sort
     *
     * @mbg.generated
     */
    public Integer getArtSort() {
        return artSort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hqj_article.art_sort
     *
     * @param artSort the value for hqj_article.art_sort
     *
     * @mbg.generated
     */
    public void setArtSort(Integer artSort) {
        this.artSort = artSort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hqj_article.is_top
     *
     * @return the value of hqj_article.is_top
     *
     * @mbg.generated
     */
    public Byte getIsTop() {
        return isTop;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hqj_article.is_top
     *
     * @param isTop the value for hqj_article.is_top
     *
     * @mbg.generated
     */
    public void setIsTop(Byte isTop) {
        this.isTop = isTop;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hqj_article.add_time
     *
     * @return the value of hqj_article.add_time
     *
     * @mbg.generated
     */
    public Long getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hqj_article.add_time
     *
     * @param addTime the value for hqj_article.add_time
     *
     * @mbg.generated
     */
    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hqj_article.modify_time
     *
     * @return the value of hqj_article.modify_time
     *
     * @mbg.generated
     */
    public Long getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hqj_article.modify_time
     *
     * @param modifyTime the value for hqj_article.modify_time
     *
     * @mbg.generated
     */
    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hqj_article.pub_time
     *
     * @return the value of hqj_article.pub_time
     *
     * @mbg.generated
     */
    public Long getPubTime() {
        return pubTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hqj_article.pub_time
     *
     * @param pubTime the value for hqj_article.pub_time
     *
     * @mbg.generated
     */
    public void setPubTime(Long pubTime) {
        this.pubTime = pubTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hqj_article.art_content
     *
     * @return the value of hqj_article.art_content
     *
     * @mbg.generated
     */
    public String getArtContent() {
        return artContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hqj_article.art_content
     *
     * @param artContent the value for hqj_article.art_content
     *
     * @mbg.generated
     */
    public void setArtContent(String artContent) {
        this.artContent = artContent == null ? null : artContent.trim();
    }
}