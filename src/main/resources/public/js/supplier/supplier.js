layui.use(['table','layer',"form"],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table,
        form = layui.form;

    //客户列表展示
    var  tableIns = table.render({
        id : "supplierList",
        elem: '#supplierList',
        url : ctx+'/supplier/list',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        toolbar: "#toolbarDemo",
        cols : [[
            {type: "checkbox", fixed:"center"},
            {field: "id", title:'编号',fixed:"true"},
            {field: 'name', title: '零件名',align:"center"},
            {field: 'kucun', title: '库存', align:'center'},
            {field: 'money', title: '单价', align:'center'},
            {field: 'ljno', title: '零件编号', align:'center'},
            {field: 'xyd', title: '信用度', align:'center'},
            {field: 'area', title: '地区', align:'center'},
            {field: 'manager', title: '销售经理',  align:'center'},
            {field: 'myd', title: '满意度', align:'center'},
            {field: 'level', title: '客户级别', align:'center'},
            {field: 'address', title: '详细地址', align:'center'},
            {field: 'phone', title: '电话', align:'center'},
            {field: 'webSite', title: '网站', align:'center'},
            {field: 'fax', title: '传真', align:'center'},
            {field: 'zczj', title: '注册资金', align:'center'},
            {field: 'yyzzzch', title: '营业执照', align:'center'},
            {field: 'khyh', title: '开户行', align:'center'},
            {field: 'fr', title: '法人',  align:'center'},
            {field: 'createDate', title: '创建时间', align:'center'},
            {field: 'updateDate', title: '更新时间', align:'center'},
            {title: '操作', templet:'#supplierListBar',fixed:"right",align:"center", minWidth:150}
        ]]
    });

    /**
     * 搜索按钮单击事件
     */
    $(".search_btn").click(function () {
        /**
         * 表格重载
         *  多条件查询
         */
        tableIns.reload({
            // 设置需要传递给后端的参数
            where: { //设定异步数据接口的额外参数，任意设
                // 通过文本框/下拉框的值，设置传递的参数
                name: $("[name='name']").val() // 零件名称  前面与query中一致，后面使用了id选择器，与ftl文件一致
                ,ljno: $("[name='ljno']").val() // 零件编号
                ,level:$("[name='level']").val() // 供应商等级
            }
            ,page: {
                curr: 1 // 重新从第 1 页开始
            }
        });
    })



    /**
     * 头部工具栏监听 --> 添加/联系人管理/交往记录/订单查看
     */
    table.on('toolbar(suppliers)', function(data) {
        console.log(data)
        if (data.event == "add") {
            // 添加
            openDialog();
        } else if (data.event == "order") {
            // 订单查看
            //打开订单查看对话框(传递选中的客户记录)
            openOrderDialog();
        }else if(data.event == "purchase"){
            //采购零件
            //打开采购零件对话框
            openPurchase();
        }
    })

    /**
     * 打开订单页面
     */
    function openOrderDialog(data) {
        //获取表格选中状态
        let checkStatus = table.checkStatus("supplierList");
        // 获取选中的数据
        let checkData = checkStatus.data;

        if (checkData.length == 0) {
            layer.msg("请选中一条记录", {icon:5});
            return;
        }
        if (checkData.length > 1) {
            layer.msg("暂不支持批量查看", {icon:5});
            return;
        }
        //打开对话框
        let url = ctx + "/supplier/toOrderPage?id=" + checkData[0].id;
        let title = "<h3>采购管理 - 订单查看</h3>"

        layui.layer.open({
            type:2,
            title: title,
            area: ['700px','500px'],
            content: url,
            maxmin:true,
        })
    }

    function openPurchase(data){
        //获取表格选中状态
        let checkStatus = table.checkStatus("supplierList");
        // 获取选中的数据
        let checkData = checkStatus.data;
        if (checkData.length == 0) {
            layer.msg("请选中一条记录", {icon:5});
            return;
        }
        if (checkData.length > 1) {
            layer.msg("暂不支持批量购买", {icon:5});
            return;
        }
        let title = "<h3>零件购买 - 购买零件信息</h3>"
        let url = ctx + "/supplier/buySuppliers?id=" + checkData[0].id;
        layui.layer.open({
            type:2,
            title: title,
            area: ['660px', '620px'],
            content: url,
            maxmin:true
        });
    }

    /**
     * 行工具栏监听 --> 编辑/删除
     */
    table.on('tool(suppliers)', function (data) {
        console.log("监听到了行工具栏");
        console.log(data);
        if (data.event == "edit") {
            // 编辑
            openDialog(data.data.id);
        } else if (data.event == "del") {
            // 删除
            delSupplier(data);
        }
    })


    /**
     * 打开[添加/编辑]零件窗口
     */
    function openDialog(id) {
        let title = "<h3>零件管理 - 添加零件信息</h3>"
        let url = ctx + "/supplier/toAddSupplier";
        if (id != null && id != '') {
            title = "<h3>零件管理 - 修改零件信息</h3>"
            console.log(id);
            url += "?id=" + id;
        }

        layui.layer.open({
            type:2,
            title: title,
            area: ['660px', '620px'],
            content: url,
            maxmin:true
        });
    }

    /**
     * 删除客户信息
     */
    function delSupplier(data) {
        layer.confirm('确定要删除该记录吗？', {icon: 3, title: "采购管理"}, function (index) {
            // 关闭确认框
            layer.close(index);

            // 发送ajax请求，删除记录
            $.ajax({
                type: "post",
                url: ctx + "/supplier/delete",
                data: {
                    id: data.data.id
                },
                success: function (result) {
                    // 判断删除结果
                    if (result.code == 200) {
                        // 提示成功
                        layer.msg("删除成功！", {icon: 6});
                        // 刷新页面
                        window.location.reload();
                    } else {
                        // 提示失败
                        layer.msg(result.msg, {icon: 5});
                    }
                }
            });
        });
    }

});

