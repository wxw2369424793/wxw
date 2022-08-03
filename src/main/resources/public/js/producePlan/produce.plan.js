layui.use(['table','layer'],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;

    /**
     * 营销机会列表展示
     */
    var  tableIns = table.render({  //返回表格渲染的唯一标识
        elem: '#producePlanList', // 表格绑定的ID
        url : ctx + '/produce_plan/list', // 访问数据的地址
        cellMinWidth : 95,
        page : true, // 开启分页
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        toolbar: "#toolbarDemo",
        id : "saleChanceListTable",
        cols : [[
            {type: "checkbox", fixed:"center"},
            {field: "id", title:'编号',fixed:"true"},
            {field: 'carType', title: '汽车品牌',align:"center"},
            {field: 'overview', title: '概要', align:'center'},
            {field: 'createMan', title: '创建人', align:'center'},
            {field: 'createDate', title: '创建时间', align:'center'},
            {field: 'updateDate', title: '更新时间', align:'center'},
            {field: 'state', title: '生产状态', align:'center',templet:function(d){
                    return formatterState(d.state);
                }},
            {title: '操作', templet:'#saleChanceListBar',fixed:"right",align:"center", minWidth:150}
        ]]
    });


    //这里以搜索为例
    $(".search_btn").click(function (){
        tableIns.reload({
            where: { //设定异步数据接口的额外参数，任意设
                carType:$('[name="carType"]').val(),
                createMan:$('[name="createMan"]').val(),
                state:$('[name="state"]').val()
            }
            ,page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    });


    /**
     * 监听表格的头部工具栏
     */
    //监听事件
    table.on('toolbar(saleChances)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        console.log(checkStatus.data);
        switch(obj.event){
            case 'add':
                openAddOrUpdateDialog();//打开添加修改的窗口页面
                break;
            case 'del':
                deleteBatch(checkStatus.data);
                break;
            case 'dev':
                updateState(checkStatus.data);
                break;
        };
    });

    //批量删除
    function deleteBatch(data) {
        //判断是否选中数据
        if (data.length == 0) {
            layer.msg("请至少选中一条数据");
            return;
        }
        //向用户确认删除行为
        layer.confirm("您确定要删除选中的记录吗？", {
            btn: ["确认", "取消"],
        }, function (index) {
            //关闭弹出框
            layer.close(index);

            //拼接后台需要的id数组  ids=1&ids=2
            var str = "ids=";
            for (var i = 0; i < data.length; i++) {
                //判断是否是倒数第二个
                if (i < data.length - 1) {
                    str += data[i].id + "&ids=";
                } else {
                    str += data[i].id;
                }
            }
            console.log(str);

            $.ajax({
                type: "post",
                url: ctx + "/produce_plan/deleteBatch",
                data: str,
                dataType: "json",
                success: function (data) {
                    if (data.code == 200) {
                        //刷新数据表格
                        tableIns.reload();
                    } else {
                        layer.msg(data.msg, {icon: 5})
                    }
                }
            });

        })
    }

    //批量更改状态
    function updateState(data) {
        //判断是否选中数据
        if (data.length == 0) {
            layer.msg("请至少选中一条数据");
            return;
        }
        //向用户确认删除行为
        layer.confirm("您确定要更改选中的记录吗？", {
            btn: ["确认", "取消"],
        }, function (index) {
            //关闭弹出框
            layer.close(index);

            //拼接后台需要的id数组  ids=1&ids=2
            var str = "iids=";
            for (var i = 0; i < data.length; i++) {
                //判断是否是倒数第二个
                if (i < data.length - 1) {
                    str += data[i].id + "&iids=";
                } else {
                    str += data[i].id;
                }
            }
            console.log("111"+str);

            $.ajax({
                type: "post",
                url: ctx + "/produce_plan/updateProState",
                data: str,
                dataType: "json",
                success: function (data) {
                    if (data.code == 200) {
                        //刷新数据表格
                        tableIns.reload();
                    } else {
                        layer.msg(data.msg, {icon: 5})
                    }
                }
            });

        })
    }

    /**
     * 监听表格的行工具栏
     */
    //监听事件
    table.on('tool(saleChances)', function(obj){
        if(obj.event == "edit"){
            openAddOrUpdateDialog(obj.data.id);
        }else if(obj.event == "del"){
            // 询问是否确认删除
            layer.confirm("确定要删除这条记录吗？", {icon: 3, title:"生产计划管理"}, function (index) {
                // 关闭窗口
                layer.close(index);
                // 发送ajax请求，删除记录
                $.ajax({
                    type:"post",
                    url: ctx + "/produce_plan/deleteBatch",
                    data:{
                        ids:obj.data.id
                    },
                    dataType:"json",
                    success:function (result) {
                        if (result.code == 200) {
                            // 加载表格
                            tableIns.reload();
                        } else {
                            layer.msg(result.msg, {icon: 5});
                        }
                    }
                });
            });
        }
    });


    /**
     * 打开添加修改的窗口页面
     */
    function openAddOrUpdateDialog(id){
        var title = "<h2>生产计划管理 - 计划添加</h2>";
        var url = ctx + "/produce_plan/toAddUpdatePage";

        //通过参数id判断目前是修改还是添加操作
        if(id){
            title = "<h2>生产计划管理 - 计划修改</h2>";
            url += "?id="+id;
        }

        //打开修改添加页面
        layer.open({
            type:2,   //ifame
            title:title,
            content: url,   //页面的内容
            area:['500px','250px'], //设置宽高
            maxmin:true //可以伸缩页面大小
        });
    }



    /**
     * 格式化分配状态
     *  0 - 生产完成
     *  1 - 生产中
     * @param state
     * @returns {string}
     */
    function formatterState(state){
        if(state==2) {
            return "<div style='color: green'>生产完成</div>";
        } else if(state==1) {
            return "<div style='color: red'>生产中</div>";
        }

    }

});