<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <%@ include file="../common/header.jsp" %>
</head>
<body>
<div class="layui-card-body" pad15="">
  <form action="/enterprise/edit" method="post" enctype="multipart/form-data">
    <div class="layui-form" wid100="" lay-filter="">
      <div class="layui-form-item">
        <label class="layui-form-label">企业名称</label>
        <div class="layui-input-block">
          <input type="text" name="name" value="${entity.name}" lay-verify="required" lay-verify="required" autocomplete="off" placeholder="请输入企业名称" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">企业LOGO</label>
        <input type="file" name="logoFile" id="J_logo_file" style="display: none;">
        <div class="layui-input-inline" style="width: 135px;">
          <img class="layui-upload-img" id="demo1" style="width:120px;height:120px;" src="${entity.logo}">
        </div>
        <button type="button" class="layui-btn" id="J_logo_select">选择</button>
      </div>
      <button id="J_info_submit_btn" style="display: none" class="layui-btn" lay-submit="" lay-filter="J_form_submit" />
    </div>
  </form>
</div>
<script>
  layui.use(['form', 'upload'], function(){
    var form = layui.form;
    var upload = layui.upload;
    //监听提交
    form.on('submit(J_form_submit)', function(args){
      var param = args.field;
      if (!param.logo) {
        layer.msg('请上传企业LOGO', {
          icon : 5
        });
      }
      return true;
    });

    $('#J_logo_select').click(function(){
      $('#J_logo_file').click();
    });
    //普通图片上传
    var uploadInst = upload.render({
      elem: '#J_logo_file',
      auto: false,
      accept: 'image',
      acceptMime: 'image/jpg, image/png, image/jpeg',
      choose: function (obj) {
        //预读本地文件示例，不支持ie8
        obj.preview(function (index, file, result) {
          $('#demo1').attr('src', result); //图片链接（base64）
          $('#J_logo_file').val(file);
        });
      }
    });
  });
</script>
</body>
</html>