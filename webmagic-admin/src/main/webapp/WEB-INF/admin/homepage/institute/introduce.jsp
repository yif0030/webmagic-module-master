<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <%@ include file="../../common/header.jsp" %>
  <link href="/third-party/umeditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
  <link href="/css/admin/style.css" rel="stylesheet">
  <script type="text/javascript" charset="utf-8" src="/third-party/umeditor/umeditor.config.js"></script>
  <script type="text/javascript" charset="utf-8" src="/third-party/umeditor/umeditor.min.js"></script>
  <script type="text/javascript" src="/third-party/umeditor/lang/zh-cn/zh-cn.js"></script>
  <style rel="stylesheet">
    li {
      list-style: disc;
    }
  </style>
  <script>
    $(function () {
      //实例化编辑器
      var um = UM.getEditor('myEditor');
      $("#J_submit").click(function () {

        var intruductionStr = UM.getEditor('myEditor').getContent();
        $.ajax({
          url: "/institute/update",
          dataType: "json",
          data: {
            intruductionStr: intruductionStr
          },
          success: function (args) {
            if ("success" == args.result) {
              layer.msg('修改成功');
            }
          }
        });
      });
    });
  </script>
</head>
<body>
<div class="x-nav">
  <span class="layui-breadcrumb">
     <a href="">模块管理</a>
    <a href="">网站首页</a>
    <a><cite>研究所介绍</cite></a>
  </span>
  <a class="layui-btn layui-btn-small" style="line-height: 1.6em; margin-top: 3px; float: right" href="javascript:location.replace(location.href);" title="刷新">
    <i class="layui-icon layui-icon-refresh" style="line-height: 38px"></i>
  </a>
</div>
<div class="x-body">
  <blockquote class="layui-elem-quote">
    研究所介绍
  </blockquote>
  <!--style给定宽度可以影响编辑器的最终宽度-->
  <script type="text/plain" id="myEditor" style="width:100%;height:480px;">
    ${entity.introduction}
  </script>

  <div style = "margin-top: 50px;">
    <button id="J_submit" class="layui-btn layui-btn-fluid layui-btn-radius"> 确认保存 </button>
  </div>
</div>
</body>
</html>