package com.yjxxt.crm.controller;


import com.yjxxt.crm.base.BaseController;
import com.yjxxt.crm.base.ResultInfo;
import com.yjxxt.crm.query.ProducePlanQuery;
import com.yjxxt.crm.service.ProducePlaneService;
import com.yjxxt.crm.utils.AssertUtil;
import com.yjxxt.crm.utils.CookieUtil;
import com.yjxxt.crm.vo.ProducePlane;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("produce_plan")
public class ProducePlaneController extends BaseController {
    @Resource
    private ProducePlaneService producePlaneService;

    /**
     * 多条件分页查询数据
     * @param producePlanQuery
     * @return
     */
    @GetMapping("list")
    @ResponseBody
    public Map<String, Object> queryByParams(ProducePlanQuery producePlanQuery){
        return producePlaneService.queryByParams(producePlanQuery);
    }

    //打开营销机会管理页面
    @RequestMapping("index")
    public String index(){
        return "producePlan/produce_plan";
    }

    /**
     * 打开营销机会修改/添加的页面
     * @return
     */
    @RequestMapping("toAddUpdatePage")
    public String toAddUpdatePage(Integer id, HttpServletRequest request){
        //如果是修改操作那么需要将修改的数据映射在页面中
        if(id != null){
            ProducePlane producePlane = producePlaneService.selectByPrimaryKey(id);
            AssertUtil.isTrue(producePlane == null,"数据异常，请重试");
            request.setAttribute("producePlane",producePlane);
        }
        return "producePlan/add_update";
    }

    //添加数据
    @PostMapping("save")
    @ResponseBody
    public ResultInfo save(ProducePlane producePlane, HttpServletRequest request){
        String userName= CookieUtil.getCookieValue(request,"userName");
        producePlane.setCreateMan(userName);
        producePlaneService.addProucePlan(producePlane);
        return success();
    }



    //修改数据
    @PostMapping("update")
    @ResponseBody
    public ResultInfo update(ProducePlane producePlane){
        producePlaneService.updateProucePlan(producePlane);
        return success();
    }


    //批量删除
    @PostMapping("deleteBatch")
    @ResponseBody
    public ResultInfo deleteSaleChance(Integer[] ids){
        producePlaneService.deleteProducePlan(ids);
        return success();
    }


    //更新状态
    @PostMapping("updateProState")
    @ResponseBody
    public ResultInfo updateProState(Integer[] iids){
        producePlaneService.updateProState(iids);
        return success();
    }
}
