layui.use(['table','layer'],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;

    /**
     * 营销机会列表展示
     */
    var  tableIns = table.render({  //返回表格渲染的唯一标识
        elem: '#kcCarList', // 表格绑定的ID
        url : ctx + '/kc_car/list', // 访问数据的地址
        cellMinWidth : 95,
        page : true, // 开启分页
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        toolbar: "#toolbarDemo",
        id : "kcCarListTable",
        cols : [[
            {type: "checkbox", fixed:"center"},
            {field: "id", title:'编号',fixed:"true"},
            {field: 'name', title: '汽车名字',align:"center"},
            {field: 'number', title: '数量',  align:'center'},
            {field: 'createDate', title: '入库时间', align:'center'},
            {field: 'updateDate', title: '分配时间', align:'center'},
            {field: 'state', title: '分配状态', align:'center',templet:function(d){
                    return formatterState(d.state);
                }},
            {title: '操作', templet:'#kcCarListBar',fixed:"right",align:"center", minWidth:150}
        ]]
    });
    //这里以搜索为例
    $("#btnSearch").click(function (){

        tableIns.reload({
            where: { //设定异步数据接口的额外参数，任意设
                name:$('[name="name"]').val(),

            }
            ,page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    });

    /**
     * 格式化分配状态
     *  0 - 未分配
     *  1 - 已分配
     *  其他 - 未知
     * @param state
     * @returns {string}
     */
    function formatterState(state){
        if(state==0) {
            return "<div style='color: yellow'>未分配</div>";
        } else if(state==1) {
            return "<div style='color: green'>已分配</div>";
        } else {
            return "<div style='color: red'>未知</div>";
        }
    }
    /**
     * 监听表格的头部工具栏
     */
    table.on('toolbar(kcCars)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        switch(obj.event){
            case 'add':
                openAddOrUpdateDialog();//打开添加修改的窗口页面
                break;
            case 'del':
                deleteBatch(checkStatus.data);
                break;
        };
    });
    //批量删除
    function deleteBatch(data){
        //判断是否选中数据
        if(data.length == 0){
            layer.msg("请至少选中一条数据");
            return;
        }
        //向用户确认删除行为
        layer.confirm("您确定要删除选中的记录吗？",{
            btn:["确认","取消"],
        },function (index) {
            //关闭弹出框
            layer.close(index);

            //拼接后台需要的id数组  ids=1&ids=2
            var str = "ids=";
            for(var i = 0; i < data.length; i++){
                //判断是否是倒数第二个
                if(i < data.length - 1){
                    str += data[i].id + "&ids=";
                }else{
                    str += data[i].id;
                }
            }
            console.log(str);

            $.ajax({
                type:"post",
                url: ctx+"/kc_car/deleteBatch",
                data:str,
                dataType:"json",
                success:function(data){
                    if(data.code == 200){
                        //刷新数据表格
                        tableIns.reload();
                    }else{
                        layer.msg(data.msg,{icon:5})
                    }
                }
            });
        })
    }
    /**
     * 监听表格的行工具栏
     */
    table.on('tool(kcCars)', function(obj){
        console.log(obj)
        if(obj.event == "edit"){
            openAddOrUpdateDialog(obj.data.id);
        }else if(obj.event == "del"){
            // 询问是否确认删除
            layer.confirm("确定要删除这条记录吗？", {icon: 3, title:"营销机会数据管理"}, function (index) {
                // 关闭窗口
                layer.close(index);
                // 发送ajax请求，删除记录
                $.ajax({
                    type:"post",
                    url: ctx + "/kc_car/deleteBatch",
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
        var url = ctx + "/kc_car/toAddUpdatePage";
        //通过参数id判断目前是修改还是添加操作
        if(id){
            title = "<h2>库存修改</h2>";
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