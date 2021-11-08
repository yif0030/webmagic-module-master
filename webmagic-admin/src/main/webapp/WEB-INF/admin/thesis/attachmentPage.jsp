<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <%@ include file="../common/header.jsp" %>
  <style rel="stylesheet">
    body{
      padding: 20px;
      -webkit-box-sizing: border-box;
      -moz-box-sizing: border-box;
      box-sizing: border-box;
    }
  </style>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  <legend>附件上传列表</legend>
</fieldset>

<div class="layui-upload">
  <button type="button" class="layui-btn layui-btn-normal" id="testList">选择多文件</button>
  <div class="layui-upload-list">
    <table class="layui-table">
      <thead>
        <tr>
          <th>文件名</th>
          <th>大小</th>
          <th>状态</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody id="demoList">
        <c:forEach items="${attachmentList}" var="attachment">
          <tr>
            <td>${attachment.fileName}</td>
            <td>${Double.parseDouble(String.format("%.2f", attachment.fileSize/1000))}kb</td>
            <td>已上传</td>
            <td>
              <button class="layui-btn layui-btn-xs demo-reload layui-hide">重传</button>
              <button class="layui-btn layui-btn-xs layui-btn-danger demo-delete" data-id="${attachment.id}">删除</button>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
  <button type="button" class="layui-btn" id="testListAction">开始上传</button>
</div>
<script>
  layui.use('upload', function(){
    var $ = layui.jquery
      ,upload = layui.upload;
    var files = null;
    var demoListView = $('#demoList')
      ,uploadListIns = upload.render({
      elem: '#testList'
      ,url: '/thesis/uploads'
      ,accept: 'file'
      ,multiple: true
      ,auto: false
      ,field: 'files'
      ,data: {
        thesisId: '${thesisId}'
      }
      ,bindAction: '#testListAction'
      ,choose: function(obj){
        files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
        //读取本地文件
        obj.preview(function(index, file, result){
          var tr = $(['<tr id="upload-'+ index +'">'
            ,'<td>'+ file.name +'</td>'
            ,'<td>'+ (file.size/1014).toFixed(1) +'kb</td>'
            ,'<td>等待上传</td>'
            ,'<td>'
            ,'<button class="layui-btn layui-btn-xs demo-reload layui-hide">重传</button>'
            ,'<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>'
            ,'</td>'
            ,'</tr>'].join(''));

          //单个重传
          tr.find('.demo-reload').on('click', function(){
            obj.upload(index, file);
          });

          //删除
          tr.find('.demo-delete').on('click', function(){
            delete files[index]; //删除对应的文件
            tr.remove();
            uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
          });

          demoListView.append(tr);
        });
      }
      ,done: function(res, index, upload){

        if('success' == res.result){ //上传成功
          var tr = demoListView.find('tr#upload-'+ index)
            ,tds = tr.children();
          tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
          tds.eq(3).html(''); //清空操作
          return delete this.files[index]; //删除文件队列已经上传成功的文件
        }
      }
      ,error: function(index, upload){
        var tr = demoListView.find('tr#upload-'+ index)
          ,tds = tr.children();
        tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
        tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
      }
    });

    $('#demoList').delegate('.demo-delete', 'click', function(){
      var that = this;
      layer.confirm('确定要删除该附件文件吗', function(index){
        console.info($(that).data('id'));
        $.get('/thesis/delAttachment', {
          attachmentId: $(that).data('id')
        }, function (args) {
          if ('success' == args) {
            $(that).closest('tr').remove();
            uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
            layer.msg('操作成功', {
              icon : 1
            });
          } else {
            layer.msg('操作失败', {
              icon : 2
            });
          }

        });
      });


    });

  });

</script>
</body>
</html>