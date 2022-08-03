package com.yjxxt.crm.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yjxxt.crm.base.BaseService;
import com.yjxxt.crm.dao.SupplierMapper;
import com.yjxxt.crm.query.SupplierQuery;
import com.yjxxt.crm.utils.AssertUtil;
import com.yjxxt.crm.utils.PhoneUtil;
import com.yjxxt.crm.vo.Supplier;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class SupplierService extends BaseService<Supplier,Integer>{
        //注入dao层 mapper
    @Resource
    private SupplierMapper supplierMapper;

    //分页条件查询零件
    public Map<String,Object> querySupplierByParams(SupplierQuery supplierQuery){
        Map<String,Object> map = new HashMap<>();
        //开启分页
        PageHelper.startPage(supplierQuery.getPage(),supplierQuery.getLimit());
        //得到对应的分页对象
        PageInfo<Supplier> pageInfo = new PageInfo<>(supplierMapper.selectByParams(supplierQuery));
        //设置map对象
        map.put("code",0);
        map.put("msg","LoginSuccess");
        map.put("count",pageInfo.getTotal());
        //设置分页好的列表
        map.put("data",pageInfo.getList());
        return map;
    }

    //添加零件
    /*@Transient(Propagation =Propagation.REQUIRED)*/
    public void addSupplier(Supplier supplier){
        //参数校验
        checkSupplierParams(supplier.getName(),supplier.getPhone(),supplier.getMoney());
        //设置默认值
        supplier.setIsValid(1);
        supplier.setCreateDate(new Date());
        supplier.setUpdateDate(new Date());
        //执行添加操作，判断受影响行数
        AssertUtil.isTrue(supplierMapper.insertSelective(supplier)<1,"添加失败，请重试");

    }
    //非空检验 合法性校验
    private void checkSupplierParams(String name,String phone,String MONEY) {
        AssertUtil.isTrue(StringUtils.isBlank(name),"零件名不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(phone),"手机号不能为空");
        AssertUtil.isTrue(!PhoneUtil.isMobile(phone),"手机号格式不正确");
        AssertUtil.isTrue(StringUtils.isBlank(MONEY),"单价不能为空");
    }


    //更新操作
    public void updateSupplier(Supplier supplier){
        //参数校验
        AssertUtil.isTrue(supplier.getId()==null,"待更新数据不存在");
        //通过id查询供应商
        Supplier temp = supplierMapper.selectByPrimaryKey(supplier.getId());
        AssertUtil.isTrue(temp.getId()==null,"待更新供应商不存在");
        //参数校验  修改后的名称 电话 单价不能为空
        checkSupplierParams(supplier.getName(),supplier.getPhone(),supplier.getMoney());
        //设置默认值
        supplier.setUpdateDate(new Date());
        //执行修改操作，判断受影响行数
        AssertUtil.isTrue(supplierMapper.updateByPrimaryKeySelective(supplier)<1,"修改信息失败，请重试");
    }

    public void deleteSupplier(Integer id){
        //参数校验
        AssertUtil.isTrue(id==null,"待删除数据不存在");
        //通过id查询供应商
        Supplier temp = supplierMapper.selectByPrimaryKey(id);
        AssertUtil.isTrue(temp.getId()==null,"待删除供应商不存在");
        //设置默认值
        temp.setIsValid(0);
        temp.setUpdateDate(new Date());
        //执行删除操作，判断受影响行数
        AssertUtil.isTrue(supplierMapper.updateByPrimaryKeySelective(temp)<1,"修改信息失败，请重试");
    }
    //购买零件
    public void buySupplier(Supplier supplier) {
        //参数校验 购买的零件数量不能为空
        checkBuyParams(supplier.getKucun());
        //设置默认值
        supplier.setUpdateDate(new Date());
        //执行修改操作，判断受影响行数
        AssertUtil.isTrue(supplierMapper.updateKucun(supplier)<1,"购买失败，请重试");
    }
    //检验零件数量非空方法
    private void checkBuyParams(String kucun) {
        AssertUtil.isTrue(StringUtils.isBlank(kucun),"购买的数量不能为空");
    }

}
