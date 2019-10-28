package com.hqjcloud.article.mapper;

import com.hqjcloud.article.beans.Platform;
import com.hqjcloud.article.common.BaseMapper;
import com.hqjcloud.article.mapper.base.PlatformMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.mapper
 * @ClassName: PlatformExMapper
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/22 11:04
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/22 11:04
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface PlatformExMapper extends PlatformMapper, BaseMapper<Platform> {

    public List<Map> getByPage(@Param("key")String key);
}
