<!DOCTYPE html>
<html>
<head>
    <meta charset="U TF-8">
    <title>生产管理后端-登录</title>
    <#include "common.ftl">
    <link rel="stylesheet" href="${ctx}/css/index.css" media="all">
</head>
<body>
<div class="layui-container">
    <div class="admin-login-background">
        <div class="layui-form login-form">
            <form class="layui-form" action="">
                <div class="layui-form-item logo-title">
                    <h1>生产管理系统登录</h1>
                </div>
                <div class="layui-form-item">
                    <label class="layui-icon layui-icon-username" for="username"></label>
                     <input type="text" name="username" lay-verify="required|account" placeholder="用户名或者邮箱" autocomplete="on" class="layui-input" >
                </div>
                <div class="layui-form-item">
                    <label class="layui-icon layui-icon-password" for="password"></label>
                    <input type="password" name="password" lay-verify="required|password" placeholder="密码" autocomplete="on" class="layui-input" >
                </div>
                <#-- 记住我 -->
                <div class="layui-form-item">
                    <input type="checkbox" name="rememberMe" id="rememberMe" value="true" lay-skin="primary" title="记住密码">
                </div>
                <div class="layui-form-item layui-anim layui-anim-up layui-anim-down" >
                    <button class="layui-btn layui-btn-fluid  layui-btn-warm"  lay-submit="" lay-filter="login">登 录</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="${ctx}/js/index.js" charset="utf-8"></script>
</body>
</html>
