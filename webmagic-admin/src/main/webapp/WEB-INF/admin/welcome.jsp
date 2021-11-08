<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <%@ include file="./common/header.jsp" %>
  <script>
    var t = null;
    t = setTimeout(time,1000);//开始执行
    function time()
    {
      clearTimeout(t);//清除定时器
      dt = new Date();
      var y=dt.getFullYear();
      var M=dt.getMonth()+1 < 10 ? '0'+dt.getMonth()+1: dt.getMonth()+1;
      var d=dt.getDate() < 10 ? '0'+dt.getDate(): dt.getDate();
      var h=dt.getHours() < 10 ? '0'+dt.getHours(): dt.getHours();//获取时
      var m=dt.getMinutes() < 10 ?'0'+dt.getMinutes() : dt.getMinutes();//获取分
      var s=dt.getSeconds()< 10 ? '0'+dt.getSeconds(): dt.getSeconds();//获取秒
      document.getElementById("showTime").innerHTML =  "当前时间:"+y+"-"+M+"-"+d+" "+h+":"+m+":"+s;
      t = setTimeout(time,1000); //设定定时器，循环执行
    }
  </script>
</head>
<body>
  <div class="x-body layui-anim layui-anim-up">
    <blockquote class="layui-elem-quote">
      欢迎管理员： <span class="x-red">admin</span>！<span id="showTime"></span>
    </blockquote>
    <fieldset class="layui-elem-field">
      <legend>数据统计</legend>
      <div class="layui-field-box">
        <div class="layui-col-md12">
          <div class="layui-card">
            <div class="layui-card-body">
              <div class="layui-carousel x-admin-carousel x-admin-backlog" lay-anim="" lay-indicator="inside" lay-arrow="none"
                style="width: 100%; height: 90px;">
                <div carousel-item="">
                  <ul class="layui-row layui-col-space10 layui-this">
                    <li class="layui-col-xs2"><a href="javascript:;" class="x-admin-backlog-body">
                        <h3>新闻动态</h3>
                        <p>
                          <cite>${infoCount}</cite>
                        </p>
                    </a></li>
                    <li class="layui-col-xs2"><a href="javascript:;" class="x-admin-backlog-body">
                        <h3>成员数</h3>
                        <p>
                          <cite>${memberCount}</cite>
                        </p>
                    </a></li>
                    <li class="layui-col-xs2"><a href="javascript:;" class="x-admin-backlog-body">
                        <h3>访问量</h3>
                        <p>
                          <cite>${visitCount}</cite>
                        </p>
                    </a></li>
                    <li class="layui-col-xs2"><a href="javascript:;" class="x-admin-backlog-body">
                        <h3>论文数</h3>
                        <p>
                          <cite>${thesisCount}</cite>
                        </p>
                    </a></li>
                    <li class="layui-col-xs2"><a href="javascript:;" class="x-admin-backlog-body">
                        <h3>数据与代码</h3>
                        <p>
                          <cite>${dataCount}</cite>
                        </p>
                    </a></li>
                    <li class="layui-col-xs2"><a href="javascript:;" class="x-admin-backlog-body">
                        <h3>科研项目</h3>
                        <p>
                          <cite>${srpCount}</cite>
                        </p>
                    </a></li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </fieldset>
    <fieldset class="layui-elem-field">
      <legend>系统通知</legend>
      <div class="layui-field-box">
        <table class="layui-table" lay-skin="line">
          <tbody>
            <tr>
              <td><a class="x-a" href="javascript:;" target="_blank">更多功能正在开发中</a></td>
            </tr>
            <tr>
              <td><a class="x-a" href="javascript:;" target="_blank">技术负责QQ:(835317619)</a></td>
            </tr>
          </tbody>
        </table>
      </div>
    </fieldset>
    <%--<fieldset class="layui-elem-field">
      <legend>系统信息</legend>
      <div class="layui-field-box">
        <table class="layui-table">
          <tbody>
            <tr>
              <th>网站版本</th>
              <td>1.1.0</td>
            </tr>
            <tr>
              <th>服务器地址</th>
              <td>webmagic.jinyingfei.com</td>
            </tr>
            <tr>
              <th>操作系统</th>
              <td>Linux CentOS 7.4</td>
            </tr>
            <tr>
              <th>运行环境</th>
              <td>Nginx-1.12.4</td>
            </tr>
            <tr>
              <th>Java版本</th>
              <td>1.8</td>
            </tr>
            <tr>
              <th>MYSQL版本</th>
              <td>5.7.54</td>
            </tr>
          </tbody>
        </table>
      </div>
    </fieldset>--%>
    <fieldset class="layui-elem-field">
      <legend>开发团队</legend>
      <div class="layui-field-box">
        <table class="layui-table">
          <tbody>
            <tr>
              <th>海城华飞科技有限公司</th>
              <td>邮箱(835317619@qq.com)</td>
            </tr>
          </tbody>
        </table>
      </div>
    </fieldset>
    <blockquote class="layui-elem-quote layui-quote-nm">感谢您对本公司的信任与支持，网站由海城华飞科技有限公司提供技术支持。有任何问题和意见，请随时联系我们。邮箱：835317619@qq.com</blockquote>
  </div>
</body>