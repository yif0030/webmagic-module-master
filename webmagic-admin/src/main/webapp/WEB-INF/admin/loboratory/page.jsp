<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <%@ include file="../common/header.jsp" %>
  <link href="/css/admin/style.css" rel="stylesheet">
  <style rel="stylesheet">
    .x-body .layui-form{
      width: 70%;
    }
  </style>
</head>
<body>
  <div class="x-nav">
    <span class="layui-breadcrumb">
      <a href="">系统管理</a>
      <a><cite>实验室</cite></a>
    </span>
    <a class="layui-btn layui-btn-small" style="line-height: 1.6em; margin-top: 3px; float: right" href="javascript:location.replace(location.href);" title="刷新">
      <i class="layui-icon layui-icon-refresh" style="line-height: 38px"></i>
    </a>
  </div>
  <div class="x-body">
    <blockquote class="layui-elem-quote">
      在这里尝试改进后的功能，希望您能给予真实的评价及意见反馈，以便我们可以更好的为您服务~
    </blockquote>
    <fieldset class="layui-elem-field">
      <legend>本次体验功能</legend>
      <div class="layui-field-box">
        研究所资讯编辑
      </div>
    </fieldset>

    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
      <legend>界面评分</legend>
    </fieldset>
    <div><div id="test1"></div></div>

    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
      <legend>功能评分(功能性是否达到预期)</legend>
    </fieldset>
    <div><div id="test2"></div></div>

    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
      <legend>操作评分</legend>
    </fieldset>
    <div><div id="test3"></div></div>

  </div>


<script>
  layui.use(['rate'], function(){
    var rate = layui.rate;
    rate.render({
      elem: '#test1'
      ,length: 10
      ,value: 5 //初始值
    });

    rate.render({
      elem: '#test2'
      ,length: 10
      ,value: 5 //初始值
    });

    rate.render({
      elem: '#test3'
      ,length: 10
      ,value: 5 //初始值
    });

  });
</script>
</body>

</html>