<!--
   客户贡献分析页面
-->
<!DOCTYPE html>
<html>
<head>
    <title>客户贡献报表</title>
    <#include "../common.ftl">
</head>
<body class="childrenBody">

<form class="layui-form" >
    <blockquote class="layui-elem-quote quoteBox">
        <form class="layui-form">
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="text" name="name"
                           class="layui-input
					searchVal" placeholder="汽车名" />
                </div>
                <#--                <div class="layui-input-inline">-->
                <#--                    <input type="text" name="time" id="time"-->
                <#--                           class="layui-input-->
                <#--					searchVal" placeholder="下单时间"  readonly="readonly" />-->
                <#--                </div>-->
                <a class="layui-btn search_btn" id="btnSearch" data-type="reload" >
                    <i class="layui-icon">&#xe615;</i> 搜索</a>
            </div>
        </form>
    </blockquote>
    <!-- 数据表格 -->
    <table id="kcCarList" class="layui-table"  lay-filter="kcCars">
    </table>

    <#--头部工具栏-->
    <script type="text/html" id="toolbarDemo">
        <div class="layui-btn-container">
            <#--            <a class="layui-btn layui-btn-normal addNews_btn" lay-event="add">-->
            <#--                <i class="layui-icon">&#xe608;</i>添加-->
            <#--            </a>-->
            <a class="layui-btn layui-btn-normal delNews_btn" lay-event="del">
                <i class="layui-icon">&#xe608;</i>删除
            </a>
        </div>
    </script>


    <!--操作 行工具栏-->
    <script id="kcCarListBar" type="text/html">
        <a class="layui-btn layui-btn-xs" id="edit" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
    </script> <table id="contriList" class="layui-table"  lay-filter="contris"></table>


</form>
<script type="text/javascript" src="${ctx}/js/kccar/kc.car.js"></script>

</body>
</html>