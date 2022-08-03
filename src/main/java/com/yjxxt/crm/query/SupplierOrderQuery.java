package com.yjxxt.crm.query;

import com.yjxxt.crm.base.BaseQuery;

/**
 * @Auther: wangkk
 * @Date: 2022/7/28 - 07 - 28 - 11:27
 * @Description: com.post.crm.query
 * @version: 1.0
 */
public class SupplierOrderQuery extends BaseQuery {
        //是根据id 去查的
        private Integer suId;

    public Integer getSuId() {
        return suId;
    }

    public void setSuId(Integer suId) {
        this.suId = suId;
    }
}
