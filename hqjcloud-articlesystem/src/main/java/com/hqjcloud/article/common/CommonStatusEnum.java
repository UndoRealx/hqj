package com.hqjcloud.article.common;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.common
 * @ClassName: CommonStatusEnum
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/8 10:51
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/8 10:51
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public enum CommonStatusEnum {
    unEnable(0,"禁用"),
    enable(1,"启用");

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

    CommonStatusEnum(int value, String msg) {
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
        for (ArtStatusEnum ele : ArtStatusEnum.values()) {
            if (ele.get() == code) {
                return ele.msg();
            }
        }
        return null;
    }
}
