<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>商品信息修改</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/application.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/form.css"/>"/>
	
	<style>
	   #oldimage{
	     position:absolute;
	     right:30px;
	     top:60px;
	     width:250px;
	     height:150px;
	   }
	</style>
	
	<script type="text/javascript">
	   function validateEntry(updateFrm){
	        with(updateFrm){
	           if(goodsname.value==""){
	               alert('商品名称不能为空，请重新录入');
	               return false;
	           }
	           if(goodsprice.value==""){
	               alert('商品价格不能为空，请重新录入');
	               return false;
	           }
	           if(isNaN(goodsprice.value)){
	              alert('商品价格必须为数字，请重新录入');
	              return false;
	           }
	           if(goodsqty.value==""){
	              alert('商品库存数量不能为空，请重新录入');
	              return false;
	           }
	           if(isNaN(goodsqty.value)||(goodsqty.value<0)){
	               alert('商品库存数量必须为大等于零的数字');
	               return false;
	           }
	           if(goodsadminid.value==""){
	              alert('管理员不能为空，请重新选择');
	              return false;
	           }
	       
	        }
	    }
	    //刷新图片
	    function changeImage(object)
	    {
	       var picUrl=getPath(object);
	       if(picUrl)
	       {
           		var goodsView=document.getElementById("oldimage");
           		goodsView.src=picUrl;
           }
           else
           {
           		goodsView.src="/pics/default.gif";
           }
	    }
	    
	//获得上传文件的全路径
    function getPath(object) 
    { 
      var browserName = navigator.appName;
      var browserVer = parseInt ( navigator.appVersion );
      if (( browserName == "Microsoft Internet Explorer") && (browserVer+5 >=9) )
      {
        object.select();
        var button=document.getElementById("submit");
        button.focus();
        path= document.selection.createRange().text;
        var array=path.split("\\");
        var realPath=array.join("/");
        return realPath;
      }
      else if (( browserName == "Microsoft Internet Explorer") && (browserVer+5 <9) )
      {
      	object.select();
        path= document.selection.createRange().text;
        var array=path.split("\\");
        var realPath=array.join("/");
        return realPath;
      }
      else 
      {
         alert("对不起图片预览功能暂时不支持非IE浏览器!");
         return ;
      }
    } 
	</script>
	
  </head>
  
  <body>
    <div id="wrapper">
	    <div id="f_title">商品[${goods.goodsName}]信息修改</div>
	     <img id="oldimage" src="<c:url value="/action/goodsMgr?act=getimage"/>&goodsid=${goods.goodsId}"/>
	    <form action="<c:url value="/action/goodsMgr"/>" method="post" enctype="multipart/form-data" onSubmit="return validateEntry(this);">
	         <input type="hidden" name="act" value="update"/>
	        <input type="hidden" name="goodsid" value="${goods.goodsId}"/>
	   	 	<div class="f_row">
	          <span>商品名称:</span>
	          <input type="text" name="goodsname" value="${goods.goodsName}" size="20"/>
	    	</div>
	   		<div class="f_row">
	          <span>商品单价:</span>
	          <input type="text" name="goodsprice" value="${goods.goodsPrice}" size="20"/>
	    	</div>
	    	<div class="f_row">
	          <span>商品所属类别:</span>
	          <select name="goodsctgid" >
	            <option value="0">==请选择==</option>
                  <c:forEach var="category" items="${ctgList}">
		             <option value="${category.smallCtgId}" <c:if test="${goods.goodsCtgId==category.smallCtgId}">selected</c:if> >${category.smallCtgName}</option>
		          </c:forEach>	          
	          </select>
	    	</div>
	    	<div class="f_row">
	    	    <span>商品库存数量</span>
	    	    <input type="text" name="goodsqty" value="${goods.goodsQty}" size="20"/>
	    	</div>
	    	   <div class="f_row">
	          <span>商品所属管理员</span>
	          <select name="goodsadminid" >
	            <option value="">==请选择==</option>
                  <c:forEach var="administrator" items="${administrators}">
		             <option value="${administrator.administratorId}"<c:if test="${goods.goodsAdminId==administrator.administratorId}">selected</c:if>>${administrator.realName }</option>
		          </c:forEach>	          
	          </select>
	        </div>
	    	
	    	<div class="row">
	    	
	    	    <span>商品图片</span>
	    	    <input type="file" id="goodsimage" name="goodsimage" size="50" onchange="changeImage(this);"/>
	    	</div>
	    	
	    	<div class="f_row">
	    	   <span>商品描述</span>
	    	   <textarea  name="goodsdesc"cols="50" rows="5">${goods.goodsDesc }</textarea>
	    	</div>
  	         
	        <div class="f_row">
	          <input id="submit" type="submit" value="信息修改"/>      
	        </div>                        
	    </form>
	   <c:if test="${not empty err}">
       <script type="text/javascript">
         alert('${err}');
       </script>
       </c:if>
    </div>
  </body>
</html>
