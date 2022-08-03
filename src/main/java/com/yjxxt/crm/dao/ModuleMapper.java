package com.yjxxt.crm.dao;

import com.yjxxt.crm.base.BaseMapper;
import com.yjxxt.crm.model.TreeModel;
import com.yjxxt.crm.vo.Module;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface ModuleMapper extends BaseMapper<Module,Integer> {
    //查询所有的模块资源封装 (TreeModel)
    public List<TreeModel> queryAllModules();

    //查询所有的模块资源
    public List<Module> queryAllModule();


    //同级下名称唯一
    Module queryModulByGradeAName(@Param("grade") Integer grade, @Param("moduleName") String moduleName);

    Module queryModulByGradeAUrl(@Param("grade") Integer grade, @Param("url") String url);

    Module queryModulById(Integer parentId);

    Module queryModulByOptValue(String optValue);

    //查询某个模块下是否存在子模块
    Integer queryCountModuleByParentId(Integer mId);

    //根据模块id 删除对应模块
    Integer deleteModuleByMid(Integer mId);
}
