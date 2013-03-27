<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<link href="<c:url value="/css/newcss/css.css"/>" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="jquery-1.8.3.min.js"></script>
    
    <script type="text/javascript">
       
      
       function validateEntry(loginFrm){
         
           with(loginFrm){
             
              if(username.value==""){
                 alert("用户帐号必须填写!");
                 userno.select();
                 return false;
              }
              
              if(userpwd.value==""){
                alert("登陆密码必须填写!");
                userpwd.select();
                return false;
              }
           }
           return true; 
       }
    //刷新验证码图片
    function changeImage(object)
    { 
       var parentNode=object.parentNode;
       
       parentNode.firstChild.src='<c:url value="/action/checkCode?rand="/>'+Math.random();
    }
   //清楚登入按钮点击后的虚线框
   function clearLine(object)
   {
      object.blur();
   }
   //重新访问登录界面
   function reVisit()
   { 
      location.href="<c:url value="/action/securityMgr?act=gotoLogin"/>";
   }
  </script>
  </head>
  
  <body>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="147" background="/shop02/pics/images/top02.gif"><img src="/shop02/pics/images/top03.gif" width="776" height="147" /></td>
  </tr>
</table>
<table width="562" border="0" align="center" cellpadding="0" cellspacing="0" class="right-table03">
  <tr>
    <td width="221"><table width="95%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
      
      <tr>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
          <tr>
            <td align="center"><img src="/shop02/pics/images/ico13.gif" width="107" height="97" /></td>
          </tr>
          <tr>
            <td height="40" align="center">&nbsp;</td>
          </tr>
          
        </table></td>
        <td><img src="/shop02/pics/images/line01.gif" width="5" height="292" /></td>
      </tr>
    </table>
    </td>
    <td>
    <form action="<c:url value="/action/securityMgr?act=login"/>" method="post" onsubmit="return validateEntry(this);">
	    <table width="100%" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td width="31%" height="35" class="login-text02">用户名称：<br /></td>
	        <td width="69%"><input type="text" name="username" value="${username==null?'hhg0012':username}"/></td>
	      </tr>
	      <tr>
	        <td height="35" class="login-text02">密　码：<br /></td>
	        <td><input type="password" name="userpwd" value="123456"/></td>
	      </tr>
	      <tr>
	        <td height="35" class="login-text02">验证图片：<br /></td>
	        <td><img src="<c:url value="/action/checkCode"/>"></img> <span style="cursor:hand" class="login-text03" onclick="changeImage(this);">看不清楚，换张图片</span></td>
	      </tr>
	      <tr>
	        <td height="35" class="login-text02">请输入验证码：</td>
	        <td><input name="imgcode" type="text" size="8"/></td>
	      </tr>
	      <tr>
	        <input type="radio" name="isadmin" value="0" checked="checked"/><span class="login-text02">普通管理员</span>
		    <input type="radio" name="isadmin" value="1"/><span class="login-text02">超级管理员</span>
	      </tr>
	      <tr>
	        <td height="35">&nbsp;</td>
	        <td><input style="cursor:hand" name="submit" type="submit" class="right-button01" value="确认登陆"/>
	          <input style="cursor:hand" id="reset" type="button" onclick="reVisit();" class="right-button02" value="重 置" /></td>
	      </tr>
	    </table>
	</form>
    </td>
  </tr>
</table>
  <script type="text/javascript">
    <c:if test="${not empty error}">
      alert("${error}");
    </c:if>
  </script>
  </body>
</html>
