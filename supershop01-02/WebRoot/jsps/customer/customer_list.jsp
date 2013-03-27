<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.net.URLDecoder"%>
<%@ include file="/jsps/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>用户信息</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/application.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/form.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/list.css"/>">
	<script type="text/javascript" src="<c:url value="/js/common.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/prototype.js"/>"></script>
	
	<script type="text/javascript">	
			  function doQuery(pageno)
		         {
		           if(pageno<1 || pageno>${pagedCustomer.totalPageNum})
		           {
		              alert("页号超出范围，有效范围：[1-${pagedCustomer.totalPageNum}]!");
		              ${'pageNo'}.select();
		              return;
		           }
		          
		           location.href="<c:url value="/action/customerMgr?act=loadPageAll"/>&pageNo="+pageno;
		         }
			
			
			 function freezecustomer(name){
			      if(confirm("您确认要冻结用户["+ name +"]的权限吗?")){
			          var user_name = name;
			          user_name = encodeURI(encodeURI(user_name));
			          location.href='<c:url value="/action/customerMgr?act=freeze"/>&customername='+user_name;
			      }
			   
			   }
			   
			   
			 function unfreezecustomer(name){
			      if(confirm("您确认要释放用户["+ name +"]的权限吗?")){
			          var user_name = name;
			          user_name = encodeURI(encodeURI(user_name));
			         location.href='<c:url value="/action/customerMgr?act=unfreeze"/>&customername='+user_name;
			      }
			   
			   }
			   
			   	   
			   function updateadmin(id){
			         location.href='<c:url value="/action/customerMgr?act=forUpdate"/>&customername='+name;
			    }
	
	</script>

  </head>
  
  <body>
  	 <div id="wrapper">
		     <div id="title">&nbsp;用户信息列表</div>
			 <div id="qryarea">
				          
		     <div>
		        <table id="listtable" cellpadding="0" cellspacing="0">
		          <tr>
		            <th>用户名</th>
		            <th>用户密码</th>
		            <th>账户余额</th>
		            <th>真实姓名</th>
		            <th>出生日期</th>
		            <th>邮箱</th>   
		            <th>联系方式</th>  
		            <th>家庭住址</th>  
		            <th>邮政编码</th>
		            <th>是否会员</th> 
		            <th>冻结状态</th>
		            <th>操作</th>                                                          
		          </tr>
		          <c:forEach var="customer" items="${pagedCustomer.pageContent}">
		          
			          <tr>	   
			            <td>${customer.customerName}</td>
			            <td>${customer.customerPassword}</td>
			            <td>${customer.customerAccount}</td>
			            <td>${customer.customerRealname}</td>
			            <td>${customer.customerBirthday}</td>
			            <td>${customer.customerMail}</td>
			            <td>${customer.customerTel}</td>
			            <td>${customer.customerAddress}</td>
			            <td>${customer.customerPostCode}</td>
			            <td>
			                <c:if test="${customer.isMember==1}">是</c:if>
			                <c:if test="${customer.isMember==0}">否</c:if>
			            </td>
			            
			            <td>
			                <c:if test="${customer.isFreeze==0}">正常</c:if>
			                <c:if test="${customer.isFreeze==1}">已冻结</c:if>
			            </td>
			            <td>
			               <button onclick="javascript:updatecustomer('${customer.customerName}');"> 修 改 </button>
			               <c:if test="${customer.isFreeze==0}">
			               <button onclick="javascript:freezecustomer('${customer.customerName}');">冻结权限</button>
			               </c:if>
			               <c:if test="${customer.isFreeze==1}">
			               <button onclick="javascript:unfreezecustomer('${customer.customerName}');">释放权限</button>
			               </c:if>
			            </td>                                                            
			          </tr>  
			   
			        </c:forEach>        
		        </table>
		     </div> 
		     <div id="pageinfo">
	            共${pagedCustomer.totalRecNum}条, 当前显示${pagedCustomer.startIndex}-${pagedCustomer.endIndex}条, 第${pagedCustomer.pageNo}/${pagedCustomer.totalPageNum}页
	           |
	           <c:if test="${pagedCustomer.pageNo>1}">
	             <span class="linkspan" onclick="doQuery(1)">首页</span>&nbsp;
	           </c:if>
	           <c:if test="${pagedCustomer.prePage}">
	             <span class="linkspan" onclick="doQuery(${pagedCustomer.pageNo-1})">上一页</span>&nbsp;
	           </c:if>
	           <c:if test="${pagedCustomer.nextPage}">
	             <span class="linkspan" onclick="doQuery(${pagedCustomer.pageNo+1})">下一页</span>&nbsp;
	           </c:if>
	           <c:if test="${pagedCustomer.pageNo!=pagedCustomer.totalPageNum}">
	             <span class="linkspan" onclick="doQuery(${pagedCustomer.totalPageNum})">末页</span>&nbsp;
	           </c:if>
	           |
	            到<input type="text" id="pageNo" size=4 style="text-align:right;" onkeypress="onlynumber();"/> 页
	           <button onclick="doQuery($('pageNo').value);"> 跳 转 </button>		           		           	           	              
	       </div>	     
		 </div>
	</div> 
	 <c:if test="${not empty err}">
       <script type="text/javascript">
         alert('${err}');
       </script>
     </c:if>
  </body>
</html>
