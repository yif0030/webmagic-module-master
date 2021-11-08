<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <%@ include file="../common/header.jsp" %>
</head>
<body>
  <div class="layui-card-body" pad15="">
    <form action="" method="post">
      <div class="layui-form" wid100="" lay-filter="">
        <div class="layui-form-item">
          <label class="layui-form-label">项目题目</label>
          <div class="layui-input-block">
            <input type="text" name="title" lay-verify="required" lay-verify="required" autocomplete="off" placeholder="请输入项目题目" class="layui-input">
          </div>
        </div>
        <div class="layui-form-item">
          <div class="layui-inline">
            <label class="layui-form-label">起止时间</label>
            <div class="layui-input-inline">
              <input type="text" class="layui-input" id="J_time_circle" lay-verify="required" placeholder=" - ">
            </div>
          </div>
        </div>
        <div class="layui-form-item">
          <label class="layui-form-label">项目级别</label>
          <div class="layui-input-block">
            <input name="level" type="hidden" value="校级" />
            <input type="checkbox" name="level[1]" title="校级" value="校级" checked lay-filter="check_filter">
            <input type="checkbox" name="level[2]" title="市级" value="市级" lay-filter="check_filter">
            <input type="checkbox" name="level[3]" title="省级" value="省级" lay-filter="check_filter">
          </div>
        </div>
        <div class="layui-form-item layui-form-text">
          <label class="layui-form-label">项目内容</label>
          <div class="layui-input-block">
            <textarea id="J_content_editer" lay-verify="required" style="display: none;"></textarea>
          </div>
        </div>
        <div class="layui-form-item">
          <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="J_form_submit">提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
          </div>
        </div>
        <button id="J_info_submit_btn" style="display: none" class="layui-btn" lay-submit="" lay-filter="J_form_submit" />

      </div>
    </form>
  </div>
<script>
  layui.use(['layedit', 'form', 'laydate'], function(){
    var form = layui.form,
        laydate = layui.laydate;
    var layedit = layui.layedit;
    var index = layedit.build('J_content_editer'); //建立编辑器

    //监听提交
    form.on('submit(J_form_submit)', function(args){
      var timeCircle = $('#J_time_circle').val();
      var resultTime = timeCircle.split(' - ');
      var param = args.field;
      $.post('/srproject/add', {
        title: param.title,
        content: layedit.getContent(index),
        fromTime: resultTime[0],
        toTime: resultTime[1],
        level: param.level
      }, function(result){
        if ('success' == result) {
          layer.msg('操作成功', {
            icon : 1
          });
        } else {

        }
      });
      return false;
    });

    laydate.render({
      elem: '#J_time_circle'
      ,range: true
    });

    form.on('checkbox(check_filter)', function(data){
      $('[lay-filter="check_filter"]').prop("checked", false);
      $checked = $(data.elem);
      $checked.prop("checked", true);
      form.render('checkbox');

      console.info($('input[name="level"]'))
      $('input[name="level"]').val($checked.val());
    });
  });
</script>
</body>
</html>