package com.yjxxt.crm.dao;

import com.yjxxt.crm.base.BaseMapper;
import com.yjxxt.crm.vo.Supplier;

public interface SupplierMapper extends BaseMapper<Supplier,Integer> {

    Integer updateKucun (Supplier supplier);
}