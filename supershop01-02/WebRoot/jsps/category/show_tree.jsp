<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'show_tree.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="dtree.js"></script>
	<link rel="StyleSheet" href="dtree.css" type="text/css" /> 
	
	<style>
	
	    #ctgTree{
	      width:200px;
	      border-right:2px solid blue;
	      padding:8px;
	      float:left;      
	    }
	    
	    
	    
	</style>

  </head>
  
  <body>
    <h3>商品类别</h3>
	<div class="dtree" id="ctgTree">
		<p><a href="javascript: d.openAll();">展开</a> | <a href="javascript: d.closeAll();">收起</a></p>
	
		<script type="text/javascript">
				
			d = new dTree('d');	
	        <c:forEach var="ctg" items="${ctgs}">
	           d.add(${ctg.ctgId},<c:if test="${ctg.ctgId==0}">-1</c:if><c:if test="${ctg.ctgId!=0}">${ctg.parentCtg.ctgId}</c:if> 
	                   ,'${ctg.ctgName}','${ctg.linkUrl}','小提示','contentFrame');
	        </c:forEach>				
			document.write(d);			
		</script>
	</div>
	<div id="content">
	   <iframe height="500px;" width="100%" frameborder="0" scrolling="auto" name="contentFrame" src="http://localhost:8080/shop02/jsps/category/list_ctg.jsp"></iframe>
	</div>
  </body>
</html>
