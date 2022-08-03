package com.yjxxt.crm.service;

import com.yjxxt.crm.base.BaseService;
import com.yjxxt.crm.dao.PermissionMapper;
import com.yjxxt.crm.vo.Permission;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PermissionService extends BaseService<Permission,Integer> {
    @Resource
    private PermissionMapper permissionMapper;

    public List<Integer> selectAclvalueByUserId(int id) {
        return permissionMapper.selectAclvalueByUserId(id);
    }
}
