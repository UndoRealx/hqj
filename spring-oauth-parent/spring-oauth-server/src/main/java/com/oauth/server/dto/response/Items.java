package com.oauth.server.dto.response;

import lombok.Data;

import java.util.List;

/**
 * @author yuit
 * @date  2018/8/6 15:56
 *
 **/

public class Items<T> {

   private   long count;
    private  List<T> items;

    public Items() {

    }

    public Items(long count, List<T> items) {
        this.count = count;
        this.items = items;
    }


    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
