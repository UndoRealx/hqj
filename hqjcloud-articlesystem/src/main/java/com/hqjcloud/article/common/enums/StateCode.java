package com.hqjcloud.article.common.enums;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.base.enums
 * @ClassName: ErrorCodeEnum
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/11 16:32
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/11 16:32
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public enum StateCode {

    success(0,"操作成功"), 															// 操作成功
    UNKNOWNERROR(10001,"未知错误"), 									// 未知错误
    DATAERROR(10002,"数据错误"), 											// 数据错误
    ILLEGALREQUESTPARAMETER(10003,"请求参数错误"), 				// 请求参数错误
    MISSINGPARAMETER(10004,"参数不全"), 								// 参数不全
    NODATAEXIST(10005,"没有相关数据"), 										// 没有相关数据

    /*1001 用户中心*/

    /*1002 文章中心*/
    ART10021001(10021001, "文章标题不能为空"),
    ART10021002(10021002, "文章内容不能为空"),


    /*1003 文章分类中心*/
    ARC10031001(10031001, "存在关联文章,无法删除!"),
    ARC10031002(10031002, "分类名称已存在!"),


    /*1004 文章栏目*/
    ARL10041001(10041001, "分类栏目已存在,同一级目录的名称不能重复!");


    private int value;
    private String msg;

    /**
     * Msg string.
     *
     * @return the string
     */
    public String msg() {
        return msg;
    }

    /**
     * Code int.
     *
     * @return the int
     */
    public int get() {
        return value;
    }

    StateCode(int value, String msg) {
        this.value = value;
        this.msg = msg;
    }

    /**
     * Gets enum.
     *
     * @param code the code
     *
     * @return the enum
     */
    public static String get(int code) {
        for (StateCode ele : StateCode.values()) {
            if (ele.get() == code) {
                return ele.msg();
            }
        }
        return null;
    }
}
