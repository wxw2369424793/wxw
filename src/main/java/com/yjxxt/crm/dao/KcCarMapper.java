package com.yjxxt.crm.dao;

import com.yjxxt.crm.base.BaseMapper;
import com.yjxxt.crm.query.KcCarQuery;

import com.yjxxt.crm.vo.KcCar;


import java.util.List;

public interface KcCarMapper extends BaseMapper<KcCar,Integer> {
    //多条件分页查询数据
    public List<KcCar> queryByParams(KcCarQuery query);
    //批量删除
    public Integer deleteBatch(Integer[] ids);
}