package com.hqjcloud.generator.base.dao;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.generator.base.dao
 * @ClassName: SysGeneratorDao
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/19 11:43
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/19 11:43
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface SysGeneratorDao {

    List<Map<String, Object>> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);
}
