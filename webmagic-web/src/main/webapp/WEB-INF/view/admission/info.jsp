<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
  <%@include file="../common/head.jsp"%>
  <link href="/css/admission/style.css?v=<%=new Date().getTime() %>" rel="stylesheet">
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
          <li><a href="/courseteach/page">课程教学</a></li>
          <li><a href="/dataCode/info">数据与代码</a></li>
          <li class="active"><a href="/admission/info">招生信息</a></li>
        </ul>
      </div>
    </div>
  </header>
  <div class="nav-panel nav-admission">
    <div class="nav-center">
      <div class="nav-title clearfix"><span class="label">一一</span><span>招生信息</span></div>
      <h2 class="nav-h2">Admission Information</h2>
      <span class="nav-span">
        <a href="">网站首页</a>
        <a class="dot"> > </a>
        <a href="">招生信息</a>
      </span>
    </div>
  </div>
  <div class="container admission-container top-margin">
    <div class="introduction">
      <p>
        2019年我校招收全日制与非全日制硕士研究生，欢迎符合报考条件的在职人员和应届本科毕业生报考。2019年我校招收全日制与非全日制硕士研究生，欢迎符合报考条件的在职人员和应届本科毕业生报考。
        2019年我校招收全日制与非全日制硕士研究生，欢迎符合报考条件的在职人员和应届本科毕业生报考。2019年我校招收全日制与非全日制硕士研究生，欢迎符合报考条件的在职人员和应届本科毕业生报考。
        本研究所鼓励或愿意指导的本科生科研活动如下：
        <ul>
          <li>大学生创新实验计划</li>
          <li>学院前方杯大赛</li>
          <li>属本研究所所研究方向的学术研究</li>
          <li>本研究所市级科研项目</li>
        </ul>
      </p>
    </div>
    <div class="admission-info">
      <c:forEach items="${list}" var="entity">
        <div class="info-panel">
          <h3>${entity.title}</h3>
          <div class="panel-body">
            ${entity.content}
          </div>
        </div>
      </c:forEach>
    </div>
    <div class="introduction">
      <h4 class="">附录：研究所介绍</h4>
      <p>
        北京交通大学网络科学与智能系统研究所(INSIS)具有众多的科研锻炼机会，一流的科研试验平台，
        和谐的人文氛围，良好的师生关系，丰富的产业界和学术界资源，多彩的体育和文化生活，更有国内一流的研究生资助体系，研究生培养质量在校内外具有很好的口碑，多年来本研究所
        已吸引众多出色的学生加入，形成了良性循环。
      </p>
    </div>
    <div class="appendix">

      <div class="info-panel">
        <h3>1) 大学生创新试验计划要求</h3>
        <div class="panel-body">
          本研究所每年最多接到三个项目的指导请求。项目组队要求及目标包括：
          <ul>
            <li>要求主要曾元大二以上，每组人数不超过3人；</li>
            <li>队员要求有科研热情，学习成绩优良，外语好，具有较强的阅读科技文献能力；</li>
            <li>研究内容需符合本研究所方向；</li>
            <li>要求主要曾元大二以上，每组人数不超过3人；</li>
            <li>队员要求有科研热情，学习成绩优良，外语好，具有较强的阅读科技文献能力；</li>
            <li>研究内容需符合本研究所方向；</li>
          </ul>
        </div>
      </div>
      <div class="info-panel">
        <h3>2) 大学生创新试验计划要求</h3>
        <div class="panel-body">
          本研究所每年最多接到三个项目的指导请求。项目组队要求及目标包括：
          <ul>
            <li>要求主要曾元大二以上，每组人数不超过3人；</li>
            <li>队员要求有科研热情，学习成绩优良，外语好，具有较强的阅读科技文献能力；</li>
            <li>研究内容需符合本研究所方向；</li>
            <li>要求主要曾元大二以上，每组人数不超过3人；</li>
            <li>队员要求有科研热情，学习成绩优良，外语好，具有较强的阅读科技文献能力；</li>
            <li>研究内容需符合本研究所方向；</li>
          </ul>
        </div>
      </div>
      <div class="info-panel">
        <h3>3) 大学生创新试验计划要求</h3>
        <div class="panel-body">
          本研究所每年最多接到三个项目的指导请求。项目组队要求及目标包括：
          <ul>
            <li>要求主要曾元大二以上，每组人数不超过3人；</li>
            <li>队员要求有科研热情，学习成绩优良，外语好，具有较强的阅读科技文献能力；</li>
            <li>研究内容需符合本研究所方向；</li>
            <li>要求主要曾元大二以上，每组人数不超过3人；</li>
            <li>队员要求有科研热情，学习成绩优良，外语好，具有较强的阅读科技文献能力；</li>
            <li>研究内容需符合本研究所方向；</li>
          </ul>
        </div>
      </div>
      <div class="info-panel">
        <h3>4) 大学生创新试验计划要求</h3>
        <div class="panel-body">
          本研究所每年最多接到三个项目的指导请求。项目组队要求及目标包括：
          <ul>
            <li>要求主要曾元大二以上，每组人数不超过3人；</li>
            <li>队员要求有科研热情，学习成绩优良，外语好，具有较强的阅读科技文献能力；</li>
            <li>研究内容需符合本研究所方向；</li>
            <li>要求主要曾元大二以上，每组人数不超过3人；</li>
            <li>队员要求有科研热情，学习成绩优良，外语好，具有较强的阅读科技文献能力；</li>
            <li>研究内容需符合本研究所方向；</li>
          </ul>
        </div>
      </div>
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