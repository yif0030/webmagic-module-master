<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
  <meta name="renderer" content="webkit|ie-comp|ie-stand">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8" />
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <title>MiDAS Admin</title>
  <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
  <link rel="stylesheet" href="/css/font.css">
  <link rel="stylesheet" href="/css/xadmin.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="/lib/layui/layui.js" charset="utf-8"></script>
  <script src="/js/xadmin.js"></script>
</head>
<body class="login-bg">
  <div class="login layui-anim layui-anim-up">
    <div class="message">MiDAS-后台管理</div>
    <div id="darkbannerwrap"></div>
    <form method="post" action="/login" class="layui-form" >
      <input name="username" type="text" lay-verify="required" class="layui-input" placeholder="用户名">
      <hr class="hr15">
      <input name="password" type="password" lay-verify="required" class="layui-input" placeholder="密码">
      <hr class="hr15">
      <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
      <hr class="hr20" >
    </form>
  </div>
  <script>
    $(function() {

    });
  </script>
</body>
</html>