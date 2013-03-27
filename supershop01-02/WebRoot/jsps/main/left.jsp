<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>电子商务管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<link href="<c:url value="/css/newcss/css.css"/>" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<c:url value="/js/prototype.js"/>"></script>
 <script type="text/javascript">

function list(idstr){
	var name1="subtree"+idstr;
	var name2="img"+idstr;
	var objectobj=document.all(name1);
	var imgobj=document.all(name2);
	
	
	//alert(imgobj);
	
	if(objectobj.style.display=="none"){
		for(i=1;i<10;i++){
			var name3="img"+i;
			var name="subtree"+i;
			var o=document.all(name);
			if(o!=undefined){
				o.style.display="none";
				var image=document.all(name3);
				//alert(image);
				image.src="/shop02/pics/images/ico04.gif";
			}
		}
		objectobj.style.display="";
		imgobj.src="/shop02/pics/images/ico03.gif";
	}
	else{
		objectobj.style.display="none";
		imgobj.src="/shop02/pics/images/ico04.gif";
	}
}
//判断是超级管理员界面或者普通管理员界面
function isAdmin()
{
   var object=document.getElementById("isadmin");
   if(${sessionScope.isadmin})
   {
   		object.style.display="block";
   }
}
//管理员用户是否存在的标志
    var exist=true;
    var realLeave=false;
    var userName='${sessionScope.admin.administratorName}';
 //判断管理员用户是否还存在session空间
	function isExist()
	{  
	  if(exist==true)
	  {
		if(${sessionScope.admin==null})
		{  
			exist=false;
		}
	  }
	  if(exist==false)
	  {
	    clearInterval(ad);
	  	alert("对不起，管理员:"+userName+"已经失去连接清重新登入!");
	  	realLeave=true;
	  	var leave=document.getElementById("leave");
	  	leave.click();
	  }
	}
//退出系统
function logout(object)
{
   if(realLeave==false)
   {
	  if(confirm('尊敬的${sessionScope.admin.administratorName},您真的要离开系统吗？'))
	  {
	     object.href="<c:url value="/action/securityMgr?act=logOut"/>";
	  }
   }
   else if(realLeave==true)
   {
       object.href="<c:url value="/action/securityMgr?act=logOut"/>";
   }    
}
var ad=setInterval(isExist,1*60*1000);
</script>
  </head>
  
  <body onload="isAdmin();" style="background-color:#B0E0E6">
    <table width="198" border="0" cellpadding="0" cellspacing="0" class="left-table01">
  <tr>
    <TD>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="207" height="55" background="/shop02/pics/images/nav01.gif">
				<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
				  <tr>
					<td width="25%" rowspan="2"><img src="/shop02/pics/images/ico02.gif" width="35" height="35" /></td>
					<td width="75%" height="22" class="left-font01">您好，<span class="left-font02">${sessionScope.admin.administratorName}</span></td>
				  </tr>
				  <tr>
					<td height="22" class="left-font01">
						[&nbsp;<a id="leave" target="_top" onclick="logout(this);" style="cursor:hand">退出&nbsp;]</td>
				  </tr>
				</table>
			</td>
		  </tr>
		</table>
		


		<!--  类别系统开始    -->
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img8" id="img8" src="/shop02/pics/images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('8');" >类别系统</a>
						</td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
		<table id="subtree8" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" 
				cellspacing="0" class="left-table02">
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu20" src="/shop02/pics/images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="<c:url value="/action/categoryMgr?act=input"/>"  target="mainFrame" class="left-font03">类别增加</a></td>
				</tr>
				<tr>
				  <td width="9%" height="21" ><img id="xiaotu21" src="/shop02/pics/images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="<c:url value="/action/categoryMgr?act=loadPageAll"/>"  target="mainFrame" class="left-font03">类别管理</a></td>
				</tr>
      </table>
		<!--  类别系统结束    -->

		

		<!--  商品系统开始    -->
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img7" id="img7" src="/shop02/pics/images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('7');" >商品系统</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
		<table id="subtree7" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" 
				cellspacing="0" class="left-table02">
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu17" src="/shop02/pics/images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%">
						<a href="<c:url value="/action/goodsMgr?act=input"/>" target="mainFrame" class="left-font03">商品增加</a></td>
				</tr>
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu18" src="/shop02/pics/images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%">
					<a href="<c:url value="/action/goodsMgr?act=loadPageGoods"/>" target="mainFrame" class="left-font03">商品管理</a></td>
				</tr>
      </table>
		<!--  商品系统结束    -->


       <!--  订单系统开始    -->
        <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img1" id="img1" src="/shop02/pics/images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('1');" >订单系统</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
		<table id="subtree1" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" 
				cellspacing="0" class="left-table02">
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu1" src="/shop02/pics/images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="<c:url value="/action/dealMgr?act=loadPageDeal"/>" target="mainFrame" class="left-font03">订单管理</a></td>
				</tr>
      </table>
		<!--  订单系统结束    -->

	  <!--  管理员系统开始    -->
	  <table id="isadmin" style="display:none;" width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29"><table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="8%" height="12"><img name="img2" id="img2" src="/shop02/pics/images/ico04.gif" width="8" height="11" /></td>
                  <td width="92%"><a href="javascript:" target="mainFrame" class="left-font03" onClick="list('2');" >管理员系统</a></td>
                </tr>
            </table></td>
          </tr>
      </table>
	  
	  <table id="subtree2" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
        
		<tr>
          <td width="9%" height="20" ><img id="xiaotu7" src="/shop02/pics/images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="<c:url value="/action/adminMgr?act=input"/>" target="mainFrame" class="left-font03">管理员增加</a></td>
        </tr>
        <tr>
          <td width="9%" height="20" ><img id="xiaotu6" src="/shop02/pics/images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="<c:url value="/action/adminMgr?act=loadall"/>" target="mainFrame" class="left-font03">管理员管理</a></td>
        </tr>
      </table>

	  <!--  管理员系统结束    -->
	  
      <!--  用户系统开始    -->
	  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29"><table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="8%" height="12"><img name="img3" id="img3" src="/shop02/pics/images/ico04.gif" width="8" height="11" /></td>
                  <td width="92%"><a href="javascript:" target="mainFrame" class="left-font03" onClick="list('3');" >用户系统</a></td>
                </tr>
            </table></td>
          </tr>
      </table>
	  
	  <table id="subtree3" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
        <tr>
          <td width="9%" height="20" ><img id="xiaotu8" src="../images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="<c:url value="/action/customerMgr?act=loadPageAll"/>" target="mainFrame" class="left-font03">用户管理</a></td>
        </tr>
      </table>
	
	  <!--  用户系统结束    -->
	  
	  <!-- 系统帮助开始 -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
        <tr>
          <td height="29"><table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td width="8%"><img name="img6" id="img6" src="/shop02/pics/images/ico04.gif" width="8" height="11" /></td>
                <td width="92%"><a href="<c:url value="/jsps/main/mode.jsp"/>" target="mainFrame" class="left-font03" onClick="list('6');">系统帮助</a></td>
              </tr>
          </table></td>
        </tr>
      </table>
	  <table id="subtree6" style="display:none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
        <tr>
          <td width="9%" height="20"><img id="xiaotu15" src="/shop02/pics/images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="<c:url value="/jsps/main/mode.jsp"/>" target="mainFrame" class="left-font03">用户手册</a></td>
        </tr>
      </table>
	 <!-- 系统帮助结束-->

	  </td>
  </tr>
  
</table>
  </body>
</html>
