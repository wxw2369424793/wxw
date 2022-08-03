package com.yjxxt.crm.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yjxxt.crm.base.BaseService;
import com.yjxxt.crm.dao.CustomerServeMapper;
import com.yjxxt.crm.query.CustomerServeQuery;
import com.yjxxt.crm.utils.AssertUtil;
import com.yjxxt.crm.vo.Cgr;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServeService extends BaseService<Cgr,Integer> {
    @Resource
    private CustomerServeMapper customerServeMapper;

    public Map<String, Object> queryByParams(CustomerServeQuery customerServeQuery){
        Map<String, Object> map = new HashMap<>();
        //开启分页
        PageHelper.startPage(customerServeQuery.getPage(),customerServeQuery.getLimit());
        List<Cgr> cgrs = customerServeMapper.queryByParams(customerServeQuery);
        //按照分页条件，格式化数据
        PageInfo<Cgr> cgrPageInfo = new PageInfo<>(cgrs);

        map.put("code",0);
        map.put("msg","");
        map.put("count",cgrPageInfo.getTotal());
        map.put("data",cgrPageInfo.getList());
        return map;
    }

    /**
     * 修改数据
     * @param cgr
     */
    public void updateCustomerServe(Cgr cgr){
        //判断id是否存在
        AssertUtil.isTrue(cgr.getId()==null,"数据异常请重试");
        //校验非空参数
        AssertUtil.isTrue(cgr.getName()==null,"名字不能为空");
        AssertUtil.isTrue(cgr.getPrice()==null,"价格不能为空");
        //设置默认值
        cgr.setUpdataData(new Date());


        //执行修改操作
        AssertUtil.isTrue(customerServeMapper.updateByPrimaryKeySelective(cgr)<1,"营销数据修改失败");
    }
    public void deleteBatchs(Integer[] ids){
        AssertUtil.isTrue(ids==null || ids.length<1,"未选中删除数据");
        customerServeMapper.deleteBatch(ids);
    }

    public Map<String, Object> queryByParams2(CustomerServeQuery customerServeQuery) {
        Map<String, Object> map = new HashMap<>();
        //开启分页
        PageHelper.startPage(customerServeQuery.getPage(),customerServeQuery.getLimit());
        List<Cgr> cgrs = customerServeMapper.queryByParams2(customerServeQuery);
        //按照分页条件，格式化数据
        PageInfo<Cgr> cgrPageInfo = new PageInfo<>(cgrs);

        map.put("code",0);
        map.put("msg","");
        map.put("count",cgrPageInfo.getTotal());
        map.put("data",cgrPageInfo.getList());
        return map;
    }
}
