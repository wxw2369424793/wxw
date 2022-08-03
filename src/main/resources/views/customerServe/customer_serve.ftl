<!DOCTYPE html>
<html>
<head>
    <title>营销机会管理</title>
    <#include "../common.ftl">
</head>
<body class="childrenBody">

<form class="layui-form" >
    <blockquote class="layui-elem-quote quoteBox">
        <form class="layui-form">
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="text" name="name" class="layui-input searchVal" placeholder="类型" />
                </div>
                <div class="layui-input-inline">
                    <input type="text" name="price" class="layui-input
							searchVal" placeholder="价格" />
                </div>

                <a class="layui-btn search_btn" id="btnSearch" data-type="reload">
                    <i class="layui-icon">&#xe615;</i> 搜索
                </a>
            </div>
        </form>
    </blockquote>

    <!-- 数据表格 -->
    <table id="CustomerServeList" class="layui-table"  lay-filter="CustomerServes">
    </table>
    <!--操作 行工具栏-->
    <script id="CustomerServeListBar" type="text/html">
        <a class="layui-btn layui-btn-xs" id="edit" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">出售</a>
    </script>

</form>

<script type="text/javascript" src="${ctx}/js/customerServe/customer.serve.js"></script>
</body>
</html>