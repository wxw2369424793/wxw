package com.yjxxt.crm.dao;

import com.yjxxt.crm.base.BaseMapper;
import com.yjxxt.crm.vo.UserRole;
import org.apache.ibatis.annotations.Mapper;


public interface UserRoleMapper extends BaseMapper<UserRole,Integer> {
    //获取某个用户对应的角色数量
    Integer countUserRole(Integer id);

    //删除某个用户下所有角色
    Integer deleteUserRoleByUid(Integer id);
}
