package com.yjxxt.crm.controller;

import com.yjxxt.crm.base.BaseController;
import com.yjxxt.crm.base.ResultInfo;
import com.yjxxt.crm.model.TreeModel;
import com.yjxxt.crm.service.ModuleService;
import com.yjxxt.crm.vo.Module;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("module")
public class ModuleController extends BaseController {
    @Resource
    private ModuleService moduleService;

    /**
     * 树形
     * @param rId
     * @return
     */
    @RequestMapping ("queryAllModules")
    @ResponseBody
    public List<TreeModel> queryAllModules(Integer rId){
        return moduleService.queryAllModules(rId);
    }


    /**
     * 查询所有
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> queryModuleList(){
        return moduleService.queryAllModule();
    }

    /**
     * 页面跳转
     * @return
     */

    @RequestMapping("index")
    public String toIndex(){
        return "module/module";
    }
    /**
     * 跳转到添加页面
     *
     */

    @RequestMapping("toAdd")
    public String toAdd(Integer grade, Integer parentId, HttpServletRequest request){
        request.setAttribute("grade",grade);
        request.setAttribute("parentId",parentId);
        return "module/add";
    }

    /**
     * 跳转更新页面

     * @param request
     * @return
     */
    @RequestMapping("updateModulePage")
    public String updateModulePage(Integer id,HttpServletRequest request){
        Module module = moduleService.selectByPrimaryKey(id);
        request.setAttribute("module",module);
        return "module/update";

    }


    /**
     * 添加
     */
    @RequestMapping("add")
    @ResponseBody
    public ResultInfo moduleAdd(Module module){
        moduleService.moduleAdd(module);
        return success("资源添加成功");
    }

    /**
     * 修改
     * @param module
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public ResultInfo moduleUpdate(Module module){
        moduleService.moduleUpdate(module);
        return success("资源修改成功");
    }

    /**
     * 删除
     * @param mId
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public ResultInfo moduledelete(Integer mId){
        moduleService.moduledelete(mId);
        return success("资源删除成功");
    }







}
