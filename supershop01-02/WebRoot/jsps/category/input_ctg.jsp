<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
  <html>
  <head>
    
    <title>类别信息录入</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/form2.css"/>"/>
	<script type="text/javascript" src="<c:url value="/js/prototype.js"/>"></script>
	<script type="text/javascript">
	    function validateEntry(inputFrm){
	        with(inputFrm){
	          if(goodsbigctgid.value==""){
	               alert('商品大类别不能为空！请重新选择');
	               return false;
	          }
	           if(smallctgname.value==""){
	               alert('商品类别名称不能为空，请重新录入');
	               ${'smallctgname'}.select();
	               return false;
	          }
	        }
	     }
	
	</script>
	
  </head>
  
  <body onload="buildSelector(0)">
  
    <form action="categoryMgr?act=create" method="post" onsubmit ="return validateEntry(this);">
        <input type="hidden" name="act" value="create"/>
	    <div id="wrapper">
		    <h3>新增商品类别</h3>
		   <div class="f_row">
	          <span>商品大类别:</span>
           <select name="goodsbigctgid"> 
             <option value="">==请选择==</option> 
               <c:forEach var="category" items="${bigctglist}">
                <option value="${category.ctgId}">${category.ctgName}</option> 
             </c:forEach>
          </select> 
	     </div>
	     <div class="f_row">
		      <span class=>小类别名称:</span>
		      <input type="text" name="smallctgname"/>
		    </div>		     
		    <div class="f_row">
		      <input type="submit" value="创建小类别"/>
		    </div> 
	    </div>
	 <c:if test="${not empty err}">
       <script type="text/javascript">
         alert('${err}');
       </script>
    </c:if>
    </form>

    
  </body>
  
</html>

