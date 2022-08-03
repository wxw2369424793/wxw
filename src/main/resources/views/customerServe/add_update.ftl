<!DOCTYPE html>
<html>
<head>
    <#include "../common.ftl">
</head>
<body class="childrenBody">
<form class="layui-form" style="width:80%;">
    <input type="hidden" name="id" id="hidId" value="${(cgr.id)!}">
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">名字</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input"  name="name"
                   id="chanceSource" value="${(cgr.name)!}" placeholder="请输入名字">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">价格</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input" name="price" value="${(cgr.price)!}"
                   placeholder="请输入价格">
        </div>
    </div>

    <div class="layui-form-item layui-row layui-col-xs12">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-lg" lay-submit="" lay-filter="addOrUpdateCustomerServe">
                确认
            </button>
            <button class="layui-btn layui-btn-lg layui-btn-normal" id="closeBtn">取消</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${ctx}/js/customerServe/add.update.js"></script>
</body>
</html>