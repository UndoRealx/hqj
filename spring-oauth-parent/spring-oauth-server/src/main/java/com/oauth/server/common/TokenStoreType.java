package com.oauth.server.common;

/**
 * @ProjectName: hqjcloud
 * @Package: com.oauth.server.common
 * @ClassName: TokenStoreType
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/11/4 16:02
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/4 16:02
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public enum TokenStoreType {
    /*
        内存
     */
    memory,
    /*
        redis
     */
    redis,
    /*
        json web token
     */
    jwt,
    /*
        数据库
     */
    jdbc
}
