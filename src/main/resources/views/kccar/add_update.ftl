<!DOCTYPE html>
<html>
<head>
    <#include "../common.ftl">
</head>
<body class="childrenBody">
<form class="layui-form" style="width:80%;">
    <input type="hidden" name="id" id="hidId" value="${(kcCar.id)!}">

    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">汽车名字</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input" lay-verify="required"
                   name="name" id="name"  value="${(kcCar.name)!}" placeholder="请输入汽车名字">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">数量</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input"  name="number"
                   id="number" value="${(kcCar.number)!}" placeholder="请输入数量">
        </div>
    </div>
    <br/>
    <div class="layui-form-item layui-row layui-col-xs12">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-lg" lay-submit="" lay-filter="addOrUpdateKcCar">
                确认
            </button>
            <button class="layui-btn layui-btn-lg layui-btn-normal" id="closeBtn">取消</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${ctx}/js/kccar/add.update.js"></script>
</body>
</html>