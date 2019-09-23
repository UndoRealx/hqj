package com.hqjcloud.data;


/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.data
 * @ClassName: BaseService
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/20 15:15
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/20 15:15
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface BaseService<Record,Example> {

    /**
     * 插入记录
     * @param record
     * @return
     */
    int insert(Record record);

    /**
     * 插入记录有效字段
     * @param record
     * @return
     */
    int insertSelective(Record record);



    /**
     * 根据主键更新记录有效字段
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Record record);

    /**
     * 根据主键更新记录，附带BLOB字段
     * @param record
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(Record record);

    /**
     * 根据主键更新记录
     * @param record
     * @return
     */
    int updateByPrimaryKey(Record record);

    /**
     * 根据主键删除记录
     * @param id
     * @return
     */
    int deleteByPrimaryKey(long id);


    /**
     * 根据主键查询记录
     * @param id
     * @return
     */
    Record selectByPrimaryKey(Long id);



}