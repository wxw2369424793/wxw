package com.yjxxt.crm.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yjxxt.crm.base.BaseService;
import com.yjxxt.crm.dao.KcCarMapper;
import com.yjxxt.crm.query.KcCarQuery;
import com.yjxxt.crm.utils.AssertUtil;
import com.yjxxt.crm.utils.PhoneUtil;
import com.yjxxt.crm.vo.KcCar;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KcCarService extends BaseService<KcCar,Integer> {
    @Resource
    private KcCarMapper kcCarMapper;

    /**
     * 分页查询
     * @param kcCarQuery
     * @return
     */
    public Map<String, Object> queryByParams(KcCarQuery kcCarQuery){
        Map<String, Object> map = new HashMap<>();
        //开启分页
        PageHelper.startPage(kcCarQuery.getPage(),kcCarQuery.getLimit());
        List<KcCar> kcCars = kcCarMapper.queryByParams(kcCarQuery);
        //按照分页条件，格式化数据
        PageInfo<KcCar> kcCarPageInfo = new PageInfo<>(kcCars);

        map.put("code",0);
        map.put("msg","");
        map.put("count",kcCarPageInfo.getTotal());
        map.put("data",kcCarPageInfo.getList());
        return map;
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteBatchs(Integer[] ids){
        AssertUtil.isTrue(ids == null || ids.length < 1,"未选中删除数据");
        kcCarMapper.deleteBatch(ids);
    }

    /**
     * 修改数据
     * @param kcCar
     */
    public void updateKcCar(KcCar kcCar){
        //判断id是否存在
        AssertUtil.isTrue(kcCar.getId() == null,"数据异常，请重试");
        //校验非空参数
        AssertUtil.isTrue(kcCar.getName()==null,"汽车名字不能为空");
        AssertUtil.isTrue(kcCar.getNumber()==null,"汽车数量不能为空");
        //设置默认值
        kcCar.setUpdateDate(new Date());
        //通过现有的id查询修改之前的数据
        KcCar kcCar1 = kcCarMapper.selectByPrimaryKey(kcCar.getId());
        AssertUtil.isTrue(kcCar1 == null,"数据异常，请重试");
        //执行修改操作
        AssertUtil.isTrue(kcCarMapper.updateByPrimaryKeySelective(kcCar) < 1,"库存数据修改失败");
    }
}
