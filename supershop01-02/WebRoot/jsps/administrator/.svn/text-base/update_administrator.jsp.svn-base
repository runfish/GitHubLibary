<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>普通管理员信息修改</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="<c:url value="/js/admin.js"/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/application.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/form.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/date.css"/>">

    <style>
	   #oldpic{
	     position:absolute;
	     right:30px;
	     top:40px;
	   }
	 </style>
	
  </head>
  
 <body>
    <div id="wrapper">
	    <div id="f_title">管理员：[${administrator.administratorName}]信息修改</div>
	    <form action="<c:url value="/action/adminMgr"/>" method="post" onsubmit="return validate(this);">
	        <input type="hidden" name="act" value="update"/>
	        <input type="hidden" name="administratorid" value="${administrator.administratorId}"/>
	        <input type="hidden" name="superadminid" value="${administrator.isSuperAdministrator}"/>
	 
	        <div class="f_row">
	          <span>管理员ID:</span>
	          <span>${administrator.administratorId}</span>
	        </div>	    
	        <div class="f_row">
	          <span>管理员用户名:</span>
	          <input type="text" name="administratorname" size="20" value="${administrator.administratorName}"/>
	        </div>
	        <div class="f_row">
	          <span>管理密码:</span>
	          <input type="password" name="administratorpassword"  size="20" value="${administrator.administratorPassword}"/>
	        </div>
	        <div class="f_row">
	          <span>管理员真实姓名:</span>
	          <input type="text" name="administratorrealname"  size="20" value="${administrator.realName}"/>        
	        </div>
	        <div class="f_row">
		       <span>管理员生日:</span>
		       <span><input style="cursor:hand" type="text" id="calendar" class="calendar_input" readonly="readonly" name="administratorbirthday" value="${administrator.birthday}"/></span>
				  <script type="text/javascript" src="<c:url value="/js/date.js"/>" charset="gbk"></script> 
    	    </div>
	        <div class="f_row">
	          <span>管理员邮箱:</span>
	          <input type="text" name="administratoremail"  size="20" value="${administrator.email}"/>        
	        </div>
	        <div class="f_row">
	          <span>管理员联系方式:</span>
	          <input type="text" name="administratortelnum"  size="20" value="${administrator.telNum}"/>        
	        </div>
	        <div class="f_row">
	          <span>家庭住址:</span>
	          <input type="text" name="administratoraddress"  size="20" value="${administrator.address}"/>        
	        </div>
	        <div class="f_row">
	          <span>邮政编码:</span>
	          <input type="text" name="administratorpostcode"  size="20" value="${administrator.postCode}"/>        
	        </div>
	        
	        <div class="f_row">
	          <input type="submit" value="信息修改"/>      
	        </div>                        
	    </form>
    </div>
  </body>
</html>
