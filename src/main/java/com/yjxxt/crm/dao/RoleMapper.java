package com.yjxxt.crm.dao;


import com.yjxxt.crm.base.BaseMapper;
import com.yjxxt.crm.vo.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

public interface RoleMapper extends BaseMapper<Role,Integer> {

    // <!--查询对应的角色名称和id反馈给前台使用-->
    public List<Map<String,Object>> queryAllRoles(Integer id);

    /*通过名称查询角色数据*/
    public Role queryRoleByRoleName(String roleName);
}
