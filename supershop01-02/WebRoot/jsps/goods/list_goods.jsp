<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>商品信息列表</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/application.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/list.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/form.css"/>">
	<script type="text/javascript" src="<c:url value="/js/common.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/prototype.js"/>"></script>
  
  	<script type="text/javascript">
	    
	    function doQuery(pageno)
         {
           if(pageno<1 || pageno>${pagedGoods.totalPageNum})
           {
              alert("页号超出范围，有效范围：[1-${pagedGoods.totalPageNum}]!");
              ${'pageNo'}.select();
              return;
           }
           
           var f=document.forms[0];
           f.action=f.action+"&pageNo="+pageno;
           f.submit();
           //location.href="<c:url value="/goodsMgr?act=loadall"/>&pageNo="+pageno;
         }
	    function forUqdate(goodsId)
	    {
	       location.href="<c:url value="/action/goodsMgr?act=forupdate"/>&goodsid="+goodsId;
	    }
	    
	    function removeGoods(goodsId,goodsName)
	    {
	        if(confirm("确认要删除商品["+goodsName+"]的信息吗?"))
	        {
				location.href="<c:url value="/action/goodsMgr?act=delete"/>&goodsid="+goodsId;
	        }
	    }
     function validateEntry(queryFrm){
         
           with(queryFrm){
               if(qurymingoodsprice.value==""){
                    if(qurymaxgoodsprice.value=="")
                       return true;
                    if(qurymaxgoodsprice.value!=""){
                        if(!isNaN(qurymaxgoodsprice.value))
                            return true;
                       }
                }
               if(qurymingoodsprice.value!=""){
                  if(!isNaN(qurymingoodsprice.value)){
                     if(qurymaxgoodsprice.value=="")
                       return true;
                       
                       
                     if(qurymaxgoodsprice.value!=""){
                        if(!isNaN(qurymaxgoodsprice.value))
                            return true;
                        else{
                             alert('价格必须为数字，请重新输入在查询');
                             ${'qurymaxgoodsprice'}.select();
                            return false;
                          }
                       }
                    }
                  else{
                    alert('价格必须为数字，请重新输入在查询');
                    ${'qurymingoodsprice'}.select();
                    return false;
                }
                }
                else{
                alert('价格必须为数字，请重新输入在查询');
                  ${'qurymingoodsprice'}.select();
                return false;
                }
            
             
            }
 
            
 }
 
 //获取小商品类别
            function buildSelector(object){
                     
                 var childs = object.childNodes;
                 for(var i=0;i<childs.length;i++)
                 {
                    if(childs[i].selected)
                    {
                        new Ajax.Request(
		                    encodeURI("/shop02/action/goodsMgr?act=getSubCtgs&seed="+Math.random()+"&bigctgid="+childs[i].value),
		                   {
		                    method:"get",
		                    onComplete:function(xhr){
		                      
		                        if(xhr.responseText=="")
		                        {
		                            var smallCtg=document.getElementById("goodsctgid");
				                    smallCtg.innerHTML="";
				                    var opt=document.createElement("OPTION");
				                     opt.value="";
				                     opt.innerHTML="==请选择==";
				                     smallCtg.appendChild(opt);
				                     
		                        	return;
		                        }
		                        else
		                        {  
		                        	var subCtgStr=xhr.responseText;
				                     var options=subCtgStr.split("|");
				                     var smallCtg=document.getElementById("goodsctgid");
				                     smallCtg.innerHTML="";
				                     var opt=document.createElement("OPTION");
				                     opt.value="";
				                     opt.innerHTML="==请选择==";
				                     smallCtg.appendChild(opt);
			                        
				                     for(i = 0 ;i<options.length;i++){
				                      
				                         var opt=document.createElement("OPTION");
				                         opt.value=options[i].split(":")[0];
				                         opt.innerHTML=options[i].split(":")[1];
				                         
				                         if(opt.value=='${param.qurygoodsctgid}')
				                         {
				                            opt.selected="selected";
				                         }
		
                                         smallCtg.appendChild(opt);
	                                   }                
		                        }
		                    }
		                   }
		               );
                        break;
                    }
                 }
           }  
           
           
	//页面加载
	function loadPage()
	{
	   var goodBigCtgId = document.getElementById("goodbigctgid");
	   buildSelector(goodBigCtgId);
	}
 </script>
