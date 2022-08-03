package com.yjxxt.crm.dao;

import com.yjxxt.crm.base.BaseMapper;
import com.yjxxt.crm.query.ProducePlanQuery;
import com.yjxxt.crm.vo.ProducePlane;

import java.util.List;

public interface ProducePlaneMapper extends BaseMapper<ProducePlane,Integer> {
    //多条件分页查询数据
    public List<ProducePlane> queryByParams(ProducePlanQuery query);


    public Integer updateBatch(Integer[] iids);
}