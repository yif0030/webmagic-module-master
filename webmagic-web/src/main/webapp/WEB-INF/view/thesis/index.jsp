<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
  <%@include file="../common/head.jsp"%>
  <link href="/css/thesis/style.css?v=<%=new Date().getTime() %>" rel="stylesheet">
</head>
<body>
  <header class="top-header">
    <div class="h-center container">
      <div class="h-logo">
        <img class="logo" src="/images/logo.png">
      </div>
      <div class="h-nav">
        <ul id="J_header_nav" class="clearfix">
          <li><a href="/home/index">网站首页</a></li>
          <li><a href="/team/member/list">团队成员</a></li>
          <li><a href="/research/direction">研究方向</a></li>
          <li class="active"><a href="/thesis/index">论文著作</a></li>
          <li><a href="/project/page">科研项目</a></li>
          <li><a href="/news/info">新闻资讯</a></li>
          <li><a href="/courseteach/page">课程教学</a></li>
          <li><a href="/dataCode/info">数据与代码</a></li>
          <li><a href="/admission/info">招生信息</a></li>
        </ul>
      </div>
    </div>
  </header>
  <div class="nav-panel nav-thesis">
    <div class="nav-center">
      <div class="nav-title clearfix"><span class="label">一一</span><span>论文著作</span></div>
      <h2 class="nav-h2">Thesis</h2>
      <span class="nav-span">
        <a href="">网站首页</a>
        <a class="dot"> > </a>
        <a href="">论文著作</a>
      </span>
    </div>
  </div>
  <div class="container thesis-container top-margin">
    <div class="condition">
      <div class="c-row">
        <span class="name">年份：</span>
        <ul id="J_condition_year" class="clearfix">
          <li class="active">2018</li>
          <li>2017</li>
          <li>2016</li>
          <li>2015</li>
          <li>2014</li>
          <li>2013</li>
          <li>2012</li>
          <li>2011</li>
          <li>2010</li>
          <li>2009</li>
          <li>2008</li>
          <li>2007</li>
          <li>2006</li>
          <li>2005</li>
          <li>2004</li>
          <li>2003</li>
          <li>2002</li>
          <li>2001</li>
          <li>2000</li>
        </ul>
      </div>
      <div class="c-row">
        <span class="name">类型：</span>
        <ul id="J_condition_type" class="clearfix">
          <li class="active">会议</li>
          <li>期刊</li>
        </ul>
      </div>
    </div>
    <div class="thesis-list">
      <c:forEach items="${list}" var="item">
        <ul>
          <li>
            ${item.title}
            <c:forEach items="${item.attachmentList}" var="attachment">
              <span class="oper">[<a target="_blank" href="/download?path=${SYSCONFIG.fileSavePosition}${attachment.path}">${attachment.fileName}</a>]</span>
            </c:forEach>
          </li>
        </ul>
      </c:forEach>
    </div>
  </div>
  <jsp:include page="../common/footer.jsp" />
  <script>
    $(function(){
      var $typeLi = $('#J_condition_type li');
      $typeLi.click(function(){
        $typeLi.removeClass('active');
        $(this).addClass('active');
      });
      var $yearLi = $('#J_condition_year li');
      $yearLi.click(function(){
        $yearLi.removeClass('active');
        $(this).addClass('active');
      });
    });
  </script>
</body>
</html>