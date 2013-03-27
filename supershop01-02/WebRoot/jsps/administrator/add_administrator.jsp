<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员信息录入</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<c:url value="/js/admin.js"/>"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/date.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/form3.css"/>">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
  
  
  
  
  
  <body>
    <h3>普通管理员信息录入</h3>
    <form action="<c:url value="/action/adminMgr?act=create"/>"  method="post" onsubmit="return validate(this);" >
    
    <fieldset>
    <legend class="f1">请填写管理员的信息</legend>
     <div class="f_row">
       <span>管理员用户名:</span>
       <input type="text" name="administratorname" value="${param.administratorname}"/>
    </div>
    
    <div class="f_row">
       <span>管理员密码:</span>
       <input type="text" name="administratorpassword" value="${param.administratorpassword }"/>
    </div>
    
    <div class="f_row" style="margin-top:20px;">
       <span>管理员姓名:</span>
       <input type="text" name="administratorrealname" value="${param.administratorrealname}"/>
    </div>
    <div class="f_row" style="margin-top:20px;">
       <span>出生日期:</span>
       <span><input style="cursor:hand;" type="text" id="calendar" class="calendar_input" readonly="readonly" name="administratorbirthday" value="${param.administratorbirthday}"/></span>
		  <script type="text/javascript" src="<c:url value="/js/date.js"/>" charset="gbk"></script> 
    </div>
    <div class="f_row" style="margin-top:20px;">
       <span>联系方式:</span>
       <input type="text" name="administratortelnum" value="${param.administratortelnum}"/>
    </div>
    <div class="f_row" style="margin-top:20px;">
       <span>家庭住址:</span>
       <input type="text" name="administratoraddress" value="${param.administratoraddress }"/>
    </div>
    <div class="f_row" style="margin-top:20px;">
       <span>QQ邮箱:</span>
       <input type="text" name="administratoremail" value="${param.administratoremail}"/>
    </div>
    <div class="f_row" style="margin-top:20px;">
       <span>邮政编码:</span>
       <input type="text" name="administratorpostcode" value="${param.administratorpostcode }"/>
    </div>    
    <div class="result" style="text-align:center;">
       <input type="submit" value="登  记"/>
       <input type="reset" value="重   置"/> 
     </div>
     </fieldset>
    </form>
  </body>
</html>
