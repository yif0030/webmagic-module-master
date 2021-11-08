<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <%@ include file="../common/header.jsp" %>
  <link href="/css/admin/style.css" rel="stylesheet">
  <style rel="stylesheet">
    #J_image_carousel .layui-this>img {
      width:100%;height:100%;
    }
  </style>
</head>
<body>
  <div class="x-nav">
    <span class="layui-breadcrumb">
      <a href="">模块管理</a>
      <a href="">网站首页</a>
      <a><cite>轮播图管理</cite></a>
    </span>
    <a class="layui-btn layui-btn-small" style="line-height: 1.6em; margin-top: 3px; float: right" href="javascript:location.replace(location.href);" title="刷新">
      <i class="layui-icon layui-icon-refresh" style="line-height: 38px"></i>
    </a>
  </div>
  <div class="x-body">
    <blockquote class="layui-elem-quote">
      请在此选择多文件上传
    </blockquote>
      <div class="layui-upload">
        <button type="button" class="layui-btn layui-btn-normal" id="J_add_image">选择多文件</button>
        <div class="layui-upload-list">
          <table class="layui-table">
            <thead>
              <tr>
                <th>缩略图</th>
                <th>操作</th>
              </tr>
            </thead>
            <tbody id="J_image_list">
              <c:forEach items="${list}" var="img">
                <tr id="upload-${img.id}">
                  <td class="img-td"><img src="${sysConfig.webUrl}${img.filePath}" style="max-width:800px;" /></td>
                  <td>
                    <button class="layui-btn layui-btn-xs layui-btn-danger demo-delete" onclick="imgDel(this, ${img.id})">删除</button>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
        <button type="button" class="layui-btn" id="J_upload_image_action">开始上传</button>
      </div>
  </div>
  <script>
    layui.use(['upload', 'carousel'], function() {
      var $ = layui.jquery,
        upload = layui.upload;

      //多文件列表示例
      var imageListView = $('#J_image_list')
        ,uploadListIns = upload.render({
        elem: '#J_add_image'
        ,url: '/homepage/swiper/update'
        ,accept: 'file'
        ,acceptMime: 'image/jpg, image/png'
        ,multiple: true
        ,auto: false
        ,bindAction: '#J_upload_image_action'
        ,before: function(obj){
          console.info(obj)
          if (obj) {
          }
        }
        ,choose: function(obj){
          var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
          //读取本地文件
          obj.preview(function(index, file, result){
            var tr = $(['<tr id="upload-'+ index +'">'
              ,'<td class="img-td"><img src="'+ result +'" style="max-width:800px;" /></td>'
              ,'<td>'
              ,'<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete" type="button" onclick="imgDel('+ this +', "")">删除</button>'
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
            imageListView.prepend(tr);
          });
        }
        ,done: function(res, index, upload){
          if("success" == res.result){ //上传成功
            layer.msg('上传成功', {
              icon : 1
            });
            var tr = imageListView.find('tr#upload-'+ index)
              ,tds = tr.children();
            tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
            tds.eq(3).html(''); //清空操作
            return delete this.files[index]; //删除文件队列已经上传成功的文件
          }
        }
        ,error: function(index, upload){
          var tr = imageListView.find('tr#upload-'+ index)
            ,tds = tr.children();
          tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
          tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
        }
      });

    });

    function imgDel(obj, id) {
      if (id) {
        $('#upload-' + id).remove();
        $.ajax({
          url: 'swiper/del',
          data: {
            id: id
          },
          success: function(args){
            if ("success" == args) {
              //发异步删除数据
              $(obj).parents("tr").remove();
              layer.msg('操作成功', {
                icon : 1
              });
            }
          },
          error: function (args) {
            console.info(args)
          }
        })
      } else {
        layer.msg('操作失败', {
          icon : 5
        });
      }
    }
  </script>
</body>

</html>