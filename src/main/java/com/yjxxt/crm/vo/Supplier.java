package com.yjxxt.crm.vo;

import java.util.Date;

public class Supplier {
    private Integer id;//主键ID

    private String ljno;//零件编号

    private String name;//零件名称

    private String area;//

    private String manager;//

    private String level;//

    private String myd;//

    private String xyd;//

    private String address;//

    private String money;//单价

    private String phone;//

    private String fax;//

    private String webSite;//

    private String yyzzzch;//

    private String fr;//

    private String zczj;//

    private String nyye;//

    private String khyh;//

    private String kucun;//

    private Integer state;//

    private Integer isValid;

    private Date createDate;

    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLjno() {
        return ljno;
    }

    public void setLjno(String ljno) {
        this.ljno = ljno == null ? null : ljno.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getMyd() {
        return myd;
    }

    public void setMyd(String myd) {
        this.myd = myd == null ? null : myd.trim();
    }

    public String getXyd() {
        return xyd;
    }

    public void setXyd(String xyd) {
        this.xyd = xyd == null ? null : xyd.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money == null ? null : money.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite == null ? null : webSite.trim();
    }

    public String getYyzzzch() {
        return yyzzzch;
    }

    public void setYyzzzch(String yyzzzch) {
        this.yyzzzch = yyzzzch == null ? null : yyzzzch.trim();
    }

    public String getFr() {
        return fr;
    }

    public void setFr(String fr) {
        this.fr = fr == null ? null : fr.trim();
    }

    public String getZczj() {
        return zczj;
    }

    public void setZczj(String zczj) {
        this.zczj = zczj == null ? null : zczj.trim();
    }

    public String getNyye() {
        return nyye;
    }

    public void setNyye(String nyye) {
        this.nyye = nyye == null ? null : nyye.trim();
    }

    public String getKhyh() {
        return khyh;
    }

    public void setKhyh(String khyh) {
        this.khyh = khyh == null ? null : khyh.trim();
    }

    public String getKucun() {
        return kucun;
    }

    public void setKucun(String kucun) {
        this.kucun = kucun == null ? null : kucun.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}