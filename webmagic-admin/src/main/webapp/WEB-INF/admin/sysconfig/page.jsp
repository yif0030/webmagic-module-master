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
      <a><cite>系统配置</cite></a>
    </span>
    <a class="layui-btn layui-btn-small" style="line-height: 1.6em; margin-top: 3px; float: right" href="javascript:location.replace(location.href);" title="刷新">
      <i class="layui-icon layui-icon-refresh" style="line-height: 38px"></i>
    </a>
  </div>
  <div class="x-body">
    <blockquote class="layui-elem-quote">
      暂由系统管理人员负责配置
    </blockquote>

    <form class="layui-form layui-form-pane" action="/wconfig/update">
      <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
        <legend>文件保存路径</legend>
      </fieldset>
      <div class="layui-form-item">
        <label class="layui-form-label">保存路径</label>
        <div class="layui-input-block">
          <input type="text" name="fileSavePosition" value="${entity.fileSavePosition}" autocomplete="off" readonly placeholder="请输入文件保存路径" class="layui-input">
        </div>
      </div>
      <%--<div class="layui-form-item">
        <button class="layui-btn" lay-submit="" lay-filter="demo2" style="margin-top: 50px;">确认保存</button>
      </div>--%>
    </form>
  </div>
</body>

</html>