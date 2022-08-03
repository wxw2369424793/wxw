package com.yjxxt.crm.controller;

import com.yjxxt.crm.base.BaseController;
import com.yjxxt.crm.base.ResultInfo;
import com.yjxxt.crm.query.CustomerServeQuery;
import com.yjxxt.crm.service.CustomerServeService;
import com.yjxxt.crm.utils.AssertUtil;
import com.yjxxt.crm.vo.Cgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller

@RequestMapping("customer_serve")
public class CustomerServeController extends BaseController {
    @Resource

    private CustomerServeService customerServeService;
    /**
     * 打开销售管理页面
     * @return
     */
    @RequestMapping("index")
    public String index(){
        return  "customerServe/customer_serve";
    }

    @GetMapping("list")
    @ResponseBody
    public Map<String, Object> queryByParams(CustomerServeQuery customerServeQuery){

        return  customerServeService.queryByParams(customerServeQuery);

    }

    /**
     * 打开编辑界面
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("toAddUpdatePage")
    public String toAddUpdatePage(Integer id, HttpServletRequest request){
        Cgr cgr = customerServeService.selectByPrimaryKey(id);
        AssertUtil.isTrue(cgr==null,"数据异常，请重试");
        request.setAttribute("cgr",cgr);
        return "customerServe/add_update";
    }
    /**
     * 添加数据
     * @return
     */
    @RequestMapping ("update")
    @ResponseBody
    public ResultInfo update(Cgr cgr){
        customerServeService.updateCustomerServe(cgr);
        return success();
    }
    @RequestMapping("deleteBatch")
    @ResponseBody
    public ResultInfo deleteBatchs(Integer[] ids){
        customerServeService.deleteBatchs(ids);
        return success("删除成功");
    }

}
