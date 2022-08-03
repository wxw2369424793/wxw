package com.yjxxt.crm.controller;

import com.yjxxt.crm.base.BaseController;
import com.yjxxt.crm.base.ResultInfo;
import com.yjxxt.crm.query.SupplierQuery;
import com.yjxxt.crm.service.SupplierService;
import com.yjxxt.crm.vo.Supplier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
@RequestMapping("supplier")
public class SupplierController extends BaseController{
    //注入service层
    @Resource
    private SupplierService supplierService;

    /**
     * //分页条件查询零件
     * @param supplierQuery
     * @return
     */

    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> querySupplierByParams(SupplierQuery supplierQuery){
        return supplierService.querySupplierByParams(supplierQuery);
    }
    //中转方法——查询零件
    @RequestMapping("index")
    public String index(){
        return "supplier/supplier";
    }
    //添加零件信息
    @PostMapping("add")
    @ResponseBody
    public ResultInfo addSupplier(Supplier supplier){
        supplierService.addSupplier(supplier);
        return success("添加零件成功");
    }
    //中转方法——添加页面的加载
    @RequestMapping("toAddSupplier")
    public String toAddSupplier(Integer id, HttpServletRequest request){
        if (id != null) {
            Supplier supplier = supplierService.selectByPrimaryKey(id);
            request.setAttribute("supplier", supplier);
        }
        return "supplier/add_update";
    }

    //更新操作
    @PostMapping("update")
    @ResponseBody
    public ResultInfo updateSupplier(Supplier supplier){
        supplierService.updateSupplier(supplier);
        return success("修改零件信息成功");
    }

    //打开修改信息对话框
    @RequestMapping("toUpdateSupplier")
    public String toUpdateSupplier(Integer id, HttpServletRequest request){
        if(id!=null){
            //通过id查询客户
            Supplier supplier = supplierService.selectByPrimaryKey(id);
            //将客户记录存到作用域中
            request.setAttribute("supplier",supplier);
        }
        return "supplier/add_update";
    }
    //删除信息
    @PostMapping("delete")
    @ResponseBody
    public ResultInfo deleteSupplier(Integer id){
        supplierService.deleteSupplier(id);
        return success("删除零件信息成功");
    }

    //打开查看订单 中转方法 返回视图
    @RequestMapping("toOrderPage")
    public String toOrderPage(Integer id, Model model){
        //通过id查询 供应商信息，设置到请求域中
        model.addAttribute("supplier",supplierService.selectByPrimaryKey(id));
        return "supplier/supplier_order";
    }

    //添加库存
    @PostMapping("buySupplier")
    @ResponseBody
    public ResultInfo buySupplier(Supplier supplier){
        System.out.println(supplier);
        supplierService.buySupplier(supplier);
        return success("购买零件成功");
    }

    //打开购买零件对话框   中转方法
    @RequestMapping("buySuppliers")
    public String buySuppliers(Integer id, HttpServletRequest request){
        if(id!=null){
            //通过id查询客户
            Supplier supplier = supplierService.selectByPrimaryKey(id);
            //将客户记录存到作用域中
            request.setAttribute("supplier",supplier);
        }
        return "supplier/supplier_buy";
    }
}
