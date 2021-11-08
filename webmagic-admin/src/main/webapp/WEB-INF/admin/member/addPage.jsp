<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <%@ include file="../common/header.jsp" %>
</head>
<body>
  <div class="layui-card-body" pad15="">
    <form action="/member/add" method="post" enctype="multipart/form-data">
      <div class="layui-form" wid100="" lay-filter="">
        <div class="layui-form-item" style="display: inline-flex;align-items: center;justify-content: flex-start;">
          <label class="layui-form-label">头像</label>
          <input type="file" name="avatar" id="J_avatar_file" style="display: none;">
          <div class="layui-input-inline" style="width: 135px;">
            <img class="layui-upload-img" id="demo1" style="width:120px;height:120px;-webkit-border-radius: 50%;-moz-border-radius: 50%;border-radius: 50%;" src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1541334737490&di=f0a42dced736696808dee6f13c17092a&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01786557e4a6fa0000018c1bf080ca.png">
          </div>
          <button type="button" class="layui-btn" id="J_avatar_select">选择</button>
        </div>
        <div class="layui-form-item">
          <label class="layui-form-label">姓名</label>
          <div class="layui-input-block">
            <input type="text" name="name" value="" lay-verify="required" class="layui-input">
          </div>
        </div>
        <div class="layui-form-item">
          <label class="layui-form-label">专业1</label>
          <div class="layui-input-block">
            <input type="text" name="major1" value="" class="layui-input">
          </div>
        </div>
        <div class="layui-form-item">
          <label class="layui-form-label">专业2</label>
          <div class="layui-input-block">
            <input type="text" name="major2" value="" class="layui-input">
          </div>
        </div>
        <div class="layui-form-item">
          <label class="layui-form-label">学院</label>
          <div class="layui-input-block">
            <input type="text" name="institute" value="" class="layui-input">
          </div>
        </div>
        <%--<div class="layui-form-item">
          <label class="layui-form-label">是否展示</label>
          <div class="layui-input-block">
            <input type="radio" name="isShow" value="1" title="是" checked="checked">
            <input type="radio" name="isShow" value="0" title="否">
          </div>
        </div>--%>
        <div class="layui-form-item">
          <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="">提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
          </div>
        </div>
      </div>
    </form>
  </div>
<script>
  layui.use('upload', function() {
    var $ = layui.jquery
      , upload = layui.upload;

    $('#J_avatar_select').click(function(){
      $('#J_avatar_file').click();
    });
    //普通图片上传
    var uploadInst = upload.render({
      elem: '#J_avatar_file',
      auto: false,
      accept: 'image',
      acceptMime: 'image/jpg, image/png, image/jpeg',
      choose: function (obj) {
        //预读本地文件示例，不支持ie8
        obj.preview(function (index, file, result) {
          $('#demo1').attr('src', result); //图片链接（base64）
          $('#J_avatar_file').val(file);
        });
      }
    });
  });
</script>
</body>
</html>