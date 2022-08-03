package com.yjxxt.crm.controller;

import com.yjxxt.crm.base.BaseController;
import com.yjxxt.crm.query.CustomerServeQuery;
import com.yjxxt.crm.service.CustomerServeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("sale")
public class SaleController extends BaseController {
    @Resource
    private CustomerServeService customerServeService;
    /**
     * 打开出售的页面
     * @return
     */
    @RequestMapping("index")
    public String index(){
        return "customerServe/sale";
    }


    @GetMapping("list")
    @ResponseBody
    public Map<String, Object> queryByParams(CustomerServeQuery customerServeQuery){

        return  customerServeService.queryByParams2(customerServeQuery);

    }
}
