<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
    
    <title>商品类别信息修改</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/application.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/form.css"/>"/>
	<script type="text/javascript">
  	   function validateEntry(updateFrm){
	        with(updateFrm){
	           if(smallctgname.value==""){
	               alert('商品小类别名称不能为空，请重新录入');
	               return false;
	           }
	           if(goodsbigctgid.value==""){
	               alert('商品大类别不能为空,请从新输入');
	               return false;
	            }
	        }
	    }
	    </script>
  </head>
  
  <body>
    <div id="wrapper">
	    <div id="f_title">商品[${smallcategory.smallCtgName}]信息修改</div>
	    <form action="<c:url value="/action/categoryMgr?act=update"/>" method="post"  onSubmit="return validateEntry(this);">
	        <input type="hidden" name="goodssmallctgid" value="${smallcategory.smallCtgId}"/>
	    <div id="wrapper">
		   <div class="f_row">
	          <span>商品大类别:</span>
           <select name="goodsbigctgid"> 
             <option value="">==请选择==</option> 
               <c:forEach var="category" items="${bigctglist}">
                <option value="${category.ctgId}" <c:if test="${smallcategory.bigCategory.ctgId==category.ctgId}">selected</c:if> >${category.ctgName}</option>
             </c:forEach>
          </select> 
	     </div>
	     <div class="f_row">
		      <span class=>小类别名称:</span>
		      <input type="text" name="smallctgname" value="${smallcategory.smallCtgName}"/>
		    </div>		     
		    <div class="f_row">
		      <input type="submit" value="信息修改"/>
		    </div> 
	    </div>     
	    </form>
    </div>    
  </body>
</html>
