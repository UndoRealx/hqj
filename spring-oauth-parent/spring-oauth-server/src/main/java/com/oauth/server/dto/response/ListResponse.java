package com.oauth.server.dto.response;

import java.util.List;

/**
 * @author yuit
 * @date   2018/3/30 20:37
 *
 */

public class ListResponse extends BaseResponse {

    private long count;
    private List items;

    protected ListResponse(){

    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }
}
