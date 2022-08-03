package com.yjxxt.crm.controller;

import com.yjxxt.crm.base.BaseController;
import com.yjxxt.crm.base.ResultInfo;
import com.yjxxt.crm.query.KcCarQuery;

import com.yjxxt.crm.service.KcCarService;
import com.yjxxt.crm.utils.AssertUtil;
import com.yjxxt.crm.utils.LoginUserUtil;
import com.yjxxt.crm.vo.KcCar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("kc_car")
public class KcCarController extends BaseController {
    @Resource
    private KcCarService kcCarService;

    /**
     * 多条件分页查询
     * @param kcCarQuery
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> queryByParams(KcCarQuery kcCarQuery){
        return kcCarService.queryByParams(kcCarQuery);
    }

    /**
     * 进入库存管理页面
     * @return
     */
    @RequestMapping("index")
    public String index(){
        return "kccar/kccar";
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("deleteBatch")
    @ResponseBody
    public ResultInfo deleteBatchs(Integer[] ids){
        kcCarService.deleteBatchs(ids);
        return success("删除成功");
    }

    /**
     * 打开库存修改
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("toAddUpdatePage")
    public String toAddUpdatePage(Integer id, HttpServletRequest request){
        KcCar kcCar = kcCarService.selectByPrimaryKey(id);
        AssertUtil.isTrue(kcCar == null,"数据异常，请重试");
        request.setAttribute("kcCar",kcCar);
        return "kccar/add_update";
    }

    /**
     * 修改数据
     * @param kcCar
     * @return
     */
    @PostMapping("update")
    @ResponseBody
    public ResultInfo update(KcCar kcCar){
        kcCarService.updateKcCar(kcCar);
        return success();
    }
}
