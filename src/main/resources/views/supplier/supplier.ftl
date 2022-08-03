<!DOCTYPE html>
<html>
<head>
	<title>采购管理</title>
	<#include "../common.ftl">
</head>
<body class="childrenBody">

<form class="layui-form" >
	<blockquote class="layui-elem-quote quoteBox">
		<form class="layui-form">
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input name="id" type="hidden" value="${(supplier.id)!}"/>
				</div>
				<div class="layui-input-inline">
					<input type="text" name="name"
						   class="layui-input
					searchVal" placeholder="零件名称" />
				</div>
				<div class="layui-input-inline">
					<input type="text" name="ljno" class="layui-input
					searchVal" placeholder="零件编号" />
				</div>
				<div class="layui-input-inline">
                    <select name="level"  id="level">
						<option value="">请选择...</option>
						<option value="战略合作伙伴">战略合作伙伴</option>
						<option value="大客户">大客户</option>
						<option value="重点开发客户">重点开发客户</option>
                    </select>
				</div>
				<a class="layui-btn search_btn" data-type="reload"><i
							class="layui-icon">&#xe615;</i> 搜索</a>
			</div>
		</form>
	</blockquote>
	<!--头部工具栏-->
	<table id="supplierList" class="layui-table"  lay-filter="suppliers"></table>


	<script type="text/html" id="toolbarDemo">
		<div class="layui-btn-container">
			<a class="layui-btn layui-btn-normal addNews_btn" lay-event="add">
				<i class="layui-icon">&#xe608;</i>
				添加
			</a>
			<a class="layui-btn layui-btn-normal addNews_btn" lay-event="purchase">
				<i class="layui-icon">&#xe608;</i>
				采购零件
			</a>
			<a class="layui-btn layui-btn-normal addNews_btn" lay-event="order">
				<i class="layui-icon">&#xe608;</i>
				订单查看
			</a>
		</div>
	</script>
	<!--操作-->
	<script id="supplierListBar" type="text/html">
		<a class="layui-btn layui-btn-xs" id="edit" lay-event="edit">编辑</a>
		<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
	</script>


</form>
<script type="text/javascript" src="${ctx}/js/supplier/supplier.js"></script>

</body>
</html>