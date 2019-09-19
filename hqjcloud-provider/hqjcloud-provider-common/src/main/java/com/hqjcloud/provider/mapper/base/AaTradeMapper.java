package com.hqjcloud.provider.mapper.base;

import com.hqjcloud.provider.domain.AaTrade;
import com.hqjcloud.provider.domain.AaTradeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AaTradeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_aa_trade
     *
     * @mbg.generated
     */
    long countByExample(AaTradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_aa_trade
     *
     * @mbg.generated
     */
    int deleteByExample(AaTradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_aa_trade
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long longid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_aa_trade
     *
     * @mbg.generated
     */
    int insert(AaTrade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_aa_trade
     *
     * @mbg.generated
     */
    int insertSelective(AaTrade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_aa_trade
     *
     * @mbg.generated
     */
    List<AaTrade> selectByExample(AaTradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_aa_trade
     *
     * @mbg.generated
     */
    AaTrade selectByPrimaryKey(Long longid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_aa_trade
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") AaTrade record, @Param("example") AaTradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_aa_trade
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") AaTrade record, @Param("example") AaTradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_aa_trade
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(AaTrade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_aa_trade
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(AaTrade record);
}