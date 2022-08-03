layui.use(['table','layer'],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;

    /**
     * 营销机会列表展示
     */
    var  tableIns = table.render({  //返回表格渲染的唯一标识
        elem: '#CustomerServeList', // 表格绑定的ID
        url : ctx + '/customer_serve/list', // 访问数据的地址
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
            {field: 'name', title: '名字',align:"center"},
            {field: 'price', title: '价格',  align:'center'},
            {field: 'updataData', title: '时间', align:'center'},
            {title: '操作', templet:'#CustomerServeListBar',fixed:"right",align:"center", minWidth:150}
        ]]
    });


    //数据表格重载
    $("#btnSearch").click(function (){
        tableIns.reload({
            where: { //设定异步数据接口的额外参数，任意设
                name:$('[name="name"]').val(),
                price:$('[name="price"]').val(),
            }
            ,page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    });


    /**
     * 监听表格的行工具栏
     */
    //监听事件
    table.on('tool(CustomerServes)', function(obj){
        if(obj.event == "edit"){
            openAddOrUpdateDialog(obj.data.id);
        }else if(obj.event == "del"){
            // 询问是否确认删除
            layer.confirm("恭喜售卖成功", {icon: 3, title:"营销机会数据管理"}, function (index) {
                // 关闭窗口
                layer.close(index);
                // 发送ajax请求，删除记录
                $.ajax({
                    type:"post",
                    url: ctx + "/customer_serve/deleteBatch",
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
        var url = ctx + "/customer_serve/toAddUpdatePage";

        //通过参数id判断目前是修改还是添加操作
        if(id){
            title = "<h2>修改</h2>";
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



});