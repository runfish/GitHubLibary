<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>商品类别信息展示</title>   
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/application.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/list.css"/>">
	<script type="text/javascript" src="<c:url value="/js/common.js"/>"></script>
  	<script type="text/javascript">
	  
	    function removeCategory(id,name){
	      
	      if(confirm("您确认要删除商品类别["+name+"]的信息吗?")){
	         location.href="<c:url value="/action/categoryMgr?act=delete"/>&smallctgid="+id;
	      }
	      
	    }
	    
	    function updateCategory(id){
	         location.href="<c:url value="/action/categoryMgr?act=forUpdate"/>&smallctgid="+id; 
	    }
	    
	    function doQuery(pageno)
        {
     
           if(pageno<1 || pageno>${pagedCategory.totalPageNum})
           {
              alert("页号超出范围，有效范围：[1-${pagedCategory.totalPageNum}]!");
              ${'pageNo'}.select();
              return;
           }
           location.href="<c:url value="/action/categoryMgr?act=loadPageAll"/>&pageNo="+pageno;
        }
	</script>
  </head>	
  <body>
     <div class="f_row">
     <form action="<c:url value="/action/categoryMgr?act=loadPageAll"/>" method="post" onSubmit="return validateEntry(this);">
	  <span></span>  
      <span>商品所属大类别：</span> 
      <select name="qurybigctgid"> 
         <option value="" selected="selected">=====请选择=====</option> 
         <c:forEach var="bigcategory" items="${biglist}">
         <option value="${bigcategory.ctgId}" <c:if test="${param.qurybigctgid==bigcategory.ctgId }">selected</c:if>>${bigcategory.ctgName}</option> 
         </c:forEach>
      </select> 
      <span>商品小类别名称：</span> 
      <input type="text" name="qurysctgname" value="${param.qurysctgname}"> 
       <input type="submit" value="查找">  
   </form>
   </div>
  
   	<div id="wrapper">
		<div id="title">商品类别信息列表</div>
		     <div>
		        <table id="listtable" cellpadding="0" cellspacing="0">
		          <tr>
		            <th>商品类别名</th>
		            <th>所属大类</th>            
		            <th>基本操作</th>                                                            
		          </tr>
		          <c:forEach var="category" items="${pagedCategory.pageContent}">
			          <tr>
			            <td>${category.smallCtgName}</td>
			            <td>
			              ${category.bigCategory.ctgName}
			            </td>
			            <td>

			               <button onclick="javascript:updateCategory(${category.smallCtgId});"> 修 改 </button>			 
			               <button onclick="javascript:removeCategory(${category.smallCtgId},'${category.smallCtgName}');"> 删 除 </button>
			            </td>                                                            
			          </tr>          
		          </c:forEach>
		        </table>
		     </div>
		     <div id="pageinfo">
	            共${pagedCategory.totalRecNum}条, 当前显示${pagedCategory.startIndex}-${pagedCategory.endIndex}条, 第${pagedCategory.pageNo}/${pagedCategory.totalPageNum}页
	           |
	           <c:if test="${pagedCategory.pageNo>1}">
	             <span class="linkspan" onclick="doQuery(1)">首页</span>&nbsp;
	           </c:if>
	           <c:if test="${pagedCategory.prePage}">
	             <span class="linkspan" onclick="doQuery(${pagedCategory.pageNo-1})">上一页</span>&nbsp;
	           </c:if>
	           <c:if test="${pagedCategory.nextPage}">
	             <span class="linkspan" onclick="doQuery(${pagedCategory.pageNo+1})">下一页</span>&nbsp;
	           </c:if>
	           <c:if test="${pagedCategory.pageNo!=pagedCategory.totalPageNum}">
	             <span class="linkspan" onclick="doQuery(${pagedCategory.totalPageNum})">末页</span>&nbsp;
	           </c:if>
	           |
	            到<input type="text" id="pageNo" size=4 style="text-align:right;" onkeypress="onlynumber();"/> 页
	           <button onclick="doQuery($('pageNo').value);"> 跳 转 </button>		           		           	           	              
	       </div>	     	     
	     </div>
  </body>
</html>
