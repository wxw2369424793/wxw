package com.yjxxt.crm.dao;

import com.yjxxt.crm.base.BaseMapper;
import com.yjxxt.crm.query.CustomerServeQuery;
import com.yjxxt.crm.vo.Cgr;

import java.util.List;

public interface CustomerServeMapper extends BaseMapper<Cgr,Integer> {
    //多条件分页查询数据
    public List<Cgr> queryByParams(CustomerServeQuery query);
    public Integer deleteBatch(Integer[] ids);

    //多条件分页查询出售的数据
    public List<Cgr> queryByParams2(CustomerServeQuery query);
}