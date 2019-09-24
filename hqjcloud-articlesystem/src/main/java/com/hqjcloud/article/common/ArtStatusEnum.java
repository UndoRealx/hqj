package com.hqjcloud.article.common;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.common
 * @ClassName: ArtStatusEnum
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/24 14:50
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/24 14:50
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public enum ArtStatusEnum
{
    draft(0,"草稿"),
    waitPub(1,"待发布"),
    Pub(5,"已发布"),
    LowerShelf(10,"下架");
    //状态:0 待发布  10下架  5 已发布

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

    ArtStatusEnum(int value, String msg) {
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
