<!DOCTYPE html>
<html>
<head>
    <#include "../common.ftl">
</head>
<body class="childrenBody">
<form class="layui-form" style="width:80%;">
    <input type="hidden" name="id" id="hidId" value="${(producePlane.id)!}">
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">汽车品牌</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input" lay-verify="required"
                   name="carType" id="carType"  value="${(producePlane.carType)!}" placeholder="请输入汽车品牌">
        </div>
    </div>

    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">概要</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input"
                   name="overview" value="${(producePlane.overview)!}"  placeholder="请输入概要">
        </div>
    </div>

    <br/>
    <div class="layui-form-item layui-row layui-col-xs12">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-lg" lay-submit="" lay-filter="addOrUpdateSaleChance">
                确认
            </button>
            <button class="layui-btn layui-btn-lg layui-btn-normal" id="closeBtn">取消</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${ctx}/js/producePlan/add.update.js"></script>
</body>
</html>