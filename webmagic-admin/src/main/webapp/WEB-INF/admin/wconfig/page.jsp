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
      <a><cite>网站配置</cite></a>
    </span>
    <a class="layui-btn layui-btn-small" style="line-height: 1.6em; margin-top: 3px; float: right" href="javascript:location.replace(location.href);" title="刷新">
      <i class="layui-icon layui-icon-refresh" style="line-height: 38px"></i>
    </a>
  </div>
  <div class="x-body">
    <blockquote class="layui-elem-quote">
      请在此编辑网站配置信息
    </blockquote>

    <form class="layui-form layui-form-pane" action="/wconfig/update">
      <input name="id" value="${entity.id}" type="hidden" />
      <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
        <legend>网站head</legend>
      </fieldset>
      <div class="layui-form-item">
        <label class="layui-form-label">网站名称</label>
        <div class="layui-input-block">
          <input type="text" name="websiteTitle" value="${entity.websiteTitle}" autocomplete="off" placeholder="请输入网站名称" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">网站描述</label>
        <div class="layui-input-block">
          <textarea name="description" placeholder="用于百度SEO" class="layui-textarea">${entity.description}</textarea>
        </div>
      </div>
      <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
        <legend>网站footer</legend>
      </fieldset>
      <div class="layui-form-item">
        <label class="layui-form-label">联系邮箱</label>
        <div class="layui-input-block">
          <input type="email" name="email" value="${entity.email}" lay-verify="required" placeholder="请输入联系邮箱" autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">联系地址</label>
        <div class="layui-input-block">
          <input type="text" name="address" value="${entity.address}" lay-verify="required" placeholder="请输入联系地址" autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">copyright</label>
        <div class="layui-input-block">
          <input type="text" name="copyright" value="${entity.copyright}" lay-verify="required" placeholder="请输入copyright" autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <button class="layui-btn" lay-submit="" lay-filter="demo2" style="margin-top: 50px;">确认保存</button>
      </div>
      <%--<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">--%>
        <%--<legend>更多~开发中</legend>--%>
      <%--</fieldset>--%>
    </form>
  </div>
</body>

</html>