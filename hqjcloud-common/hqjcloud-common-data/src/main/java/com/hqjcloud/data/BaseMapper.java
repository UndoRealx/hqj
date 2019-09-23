package com.hqjcloud.data;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.data
 * @ClassName: BaseMapper
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/12 11:59
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/12 11:59
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface BaseMapper<T> {
    public  List<T> getByPage(@Param("page") int page, @Param("size") int size);
}
