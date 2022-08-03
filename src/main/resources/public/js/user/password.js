layui.use(['form','jquery','jquery_cookie'], function () {
    var form = layui.form,
        layer = layui.layer,
        $ = layui.jquery,
        $ = layui.jquery_cookie($);
    form.on("submit(saveBtn)",function (data){
        var fieldData =data.field;
        $.ajax({
            type:"post",
            url:ctx + "/user/update",
            data:{
                oldPassword:fieldData.old_password,
                newPassword:fieldData.new_password,
                confirmPassword:fieldData.again_password
            },
            dataType:"json",
            success:function (data){
                if (data.code==200){
                    layer.msg("用户密码修改成功",function (){
                        $.removeCookie("userIdStr", {domain:"localhost",path:"/crm"});
                        $.removeCookie("userName", {domain:"localhost",path:"/crm"});
                        $.removeCookie("trueName", {domain:"localhost",path:"/crm"});
                        window.parent.location.href = ctx+"/index";
                    });
                }else {
                    layer.msg(data.msg);
                }
            }
        });
        return false;//阻止表单提交
    })



});
