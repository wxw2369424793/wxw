package com.yjxxt.crm.controller;

import com.yjxxt.crm.base.BaseController;
import com.yjxxt.crm.query.SupplierOrderQuery;
import com.yjxxt.crm.service.SupplierOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Auther: wangkk
 * @Date: 2022/7/28 - 07 - 28 - 11:22
 * @Description: com.post.crm.controller
 * @version: 1.0
 */
@Controller
@RequestMapping("order")
public class SupplierOrderController extends BaseController {
    //注入service
    @Resource
    private SupplierOrderService supplierOrderService;

    @RequestMapping("lists")
    @ResponseBody
    //分页多条件查询订单
    public Map<String,Object> queryOrderByParams(SupplierOrderQuery supplierOrderQuery){
        return supplierOrderService.queryOrderByParams(supplierOrderQuery);
    }
}
