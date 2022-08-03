layui.use(['form', 'layer'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;

    /**
     * 表单提交 [添加/修改] 客户信息
     */
    form.on('submit(addSupplier)', function (data) {
        // 提交数据时的加载层 （https://layer.layui.com/）
        var index = layer.msg("数据提交中,请稍后...",{
            icon:16, // 图标
            time:false, // 不关闭
            shade:0.8 // 设置遮罩的透明度
        });
        console.log(data.field);

        let title = "<h3>采购管理 - 添加零件信息</h3>";
        var url = ctx + "/supplier/add";
        if (data.field.id != null && data.field.id != "") {
            title = "<h3>采购管理 - 修改零件信息</h3>";
             url = ctx + "/supplier/update";
        }

        // 发送ajax请求
        $.post(url, data.field, function (result) {
            if (result.code === 200) {
                layer.msg("操作成功!", {icon:6});
                // 关闭加载层
                layer.close(index);
                // 关闭弹出层
                layer.closeAll("iframe");
                // 刷新父窗口,重新加载数据
                parent.location.reload();

            } else {
                layer.msg(result.msg, {icon:5});
            }
        })

        return false;


    })

    /**
     * 关闭弹出层
     */
    $("#closeBtn").click(function () {
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
    });


});