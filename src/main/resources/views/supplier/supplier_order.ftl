<!DOCTYPE html>
<html>
<head>
	<title>采购订单查看</title>
	<#include "../common.ftl">
</head>
<body class="childrenBody">
	<div class="layui-col-md12">
		<div class="layui-card">
			<div class="layui-card-body">
				<form class="layui-form" >
					<input name="id" type="hidden" value="${(supplier.id)!}"/>
					<div class="layui-form-item layui-row">
						<div class="layui-col-xs6">
							<label class="layui-form-label">零件名称</label>
							<div class="layui-input-block">
								<input type="text" class="layui-input"
									   name="name" id="name"  value="${(supplier.name)!}" readonly="readonly">
							</div>
						</div>
						<div class="layui-col-xs6">
							<label class="layui-form-label">销售经理</label>
							<div class="layui-input-block">
								<input type="text" class="layui-input"
									   name="manager" id="manager" value="${(supplier.manager)!}" readonly="readonly">
							</div>
						</div>
					</div>

					<div class="layui-form-item layui-row">
						<div class="layui-col-xs6">
							<label class="layui-form-label">客户地址</label>
							<div class="layui-input-block">
								<input type="text" class="layui-input"
									   name="address"   value="${(supplier.address)!}" readonly="readonly">
							</div>
						</div>
						<div class="layui-col-xs6">
							<label class="layui-form-label">联系电话</label>
							<div class="layui-input-block">
								<input type="text" class="layui-input"
									    name="phone" value="${(supplier.phone)!}" id="phone" readonly="readonly">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="layui-col-md12">
		<table id="supplierOrderList" class="layui-table"  lay-filter="supplierOrders"></table>
	</div>



	<!--操作-->
	<script id="supplierOrderListBar" type="text/html">
		<a class="layui-btn layui-btn-xs"  lay-event="info">订单详情</a>
	</script>
	<script type="text/javascript" src="${ctx}/js/supplier/supplier.order.js"></script>
</body>
</html>