package com.yjxxt.crm.query;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.yjxxt.crm.base.BaseQuery;


public class SupplierQuery extends BaseQuery{
    //继承了basequery就可以进行分页
    private String name;//零件名称
    private String ljno;//零件编号
    private String level;//供应商重要程度

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLjno() {
        return ljno;
    }

    public void setLjno(String ljno) {
        this.ljno = ljno;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String time;
}
