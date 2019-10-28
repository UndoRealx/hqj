package com.hqjcloud.article.mapper;

import com.hqjcloud.article.beans.Tag;
import com.hqjcloud.article.common.BaseMapper;
import com.hqjcloud.article.mapper.base.TagMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.mapper
 * @ClassName: TagExMapper
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/20 15:55
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/20 15:55
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface TagExMapper extends TagMapper, BaseMapper<Tag> {

    public List<Map> getByPage(@Param("key")String key);
}
