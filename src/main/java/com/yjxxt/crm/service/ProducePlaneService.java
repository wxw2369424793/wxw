package com.yjxxt.crm.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yjxxt.crm.base.BaseService;
import com.yjxxt.crm.dao.ProducePlaneMapper;
import com.yjxxt.crm.query.ProducePlanQuery;
import com.yjxxt.crm.utils.AssertUtil;
import com.yjxxt.crm.vo.ProducePlane;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProducePlaneService extends BaseService<ProducePlane,Integer> {
    @Resource
    private ProducePlaneMapper producePlaneMapper;

    //多条件查询数据
    public Map<String, Object> queryByParams(ProducePlanQuery query) {
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(query.getPage(),query.getLimit());
        PageInfo<ProducePlane> pageInfo =new PageInfo<>(producePlaneMapper.queryByParams(query));
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;
    }


    //插入一条数据
    public void addProucePlan(ProducePlane producePlane) {
        checkParams(producePlane.getCarType());
        producePlane.setIsValid(1);
        producePlane.setState(1);
        producePlane.setUpdateDate(new Date());
        producePlane.setCreateDate(new Date());

        AssertUtil.isTrue(producePlaneMapper.insertSelective(producePlane) <1,"数据添加失败");
    }
    //更新数据
    public void updateProucePlan(ProducePlane producePlane){
        //判断id是否存在
        AssertUtil.isTrue(producePlane.getId() == null,"数据异常，请重试");
        //校验非空参数
        checkParams(producePlane.getCarType());
        //设置默认值
        producePlane.setUpdateDate(new Date());

        AssertUtil.isTrue(producePlaneMapper.updateByPrimaryKeySelective(producePlane)<1,"生产计划修改失败");
    }

    //删除数据
    public void deleteProducePlan(Integer[] ids){
        AssertUtil.isTrue(ids==null||ids.length==0,"请选择要删除的记录");
        AssertUtil.isTrue(producePlaneMapper.deleteBatch(ids)!=ids.length,"生产计划数据删除失败");
    }


    //更新生产状态

    public void updateProState(Integer[] iids){
        AssertUtil.isTrue(iids==null||iids.length==0,"请选择要更新状态的记录");
        AssertUtil.isTrue(producePlaneMapper.updateBatch(iids)!=iids.length,"生产计划数据更新失败");
    }

    //校验
    private void checkParams(String carType) {
        AssertUtil.isTrue(StringUtils.isBlank(carType),"汽车品牌不能为空");
    }

}
