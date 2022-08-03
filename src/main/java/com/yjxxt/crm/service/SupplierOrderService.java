package com.yjxxt.crm.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yjxxt.crm.base.BaseService;
import com.yjxxt.crm.dao.SupplierOrderMapper;
import com.yjxxt.crm.query.SupplierOrderQuery;
import com.yjxxt.crm.vo.SupplierOrder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: wangkk
 * @Date: 2022/7/28 - 07 - 28 - 11:20
 * @Description: com.post.crm.service
 * @version: 1.0
 */
@Service
public class SupplierOrderService extends BaseService<SupplierOrder,Integer>{
    //注入mapper
        @Resource
        private SupplierOrderMapper supplierOrderMapper;


    public Map<String, Object> queryOrderByParams(SupplierOrderQuery supplierOrderQuery) {
        Map<String,Object> map = new HashMap<>();
        //开启分页
        PageHelper.startPage(supplierOrderQuery.getPage(),supplierOrderQuery.getLimit());
        //得到对应的分页对象
        PageInfo<SupplierOrder> pageInfo = new PageInfo<>(supplierOrderMapper.selectByParams(supplierOrderQuery));
        //设置map对象
        map.put("code",0);
        map.put("msg","Success");
        map.put("count",pageInfo.getTotal());
        //设置分页好的列表
        map.put("data",pageInfo.getList());
        return map;


    }
}
