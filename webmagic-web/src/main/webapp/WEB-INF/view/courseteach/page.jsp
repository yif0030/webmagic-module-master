<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
  <%@include file="../common/head.jsp"%>
  <link href="/css/teach/style.css?v=<%=new Date().getTime() %>" rel="stylesheet">
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
          <li><a href="/thesis/index">论文著作</a></li>
          <li><a href="/project/page">科研项目</a></li>
          <li><a href="/news/info">新闻资讯</a></li>
          <li class="active"><a href="/courseteach/page">课程教学</a></li>
          <li><a href="/dataCode/info">数据与代码</a></li>
          <li><a href="/admission/info">招生信息</a></li>
        </ul>
      </div>
    </div>
  </header>
  <div class="nav-panel nav-courseTeaching">
    <div class="nav-center">
      <div class="nav-title clearfix"><span class="label">一一</span><span>课程教学</span></div>
      <h2 class="nav-h2">Course</h2>
      <span class="nav-span">
        <a href="">网站首页</a>
        <a class="dot"> > </a>
        <a href="">课程教学</a>
      </span>
    </div>
  </div>
  <div class="container course-container top-margin">
    <c:forEach items="${list}" var="entity">
      <div class="course-panel">
        <header>${entity.title}</header>
        <div class="panel-body">
          <p>${entity.content}</p>
        </div>
      </div>
    </c:forEach>
  </div>
  <jsp:include page="../common/footer.jsp" />
  <script>
    $(function(){
        $('img').on('mousedown',function (e) {
            e.preventDefault();
        });
    });
  </script>
</body>
</html>