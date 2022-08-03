package com.yjxxt.crm.query;

import com.yjxxt.crm.base.BaseQuery;


/**
 * 分页查询条件封装 
 */
public class ProducePlanQuery extends BaseQuery {


    private String carType;    //汽车品牌
    private String createMan;       //创建人
    private Integer state;          //生产状态


    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCreateMan() {
        return createMan;
    }

    public void setCreateMan(String createMan) {
        this.createMan = createMan;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }


    @Override
    public String toString() {
        return "ProducePlanQuery{" +
                "carType='" + carType + '\'' +
                ", createMan='" + createMan + '\'' +
                ", state=" + state +
                '}';
    }
}
