<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
  <%@include file="../common/head.jsp"%>
  <link href="/css/project/style.css?v=<%=new Date().getTime() %>" rel="stylesheet">
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
          <li class="active"><a href="/project/page">科研项目</a></li>
          <li><a href="/news/info">新闻资讯</a></li>
          <li><a href="/courseteach/page">课程教学</a></li>
          <li><a href="/dataCode/info">数据与代码</a></li>
          <li><a href="/admission/info">招生信息</a></li>
        </ul>
      </div>
    </div>
  </header>
  <div class="nav-panel nav-project">
    <div class="nav-center">
      <div class="nav-title clearfix"><span class="label">一一</span><span>科研项目</span></div>
      <h2 class="nav-h2">Research Project</h2>
      <span class="nav-span">
        <a href="">网站首页</a>
        <a class="dot"> > </a>
        <a href="">科研项目</a>
      </span>
    </div>
  </div>
  <div class="container project-container top-margin">
    <div class="level-module">
      <header>省级</header>
      <div class="project-list clearfix">
        <c:forEach items="${province}" var="entity">
          <div class="project-panel">
            <div class="p-title">${entity.title}</div>
            <p class="intro">${entity.content}</p>
            <div class="time">
              <span><fmt:formatDate value="${entity.fromTime}" type="date" pattern="yyyy/MM/dd"/></span>
              <span>-</span>
              <span><fmt:formatDate value="${entity.toTime}" type="date" pattern="yyyy/MM/dd"/></span>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>
    <div class="level-module">
      <header>市级</header>
      <div class="project-list clearfix">
        <c:forEach items="${city}" var="entity">
          <div class="project-panel">
            <div class="p-title">${entity.title}</div>
            <p class="intro">${entity.content}</p>
            <div class="time">
              <span><fmt:formatDate value="${entity.fromTime}" type="date" pattern="yyyy/MM/dd"/></span>
              <span>-</span>
              <span><fmt:formatDate value="${entity.toTime}" type="date" pattern="yyyy/MM/dd"/></span>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>
    <div class="level-module">
      <header>校级</header>
      <div class="project-list clearfix">
        <c:forEach items="${school}" var="entity">
          <div class="project-panel">
            <div class="p-title">${entity.title}</div>
            <p class="intro">${entity.content}</p>
            <div class="time">
              <span><fmt:formatDate value="${entity.fromTime}" type="date" pattern="yyyy/MM/dd"/></span>
              <span>-</span>
              <span><fmt:formatDate value="${entity.toTime}" type="date" pattern="yyyy/MM/dd"/></span>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>
  </div>
  <div class="container co-enterprise top-margin">
    <header>
      <span>合作企业</span>
      <span>Cooperative Enterprise</span>
    </header>
    <div style="display: inline-block;">
      <table class="enterprise">
        <tbody>
        <tr>
          <td>
            <img src="/images/enterprise/1.png">
          </td>
          <td>
            <img src="/images/enterprise/2.png">
          </td>
          <td>
            <img src="/images/enterprise/3.png">
          </td>
          <td>
            <img src="/images/enterprise/4.png">
          </td>
          <td>
            <img src="/images/enterprise/5.png">
          </td>
          <td>
            <img src="/images/enterprise/6.png">
          </td>
          <td>
            <img src="/images/enterprise/7.png">
          </td>
          <td>
            <img src="/images/enterprise/8.png">
          </td>
        </tr>
        <tr>
          <td>
            <img src="/images/enterprise/1.png">
          </td>
          <td>
            <img src="/images/enterprise/2.png">
          </td>
          <td>
            <img src="/images/enterprise/3.png">
          </td>
          <td>
            <img src="/images/enterprise/4.png">
          </td>
          <td>
            <img src="/images/enterprise/5.png">
          </td>
          <td>
            <img src="/images/enterprise/6.png">
          </td>
          <td>
            <img src="/images/enterprise/7.png">
          </td>
          <td>
            <img src="/images/enterprise/8.png">
          </td>
        </tr>
        </tbody>
      </table>
    </div>
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