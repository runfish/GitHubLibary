<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>会员中心</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/application.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/list.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/form.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/passport.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/regist.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/date.css"/>">
	
	
    <script type="text/javascript" src="<c:url value="/js/common.js"/>"></script> 
    <script type="text/javascript" src="<c:url value="/js/prototype.js"/>"></script>
   <style>
    a:link {color:black} 
    a:hover {color:red;text-decoration:underline;} 
  </style>
 
   <script type="text/javascript">
 
   //显示用户信息
	function loginChange()
	{ 
	  var login=document.getElementById("login");
	   var userName="${sessionScope.customer.customerName}";
	   if(userName=="")
	   {  
	      login.innerHTML='<a href="<c:url value="/jsps/login/login.jsp"/>">[登录]</a>';
	   }
	   else
	   {  
	      login.innerHTML='<a href="<c:url value="/action/customerMgr?act=require&rand='+Math.random()+'"/>">'+userName+'</a>';
	   } 
	}
  //获取会员权限
  function getRight()
  {
  	alert("对不起会员权限暂时还未开放使用，敬请期待!谢谢");
  }
   </script>
  </head>
  
  <body style="text-align:center;background:Snow;" onload="loginChange();">
  
  <!-- 头部开始 -->
   <div id="shortcut" style="text-align:right;">
      <div class="w">
        <ul class="fr lh">
            <li class="fore1 ld" id="loginbar">您好，欢迎来到农大商城！<span id="login"><a href="/shop01/jsps/login/login.jsp">[登录]</a></span></li>
            <li class="fore2"><a href="/shop01/index.jsp" rel="nofollow">返回首页</a></li>
            <li class="fore2"><a href="" rel="nofollow">企业服务</a></li>
            <li class="fore2"><a href="" rel="nofollow">客户服务</a></li>
        </ul>
        <span class="clr"></span>
    </div>
  </div><!--shortcut end-->
  
  <!-- 头部结束 -->
  <div style="text-align:center;width:50%;background:NavajoWhite;">
  	<br><br><br><br><br><br>
  </div>
  <!-- 用户信息显示区开始 -->
    <div id="show" style="text-align:center;width:50%;background:LemonChiffon;">
    <div style=""><span><h3>会员信息</h3></span></div>
      <div style="border-bottom:1px solid gray;height:40px;font-size:20;">
      	<span>用户名 ：</span><span>${customer.customerName }</span>
      </div>
      <div style="border-bottom:1px solid gray;height:40px;font-size:20;color:red;">
      	<span>会员积分 ：</span>
      	<span>${customer.customerScore }</span>
      </div>
      <div style="border-bottom:1px solid gray;height:40px;font-size:20;color:red;">
      	<span>会员等级 ：</span>
      	<span>VIP<fmt:formatNumber type="number" value="${customer.customerScore/1000}" maxFractionDigits="0"/>.0</span>
      </div>
      <div style="border-bottom:1px solid gray;height:40px;font-size:20;">
      	<span>真实姓名 ：</span><span>${customer.customerRealname }</span>
      </div>
      <div style="border-bottom:1px solid gray;height:40px;font-size:20;">
      	<span>出生日期 ：</span><span>${customer.customerBirthday }</span>
      </div>
      <div style="border-bottom:1px solid gray;height:40px;font-size:20;">
      	<span>家庭住址 ：</span><span>${customer.customerAddress }</span>
      </div>
      <div style="border-bottom:1px solid gray;height:40px;font-size:20;">
      	<span>邮政编码 ：</span><span>${customer.customerPostCode }</span>
      </div>
      <div style="border-bottom:1px solid gray;height:40px;font-size:20;">
      	<span>联系方式 ：</span><span>${customer.customerTel }</span>
      </div>
      <div style="border-bottom:1px solid gray;height:40px;font-size:20;">
      	<span>电子邮箱 ：</span><span>${customer.customerMail }</span>
      </div>
      <div style="border-bottom:1px solid gray;height:40px;font-size:20;">
      	<span><a onclick="getRight();" href="#" style="cursor:hand;text-decoration:none;" title="点击查看会员特权"><h4>会员特权查看</h4></a></span>
      </div>
    </div>
    
  <!-- 用户信息显示区结束 -->
  
 <div style="text-align:center;width:50%;background:NavajoWhite;">
  	<br><br><br><br><br><br><br><br><br><br>
  </div>
  <c:if test="${not empty err}">
	       <script type="text/javascript">
	         alert('${err}');
	       </script>
  </c:if> 
  </body>
</html>
