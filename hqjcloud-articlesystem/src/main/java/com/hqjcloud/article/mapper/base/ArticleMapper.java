package com.hqjcloud.article.mapper.base;

import com.hqjcloud.article.beans.Article;
import com.hqjcloud.article.beans.ArticleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
    long countByExample(ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
    int deleteByExample(ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long longid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
    int insert(Article record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
    int insertSelective(Article record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
    List<Article> selectByExampleWithBLOBs(ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
    List<Article> selectByExample(ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
    Article selectByPrimaryKey(Long longid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") Article record, @Param("example") ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Article record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(Article record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Article record);
}