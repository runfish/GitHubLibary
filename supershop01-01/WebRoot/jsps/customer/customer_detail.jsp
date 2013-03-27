<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>用户基本信息</title>
    
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
	
  function $(id)
  {
  	 return document.getElementById(id);
  }
  
  //却换用户界面编辑模式
  function toChangeMenu(type)
  {
  	if(type=="update")
  	{
  		$("show").style.display="none";
  		$("update").style.display="block";
  	}
  	else if(type=="topup"){
  	    $("show").style.display="none";
  		$("topup").style.display="block";
  	}
  	
  	else if(type=="changepwd")
  	{
  		$("show").style.display="none";
  		$("changepwd").style.display="block";
  	}
  }
  //校验用户数据并提交用户修改数据的信息
  function submitMsg()
  {
     var form = document.forms[0];
     form.action;
     form.submit();
  }
  //检验用户数据并提交用户修改密码的信息
  function changePwd()
  {
     if($("old_pwd").value == "")
     {
     	alert("帐号的旧密码不能为空，请输入帐号密码!");
    	return ;
     }
     if(!($("new_pwd1").value.match("^[a-zA-Z]+[0-9]+.*$")&&$("new_pwd1").value.length>=6))
     {
    	   alert("请输入以字母开头的6位以上的新密码，且至少包含数字和字母两种组合！");
    	   return ;
     }
     
    if($("new_pwd2").value == "")
    {
    	  alert("密码确认不能为空，请输入确认密码!");
    	  return ;
    }
    else if($("new_pwd2").value != $("new_pwd1").value)
    {
    	  alert("确认密码与新密码不相同请重新输入!");
    	  return ;
    }
     var form = document.forms[1];
     form.action;
     form.submit();
  }
  
  function changeAccount(password){
    
     if($("rechange_amount").value==""){
        alert('充值金额不能为空,请重新输入!');
        return;     
     }
     
     if(isNaN($("rechange_amount").value)||($("rechange_amount").value<0)){
     
        alert('充值金额必须为大于0的数字,请确认后重新输入!');
        return;
     
     }
     
     if($("paypass").value==""){
     
         alert('支付密码不能为空,请重新输入!');
         
         return ;
     
     }
       if(($("paypass").value)!=password){
          alert('支付密码错误 请重新输入');
          return ;
     }
     
    
     
     var form = document.forms[2];
     form.action;
     form.submit();

  }
  
  
  
  
 
 //进入会员中心
    function gotoMember(object)
    {
       object.target='_top';
       object.href='<c:url value="/action/customerMgr?act=gomember"/>';
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
    <div style=""><span><h3>用户基本信息</h3></span></div>
      <div style="border-bottom:1px solid gray;height:40px;font-size:20;">
      	<span>用户名 ：</span><span>${customer.customerName }</span>
      </div>
      <div style="border-bottom:1px solid gray;height:40px;font-size:20;">
      	<span>您的账户余额：</span><span>${customer.customerAccount}元</span>
      </div>
      <div style="border-bottom:1px solid gray;height:40px;font-size:20;">
      	<span>会员 ：</span>
      	<c:if test="${customer.isMember==0}"><span style="color:red;">${customer.customerName }还不是会员</span></c:if>
      	<c:if test="${customer.isMember==1}"><span><a onclick="gotoMember(this);" href="#" style="cursor:hand;text-decoration:none;" title="点击进入会员中心">尊敬的会员${customer.customerName}欢迎您</a></span></c:if>
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
      	<span><a onclick="toChangeMenu('update');" href="#" style="cursor:hand;text-decoration:none;font-weight:bold" title="点击修改用户信息">用户基本信息修改</a></span>
      	<span><a onclick="toChangeMenu('changepwd');" href="#" style="cursor:hand;text-decoration:none;font-weight:bold" title="点击修改用户密码">用户密码修改</a></span>
      	<span><a onclick="toChangeMenu('topup');" href="#" style="cursor:hand;text-decoration:none;font-weight:bold" title="点击用户在线充值">用户在线充值</a></span>
      </div>
    </div>
    
  <!-- 用户信息显示区结束 -->
  
  <!-- 用户基本信息修改区开始 -->
  
  <div id="update" style="text-align:center;width:50%;background:LemonChiffon;display:none;">
  <form action="<c:url value="/action/customerMgr?act=update"/>" method="post">
  <input type="hidden" name="customer_name" value="${customer.customerName }">
  <input type="hidden" name="customer_account" value="0">
    <div style=""><span style="font-weight:bold">用户基本信息修改</span></div>
      <div style="border-bottom:1px solid gray;height:40px;font-size:20;">
      	<span>用户名 ：</span><span>${customer.customerName }</span>
      </div>
      <div style="border-bottom:1px solid gray;height:40px;font-size:20;">
      	<span>会员 ：</span>
      	<c:if test="${customer.isMember==0}"><span style="color:red;">${customer.customerName }还不是会员</span></c:if>
      	<c:if test="${customer.isMember==1}"><span><a onclick="gotoMember(this);" href="#" style="cursor:hand;text-decoration:none;" title="点击进入会员中心">尊敬的会员${customer.customerName}欢迎您</a></span></c:if>
      </div>
      <div style="border-bottom:1px solid gray;height:40px;font-size:20;">
      	<span>真实姓名 ：</span>
      	<span><input name="real_name" type="text" value="${customer.customerRealname }"/></span>
      </div>
      <div style="border-bottom:1px solid gray;height:40px;font-size:20;">
      <span>出生日期 ：</span>
      	<span><input style="cursor:hand" type="text" id="calendar" class="calendar_input" readonly="readonly" name="birthday" value="${customer.customerBirthday}"/></span>
		  <script type="text/javascript" src="<c:url value="/js/date.js"/>" charset="gbk"></script>
      </div>
      <div style="border-bottom:1px solid gray;height:40px;font-size:20;">
      	<span>家庭住址 ：</span>
      	<span><input name="home_address" type="text" value="${customer.customerAddress }"/></span>
      </div>
      <div style="border-bottom:1px solid gray;height:40px;font-size:20;">
      	<span>邮政编码 ：</span>
      	<span><input name="post_code" type="text" value="${customer.customerPostCode }"/></span>
      </div>
      <div style="border-bottom:1px solid gray;height:40px;font-size:20;">
      	<span>联系方式 ：</span>
      	<span><input name="telephone" type="text" value="${customer.customerTel }"/></span>
      </div>
      <div style="border-bottom:1px solid gray;height:40px;font-size:20;">
      	<span>电子邮箱 ：</span>
      	<span><input name="email" type="text" value="${customer.customerMail }"/></span>
      </div>
      <div style="border-bottom:1px solid gray;height:40px;font-size:20;">
      	<span><a onclick="submitMsg();" href="#" style="cursor:hand;text-decoration:none;font-weight:bold;" title="点击保存用户信息">保存用户信息</a></span>
      </div>
    </form>
    </div>
  <!-- 用户基本信息修改区结束 -->
  
  <!-- 用户密码修改区开始 -->
  <div id="changepwd" style="text-align:center;width:50%;background:LemonChiffon;display:none;">
  <div style=""><span style="font-weight:bold">用户密码修改</span></div>
       <div style="border-bottom:1px solid gray;height:40px;font-size:20;">
      	<span>用户名 ：</span><span>${customer.customerName }</span>
      </div>
      <form action="<c:url value="/action/customerMgr?act=update"/>" method="post">
      <input type="hidden" name="customer_name" value="${customer.customerName }">
      <input type="hidden" name="customer_account" value="0">
      <div style="border-bottom:1px solid gray;height:40px;font-size:20;">
      	<span style="margin-right:22px;">旧密码 ：</span><span><input type="password" id="old_pwd" name="old_pwd" value=""></span>
      </div>
      <div style="border-bottom:1px solid gray;height:40px;font-size:20;">
      	<span style="margin-right:22px;">新密码 ：</span><span><input type="password" id="new_pwd1" name="new_pwd1" value=""></span>
      </div>
      <div style="border-bottom:1px solid gray;height:40px;font-size:20;">
      	<span>确认新密码 ：</span><span><input type="password" id="new_pwd2" name="new_pwd2" value=""></span>
      </div>
      <div style="border-bottom:1px solid gray;height:40px;font-size:20;">
      	<span><a onclick="changePwd();" href="#" style="cursor:hand;text-decoration:none;font-weight:bold;" title="点击确认提交用户新密码">保存修改</a></span>
      </div>
    </form>
  </div>
   <!-- 用户密码修改结束 -->
   
   
   <!-- 用户充值在线开始 -->
  <div id="topup" style="text-align:center;width:50%;background:LemonChiffon;display:none;">
  <div style=""><span style="font-weight:bold">用户在线充值</span></div>
       <div style="border-bottom:1px solid gray;height:40px;font-size:20;">
      	<span>用户名 ：</span><span>${customer.customerName}</span>
      </div>
      <form action="<c:url value="/action/customerMgr?act=update"/>" method="post">
      <input type="hidden" name="customer_name" value="${customer.customerName }">
      <div style="border-bottom:1px solid gray;height:40px;font-size:20;">
      	<span style="margin-right:22px;">请输入要充值金额：</span><span><input type="text" id="rechange_amount" name="customer_account" value=""></span>
      </div>
      <div style="border-bottom:1px solid gray;height:40px;font-size:20;">
      	<span style="margin-right:22px;">请输入支付密码 ：</span><span><input type="password" id="paypass" name="new_pwd1"></span>
      </div>
      <div style="border-bottom:1px solid gray;height:40px;font-size:20;">
      	<span><a onclick="changeAccount('${customer.customerPassword}');" href="#" style="cursor:hand;text-decoration:none;font-weight:bold;" title="点击确认充值">确认充值</a></span>
      </div>
    </form>
  </div>
   <!-- 用户密码修改结束 -->
   
   
  
 <div style="text-align:center;width:50%;background:NavajoWhite;">
  	<br><br><br><br><br><br><br><br><br><br>
  </div>
  <c:if test="${not empty error}">
	       <script type="text/javascript">
	         alert('${error}');
	       </script>
  </c:if> 
  </body>
</html>
