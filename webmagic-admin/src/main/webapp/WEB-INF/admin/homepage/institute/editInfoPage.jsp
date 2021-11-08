<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <%@ include file="../../common/header.jsp" %>
</head>
<body>
  <div class="layui-card-body" pad15="">
    <form action="/homepage/institute/info/edit" method="post" enctype="multipart/form-data">
      <div class="layui-form" wid100="" lay-filter="">
        <div class="layui-form-item">
          <label class="layui-form-label">资讯标题</label>
          <div class="layui-input-block">
            <input type="hidden" name="id" value="${entity.id}" />
            <input type="text" name="title" value="${entity.title}" lay-verify="required" autocomplete="off" placeholder="请输入标题" class="layui-input">
          </div>
        </div>
        <div class="layui-form-item" style="display: inline-flex;align-items: center;justify-content: flex-start;">
          <label class="layui-form-label">资讯图片</label>
          <input type="file" name="img" id="J_image" style="display: none;">
          <div class="layui-input-inline" style="width: 155px;">
            <img class="layui-upload-img" id="demo1" style="width:150px;height:120px;" src="${website}${entity.mainImg != '' ? entity.mainImg : '/images/news/3.jpg'}">
          </div>
          <button type="button" class="layui-btn" id="J_img_select">选择</button>
        </div>
        <div class="layui-form-item">
          <label class="layui-form-label">资讯类别</label>
          <div class="layui-input-inline">
            <select name="type" lay-filter="">
              <c:forEach items="${list}" var="type">
                <c:if test="${entity.type == type.typeName}">
                  <option value="${type.typeName}" selected>${type.typeName}</option>
                </c:if>
                <c:if test="${entity.type != type.typeName}">
                  <option value="${type.typeName}">${type.typeName}</option>
                </c:if>
              </c:forEach>
            </select>
          </div>
        </div>
        <div class="layui-form-item layui-form-text">
          <label class="layui-form-label">资讯内容</label>
          <div class="layui-input-block">
            <textarea name="content" id="J_content_editer" lay-verify="required" style="display: none;">${type.content}</textarea>
          </div>
        </div>
        <div class="layui-form-item">
          <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="J_form_submit">提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
          </div>
        </div>
        <button id="J_info_submit_btn" style="display: none" class="layui-btn" lay-submit="" lay-filter="" />
      </div>
    </form>
  </div>
<script>
  layui.use('upload', function() {
    var $ = layui.jquery
      , upload = layui.upload;
    var layedit = layui.layedit;

    var index = layedit.build('J_content_editer'); //建立编辑器
    $('#J_img_select').click(function(){
      $('#J_image').click();
    });
    //普通图片上传
    var uploadInst = upload.render({
      elem: '#J_image',
      auto: false,
      accept: 'image',
      acceptMime: 'image/jpg, image/png, image/jpeg',
      choose: function (obj) {
        //预读本地文件示例，不支持ie8
        obj.preview(function (index, file, result) {
          $('#demo1').attr('src', result); //图片链接（base64）
          $('#J_image').val(file);
        });
      }
    });
  });
</script>
</body>
</html>