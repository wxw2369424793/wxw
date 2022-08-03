package com.yjxxt.crm.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Cgr {
    private Integer id;

    private String name;

    private Integer price;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updataData;
    private Integer isValid;

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getUpdataData() {
        return updataData;
    }

    public void setUpdataData(Date updataData) {
        this.updataData = updataData;
    }
}