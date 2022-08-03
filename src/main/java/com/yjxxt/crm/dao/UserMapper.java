package com.yjxxt.crm.dao;

import com.yjxxt.crm.base.BaseMapper;
import com.yjxxt.crm.query.UserQuery;
import com.yjxxt.crm.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


public interface UserMapper extends BaseMapper <User,Integer>{


    User queryUserByUserName(String userName);
    public List<User> queryUserByParams(UserQuery userQuery);
    //批量删除
    public Integer deleteUsers(Integer[] ids);
    public List<Map<String,Object>> queryAllSales();
}
