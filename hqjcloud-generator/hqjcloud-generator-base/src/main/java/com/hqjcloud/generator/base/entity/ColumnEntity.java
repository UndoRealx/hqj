package com.hqjcloud.generator.base.entity;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.generator.base.entity
 * @ClassName: ColumnEntity
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/19 11:43
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/19 11:43
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ColumnEntity {
    //列名
    private String columnName;
    //列名类型
    private String dataType;
    //列名备注
    private String comments;

    //属性名称(第一个字母大写)，如：user_name => UserName
    private String attrName;
    //属性名称(第一个字母小写)，如：user_name => userName
    private String attrname;
    //属性类型
    private String attrType;
    //auto_increment
    private String extra;
    //是否自增
    private  boolean isIdentity;

    private boolean isNullAble;

    private  boolean isPrimarykey;

    public String getColumnName() {
        return columnName;
    }
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
    public String getDataType() {
        return dataType;
    }
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    public String getAttrname() {
        return attrname;
    }
    public void setAttrname(String attrname) {
        this.attrname = attrname;
    }
    public String getAttrName() {
        return attrName;
    }
    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }
    public String getAttrType() {
        return attrType;
    }
    public void setAttrType(String attrType) {
        this.attrType = attrType;
    }
    public String getExtra() {
        return extra;
    }
    public void setExtra(String extra) {
        if(null!=extra)
            this.isIdentity=extra.equalsIgnoreCase("auto_increment");
        this.extra = extra;
    }

    public boolean getIsPrimarykey() {
        return isPrimarykey;
    }
    public void setIsPrimarykey(String column_key) {
        this.isPrimarykey = column_key.equalsIgnoreCase("pri");
    }

    public boolean getIsIdentity()
    {
        return  isIdentity;
    }
    public void setIsNullAble(String _isNullAble) {
        this.isNullAble = _isNullAble=="YES";
    }
}
