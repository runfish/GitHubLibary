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
	
    var seed= Math.random();
    //系统时间数组
    var time=new Array();
    //管理员用户是否存在的标志
    var exist=true;
    var userName='${sessionScope.admin.administratorName}';
	//获取系统时间
	function getSystemDate()
	{
	  new Ajax.Request(
	  encodeURI("/shop02/action/securityMgr?act=getSystemDate&rand="+Math.random()),
	  {
	  	method:"get",
	  	onComplete:function(xhr)
	  	{
	  	  if(xhr.responseText!=null)
	      {
	         var systemTime=xhr.responseText;
	         var array=systemTime.split(":");
	         time[0]=parseInt(array[0]);
	         time[1]=parseInt(array[1]);
	         time[2]=parseInt(array[2]);
	         time[3]=parseInt(array[3]);
	         time[4]=parseInt(array[4]);
	         time[5]=parseInt(array[5]);
	         updateDate();
	      }
	  	}
	  }
	  );
	}
	//刷新服务器时间
	function updateDate()
	{   
	     var cTime=document.getElementById("ctime");
	     cTime.innerHTML="";
	     
		 var serviceTime=time[0]+"-"+time[1]+"-"+time[2]+" "
	                     +time[3]+":"+time[4]+":"+time[5]+"&nbsp";
	     cTime.innerHTML=serviceTime;
	     time[5]=time[5]+1;
	     if(time[5]==60)
	     {
	        time[5]=0;
	        time[4]=time[4]+1;
	     }
	     if(time[4]==60)
	     {
	        time[4]=0;
	        time[3]=time[3]+1;
	     }
	     if(time[3]==24)
	     {
	        time[3]=0;
	        time[2]=time[2]+1;
	     }
	}
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
	    clearInterval(isExist);
	  	alert("对不起，管理员:"+userName+"已经失去连接清重新登入!");
	  	location.href="<c:url value="/action/securityMgr?act=logOut"/>";
	  }
	}
	 var ad=setInterval(isExist,10*60*1000);
	 var sh=setInterval(updateDate,1000); 
</script>
  </head>
  
  <body  onload="getSystemDate();" style="background-color:#B0E0E6">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" style="background-color:#B0E0E6">
  <tr>
    <td height="59" background="/shop02/pics/images/top.gif">
    <table width="99%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="64%" align="right" style="font-size:12px;vertical-align:bottom;">
             <span style="color:blue;font-size:12" id="ctime">时间</span>
        </td>
      </tr>
    </table>
   </td>
  </tr>
</table>
  </body>
</html>
