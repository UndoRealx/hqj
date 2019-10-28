package com.hqjcloud.article.common;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.data
 * @ClassName: BasePageList
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/20 15:12
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/20 15:12
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class BasePageList<T> {

    private Object list;
    private int pageNum;
    private int pageSize;
    private long total;

    public  Object getList() {
        return list;
    }

    public void setList(Object list) {
        this.list = list;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("PageInfo{");
        sb.append("pageNum=").append(this.pageNum);
        sb.append(", pageSize=").append(this.pageSize);
        sb.append(", total=").append(this.total);
        sb.append(", list=").append(this.list);
        sb.append('}');
        return sb.toString();
    }
}
