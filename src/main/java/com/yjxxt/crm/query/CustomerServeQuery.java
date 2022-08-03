package com.yjxxt.crm.query;

import com.yjxxt.crm.base.BaseQuery;

/**
 * @author post
 * @Date 2021/8/11 7:18
 */
public class CustomerServeQuery extends BaseQuery {
    private String name;
    private Integer price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
