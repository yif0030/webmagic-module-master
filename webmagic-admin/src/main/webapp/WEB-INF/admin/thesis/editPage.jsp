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
        <label class="layui-form-label">论文标题</label>
        <div class="layui-input-block">
          <input name="id" type="hidden" value="${entity.id}" />
          <input type="text" name="title" value="${entity.title}" lay-verify="required" lay-verify="required" autocomplete="off" placeholder="请输入标题" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-inline">
          <label class="layui-form-label">年份</label>
          <div class="layui-input-inline">
            <input name="year" type="text" class="layui-input" id="J_year_select" value="${entity.year}" lay-verify="required" placeholder="">
          </div>
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">类别</label>
        <div class="layui-input-block">
          <input name="type" type="hidden" value="${entity.type}" />
          <input type="checkbox" name="type[1]" title="期刊" value="期刊" ${'期刊'==entity.type ? 'checked=checked' : ''} lay-filter="check_filter">
          <input type="checkbox" name="type[2]" title="会议" value="会议" ${'会议'==entity.type ? 'checked=checked' : ''} lay-filter="check_filter">
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
  layui.use(['form', 'laydate'], function(){
    var form = layui.form,
      laydate = layui.laydate;

    //监听提交
    form.on('submit(J_form_submit)', function(args){
      var param = args.field;
      $.post('/thesis/edit', {
        id: param.id,
        title: param.title,
        year: param.year,
        type: param.type
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

    form.on('checkbox(check_filter)', function(data){
      $('[lay-filter="check_filter"]').prop("checked", false);
      $checked = $(data.elem);
      $checked.prop("checked", true);
      form.render('checkbox');

      $('input[name="type"]').val($checked.val());
    });

    laydate.render({
      elem: '#J_year_select'
      ,type: 'year'
    });
  });
</script>
</body>
</html>