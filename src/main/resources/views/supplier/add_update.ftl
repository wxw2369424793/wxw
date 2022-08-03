<!DOCTYPE html>
<html>
<head>
    <#include "../common.ftl">
</head>
<body class="childrenBody">
<form class="layui-form" style="width:80%;">
    <input name="id" type="hidden" value="${(supplier.id)!}"/>


    <div class="layui-form-item layui-row">
        <input name="id" type="hidden" value="${(supplier.id)!}"/>
        <div class="layui-col-xs6">
            <label class="layui-form-label">零件名称</label>
            <div class="layui-input-block">
                <input type="text" class="layui-input"
                       name="name" id="name"  lay-verify="required" value="${(supplier.name)!}" placeholder="请输入客户名">
            </div>
        </div>
        <div class="layui-col-xs6">
            <label class="layui-form-label">法人</label>
            <div class="layui-input-block">
                <input type="text" class="layui-input"
                       name="fr" id="fr"  value="${(supplier.fr)!}" placeholder="请输入法人">
            </div>
        </div>
    </div>

    <div class="layui-form-item layui-row">
        <div class="layui-col-xs6">
            <label class="layui-form-label">区域</label>
            <div class="layui-input-block">
                <input type="text" class="layui-input"
                       name="area"    value="${(supplier.area)!}" placeholder="请输入区域">
            </div>
        </div>
        <div class="layui-col-xs6">
            <label class="layui-form-label">销售经理</label>
            <div class="layui-input-block">
                <input type="text" class="layui-input"
                       name="Manager"  lay-verify="required" value="${(supplier.manager)!}" placeholder="请输入联系经理">
            </div>
        </div>
    </div>
    <div class="layui-form-item layui-row">
        <div class="layui-col-xs6">
            <label class="layui-form-label">零件编号</label>
            <div class="layui-input-block">
                <input type="text" class="layui-input"
                       name="ljno"    value="${(supplier.ljno)!}" placeholder="请输入零件编号">
            </div>
        </div>
        <div class="layui-col-xs6">
            <label class="layui-form-label">满意度</label>
            <div class="layui-input-block">
                <input type="text" class="layui-input"
                       name="myd"  lay-verify="required" value="${(supplier.myd)!}" placeholder="请输入联系经理">
            </div>
        </div>
    </div>

    <div class="layui-form-item layui-row">
        <div class="layui-col-xs6">
            <label class="layui-form-label">供应商级别</label>
            <div class="layui-input-block">
                <select name="level"  id="level">
                    <option value="" >请选择</option>
                    <option value="普通客户">普通客户</option>
                    <option value="重点开发客户" >重点开发客户</option>
                    <option value="大客户" >大客户</option>
                    <option value="合作伙伴" >合作伙伴</option>
                </select>
            </div>
        </div>
        <div class="layui-col-xs6">
            <label class="layui-form-label">信用度</label>
            <div class="layui-input-block">
                <input type="text" class="layui-input"
                       name="xyd" value="${(supplier.xyd)!}"  placeholder="请输入供应商信用级别">
            </div>
        </div>
    </div>


    <div class="layui-form-item layui-row">
        <div class="layui-col-xs6">
            <label class="layui-form-label">单价</label>
            <div class="layui-input-block">
                <input type="text" class="layui-input"
                       name="money" value="${(supplier.money)!}"  placeholder="请输入单价">
            </div>
        </div>
        <div class="layui-col-xs6">
            <label class="layui-form-label">联系电话</label>
            <div class="layui-input-block">
                <input type="text" class="layui-input"
                       name="phone" lay-verify="required" value="${(supplier.phone)!}"  placeholder="请输入联系电话">
            </div>
        </div>
    </div>

    <div class="layui-form-item layui-row">
        <div class="layui-col-xs6">
            <label class="layui-form-label">客户地址</label>
            <div class="layui-input-block">
                <input type="text" class="layui-input"
                       name="address" value="${(supplier.address)!}"  placeholder="请输入客户地址">
            </div>
        </div>
        <div class="layui-col-xs6">
            <label class="layui-form-label">传真</label>
            <div class="layui-input-block">
                <input type="text" class="layui-input"
                       name="fax" value="${(supplier.fax)!}"  placeholder="请输入传真">
            </div>
        </div>
    </div>

    <div class="layui-form-item layui-row">
        <div class="layui-col-xs6">
            <label class="layui-form-label">网站</label>
            <div class="layui-input-block">
                <input type="text" class="layui-input"
                       name="webSite" value="${(supplier.webSite)!}"  placeholder="请输入供应商网站地址">
            </div>
        </div>
        <div class="layui-col-xs6">
            <label class="layui-form-label">注册资金</label>
            <div class="layui-input-block">
                <input type="text" class="layui-input"
                       name="zczj" value="${(supplier.zczj)!}"  placeholder="请输入注册资金">
            </div>
        </div>
    </div>




    <div class="layui-form-item layui-row">
        <div class="layui-col-xs6">
            <label class="layui-form-label">开户行</label>
            <div class="layui-input-block">
                <input type="text" class="layui-input"
                       name="khyh" value="${(supplier.khyh)!}"  placeholder="请输入客户开户行">
            </div>
        </div>
        <div class="layui-col-xs6">
            <label class="layui-form-label">库存</label>
            <div class="layui-input-block">
                <input type="text" class="layui-input"
                       name="kucun" value="${(supplier.kucun)!}"  placeholder="请输入库存">
            </div>
        </div>
    </div>
    <div class="layui-col-xs6">
        <label class="layui-form-label">营业执照</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input"
                   name="yyzzzch" value="${(supplier.yyzzzch)!}"  placeholder="请输入营业执照">
        </div>
    </div>

    <br/>
    <div class="layui-form-item layui-row layui-col-xs12">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-lg" lay-submit=""
                    lay-filter="addSupplier">确认
            </button>
            <button class="layui-btn layui-btn-lg layui-btn-normal" id="closeBtn">取消</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${ctx}/js/supplier/add.update.js"></script>
</body>
</html>