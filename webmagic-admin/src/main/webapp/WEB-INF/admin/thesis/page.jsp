<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <%@ include file="../common/header.jsp" %>
</head>
<body>
<div class="x-nav">
  <span class="layui-breadcrumb">
    <a href="">首页</a>
    <a><cite>论文著作</cite></a>
  </span>
  <a class="layui-btn layui-btn-small" style="line-height: 1.6em; margin-top: 3px; float: right"
     href="javascript:location.replace(location.href);" title="刷新">
    <i class="layui-icon layui-icon-refresh" style="line-height: 38px"></i>
  </a>
</div>
<div class="x-body">

  <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>列表</legend>
  </fieldset>

  <table class="layui-table" id="J_list" lay-filter="J_list" lay-data="{id: 'idTest'}"></table>

</div>
<script>
  layui.use('table', function(){
    var table = layui.table;

    table.render({
      elem: '#J_list',
      id: 'idTest'
      ,url:'/thesis/list'
      ,parseData: function(res){ //res 即为原始返回的数据
        return {
          "code": res.status, //解析接口状态
          "msg": res.message, //解析提示文本
          "count": res.total, //解析数据长度
          "data": res.data.item //解析数据列表
        };
      }
      ,cellMinWidth: 100 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
      ,cols: [[
        {field:'title', width: 400, title: '论文标题'}
        ,{field:'year', width: 80, title: '年份'}
        ,{field:'type', width: 80, title: '类型'}
        ,{field:'createTime', width:165, title: '创建时间'}
        ,{field:'attachmentList', width:165, title: '附件个数', templet: function(d){
          return d.attachmentList.length || 0
          }}
        ,{fixed: 'right', title:'操作', toolbar: '#bar', width:180}

      ]]
      ,toolbar: '#toolbar',
      defaultToolbar: ['']
    });

    //头工具栏事件
    table.on('toolbar(J_list)', function(obj){
      var checkStatus = table.checkStatus(obj.config.id);
      switch(obj.event){
        case 'addData':
          var index = layer.open({
            type: 2
            ,title: '添加论文著作'
            ,area: ['800px', '500px']
            ,shade: 0
            ,maxmin: true
            ,content: '/thesis/addPage'
            ,btn: ['提交', '关闭']
            ,yes: function(){
              window.frames[0].document.getElementById("J_info_submit_btn").click();
            }
            ,btn2: function(){
              layer.closeAll();
            },
            end: function(){
              table.reload('idTest', {});
            }
          });
          break;
        case 'getCheckLength':
          break;
        case 'isAll':
          break;
      };
    });

    table.on('tool(J_list)', function(obj){
      var data = obj.data;
      if(obj.event === 'del'){
        layer.confirm('确定删除该论文著作吗', function(index){
          $.post('/thesis/del', {
            id: data.id
          }, function(args){
            if ('' ==args.result) {

            }
            obj.del();
            layer.close(index);
            layer.msg('删除成功', {
              icon : 1
            });
          });
        });
      } else if(obj.event === 'edit'){
        var index = layer.open({
          type: 2
          ,title: '修改论文著作'
          ,area: ['800px', '500px']
          ,shade: 0
          ,maxmin: true
          ,content: '/thesis/editPage?id=' + data.id
          ,btn: ['提交', '关闭']
          ,yes: function(){
            layer.closeAll();
            window.frames[0].document.getElementById("J_info_submit_btn").click();
          }
          ,btn2: function(){
            layer.closeAll();
          },
          end: function(){
            table.reload('idTest', {});
          }
        });
      } else if (obj.event === 'attachment') {
        // 附件上传
        layer.open({
          type: 2
          ,title: '附件上传'
          ,area: ['700px', '500px']
          ,shade: 0
          ,maxmin: true
          ,content: '/thesis/attachmentPage?fid=' + data.id
          ,btn: ['关闭']
          ,btn2: function(){
            layer.closeAll();
          },
          end: function(){
            table.reload('idTest', {});
          }
        });
      }
    });

    $('#J_edit_introduce').click(function(){
      $.post('/thesis/edit', {
        id: $('#J_introduce_id').val(),
        introduce: $('#J_introduce_content').val()
      }, function(result){
        if ('success' == result) {
          layer.msg('操作成功', {
            icon : 1
          });
          layer.closeAll();
        } else {
          layer.msg('操作失败', {
            icon : 2
          });
        }
      });
    });
  });

</script>
<script type="text/html" id="toolbar">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="addData">添加</button>
  </div>
</script>
<script type="text/html" id="bar">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="attachment">附件</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
</body>

</html>