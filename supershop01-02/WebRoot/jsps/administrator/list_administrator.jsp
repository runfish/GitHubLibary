<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

  <head>
    
    <title>普通管理员信息列表</title>   
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/application.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/form.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/list.css"/>">
	
	<script type="text/javascript">
	
	 function freezeadmin(id,name){
	      if(confirm("您确认要冻结管理员["+ name +"]的权限吗?")){
	         location.href='<c:url value="/action/adminMgr?act=freeze"/>&administratorid='+id;
	      }
	   
	   }
	   
	   
	 function unfreezeadmin(id,name){
	      if(confirm("您确认要释放管理员["+ name +"]的权限吗?")){
	         location.href='<c:url value="/action/adminMgr?act=unfreeze"/>&administratorid='+id;
	      }
	   
	   }
	   
	   
	   function removeadmin(id,name){
	      if(confirm("您确认要删除管理员["+ name +"]的信息吗?")){
	         location.href='<c:url value="/action/adminMgr?act=delete"/>&administratorid='+id;
	      }
	   
	   }
	   
	   
	   
	   function updateadmin(id){
	         location.href='<c:url value="/action/adminMgr?act=forUpdate"/>&administratorid='+id;
	    }
	
	
	</script>

  </head>
  
  <body>
	 <div id="wrapper">
		     <div id="title">普通管理员信息列表</div>
			 <div id="qryarea">
				          
		     <div>
		        <table id="listtable" cellpadding="0" cellspacing="0">
		          <tr>
		            <th>用户名</th>
		            <th>管理密码</th>
		            <th>真实姓名</th>
		            <th>出生日期</th>
		            <th>管理员邮箱</th>   
		            <th>联系方式</th>  
		            <th>家庭住址</th>  
		            <th>邮政编码</th> 
		            <th>操作</th>                                                          
		          </tr>
		          <c:forEach var="administrator" items="${administratorList}">
		           <c:if test="${administrator.isSuperAdministrator=='false'}">
			          <tr>	   
			            <td>${administrator.administratorName}</td>
			            <td>${administrator.administratorPassword}</td>
			            <td>${administrator.realName}</td>
			            <td>${administrator.birthday}</td>
			            <td>${administrator.email}</td>
			            <td>${administrator.telNum}</td>
			            <td>${administrator.address}</td>
			            <td>${administrator.postCode}</td>
			            <td>
			               <button onclick="javascript:updateadmin(${administrator.administratorId});"> 修 改 </button>
			               <button onclick="javascript:removeadmin(${administrator.administratorId},'${administrator.administratorName}');"> 删 除 </button>
			               <c:if test="${administrator.isFreeze==false}">
			               <button onclick="javascript:freezeadmin(${administrator.administratorId},'${administrator.administratorName}');">冻结权限</button>
			               </c:if>
			               <c:if test="${administrator.isFreeze==true}">
			               <button onclick="javascript:unfreezeadmin(${administrator.administratorId},'${administrator.administratorName}');">释放权限</button>
			               </c:if>
			            </td>                                                            
			          </tr>  
			          </c:if>
			        </c:forEach>        
		        </table>
		     </div> 
		 </div>
	</div>    
  </body>
</html>
