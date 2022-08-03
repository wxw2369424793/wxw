<!DOCTYPE html>
<html>
<head>
	<title>零件购买</title>
	<#include "../common.ftl">
</head>
<body class="childrenBody">
<form class="layui-form" style="width:80%;">
	<input name="id" type="hidden" value="${(supplier.id)!}"/>
	<div class="layui-form-item layui-row">
		<div class="layui-col-xs6">
			<label class="layui-form-label">库存</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input"
					   name="kucun" value="${(supplier.kucun)!}"  placeholder="请输入购买数量">
			</div>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<div class="layui-input-block">
				<button class="layui-btn layui-btn-lg" lay-submit=""
						lay-filter="buySupplier">确认
				</button>
				<button class="layui-btn layui-btn-lg layui-btn-normal" id="closeBtn">取消</button>
			</div>
		</div>
	</div>
	<br/>

</form>

	<div class="layui-col-md12">
		<table id="supplierBuy" class="layui-table"  lay-filter="supplierOrders"></table>
	</div>
	<script type="text/javascript" src="${ctx}/js/supplier/supplier.buy.js"></script>
</body>
</html>