</head>
  <body onload="loadPage();">
   <div class="f_row">
     <form action="<c:url value="/action/goodsMgr?act=loadPageGoods"/>" method="post" onSubmit="return validateEntry(this);">
      <span>商品名称：</span> 
            <input type="text" name="qurygoodsname" value="${param.qurygoodsname}"> 
      <span>商品价格:</span> 
	        <input type="text" class="text" name="qurymingoodsprice" size="4" value="${param.qurymingoodsprice}" onkeypress="onlynumber();"> -  
			<input type="text" class="text" name="qurymaxgoodsprice" size="4" value="${param.qurymaxgoodsprice}" onkeypress="onlynumber();">&nbsp; 
				     
      <span>商品是否有货：</span> 
      <select name="qurygoodsempty"> 
         <option value="" selected="selected">==请选择==</option> 
         <option value="1" <c:if test="${param.qurygoodsempty==1}">selected</c:if>="">有</option> 
         <option value="2" <c:if test="${param.qurygoodsempty==2}">selected</c:if>="">无</option> 
      </select> 
      <span>商品大类别</span>

	      <select id="goodbigctgid" name="qurygoodsbigctgid" onchange="buildSelector(this)"> 
             <option value="">======请 选 择=====</option> 
               <c:forEach var="bigcategory" items="${bigctglist}">
                <option value="${bigcategory.ctgId }" <c:if test="${bigcategory.ctgId == param.qurygoodsbigctgid }">selected</c:if> >${bigcategory.ctgName}</option> 
            </c:forEach>
          </select>
	    
	      <span>商品小类别:</span>

           <select name="qurygoodsctgid" id="goodsctgid" style="width:120px;">
             <option value="">==请选择==</option> 
          </select>        
       <input type="submit" value="查找">  
   </form>
   </div>
    <div id="wrapper">
	     <div id="title">商品信息列表</div>
	     <div>
	        <table id="listtable" cellpadding="0" cellspacing="0">
	          <tr>
	            <th>商品名称</th>
	            <th>商品价格</th>
	            <th>商品类型</th>
	            <th>商品是否缺</th>
	            <th>商品图片</th>
	            <th>商品库存数量 </th>
	            <th>商品管理员</th>
	            <th>操作</th>                                                            
	          </tr>
	          <c:forEach var="goods" items="${pagedGoods.pageContent}">
		          <tr>
		            <td>${goods.goodsName}</td>
		            <td>${goods.goodsPrice}</td>
		            <td>
		              <c:forEach var="ctg" items="${ctglist}">
                        <c:if test="${ctg.smallCtgId==goods.goodsCtgId}">${ctg.smallCtgName}</c:if>
                      </c:forEach>
                    </td>
                    
		            <td>
		              <c:choose>
		                <c:when test="${goods.goodsQty>=1}">不缺</c:when>
		                <c:when test="${goods.goodsQty==0}">缺</c:when>
		              </c:choose>
		            </td>
		            <td>
		                 <img src="<c:url value="/action/goodsMgr?act=getimage"/>&goodsid=${goods.goodsId}&randomNum=${randomNum}"  width="80px" height="55px"/>
			        </td>
			        <td>${goods.goodsQty}</td>
			        
			        <td>
		                <c:forEach var="administrator" items="${administrators}">
		                    <c:if test="${goods.goodsAdminId==administrator.administratorId}">${administrator.realName}</c:if>
		                </c:forEach>
		            </td>
		            <td>
		               <button onclick="javascript:forUqdate(${goods.goodsId});"> 修 改 </button>
		               <button onclick="javascript:removeGoods(${goods.goodsId},'${goods.goodsName}');"> 删 除 </button>
		            </td>                                                            
		          </tr>          
	          </c:forEach>
	        </table>
	     </div>
         <div id="pageinfo">
	            共${pagedGoods.totalRecNum}条, 当前显示${pagedGoods.startIndex}-${pagedGoods.endIndex}条, 第${pagedGoods.pageNo}/${pagedGoods.totalPageNum}页
	           |
	           <c:if test="${pagedGoods.pageNo>1}">
	             <span class="linkspan" onclick="doQuery(1)">首页</span>&nbsp;
	           </c:if>
	           <c:if test="${pagedGoods.prePage}">
	             <span class="linkspan" onclick="doQuery(${pagedGoods.pageNo-1})">上一页</span>&nbsp;
	           </c:if>
	           <c:if test="${pagedGoods.nextPage}">
	             <span class="linkspan" onclick="doQuery(${pagedGoods.pageNo+1})">下一页</span>&nbsp;
	           </c:if>
	           <c:if test="${pagedGoods.pageNo!=pagedGoods.totalPageNum}">
	             <span class="linkspan" onclick="doQuery(${pagedGoods.totalPageNum})">末页</span>&nbsp;
	           </c:if>
	           |
	            到<input type="text" id="pageNo" size=4 style="text-align:right;" onkeypress="onlynumber();"/> 页
	           <button onclick="doQuery($('pageNo').value);"> 跳 转 </button>		           		           	           	              
	      </div>	     	     
     </div>
     <c:if test="${not empty err}">
       <script type="text/javascript">
         alert('${err}');
       </script>
     </c:if>
  </body>
</html>
