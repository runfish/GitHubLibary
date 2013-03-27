<%@ page language="java" import="java.util.*,java.io.File" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>商品订单信息列表</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/application.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/list.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/form.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/date.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/newcss/style.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/passport.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/regist.css"/>">
    <script type="text/javascript" src="<c:url value="/js/common.js"/>"></script> 
    <script type="text/javascript" src="<c:url value="/js/prototype.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/jquery-1.8.3.min.js"/>"></script>
  
  	<script type="text/javascript">
  	    
  	     //页数控制
	      function doQuery(pageNo)
         {
	           if(pageNo<1 || pageNo>${pagedDeal.totalPageNum})
	           {
	              alert("页号超出范围，有效范围：[1-${pagedDeal.totalPageNum}]!");
	              ${'pageNo'}.select();
	              return;
	           }
	          var f=document.forms[0];
	           f.action=f.action+"&pageno="+pageNo;
	           f.submit();
         }
	    
	 //订单详细信息
	    function getDealItem(dealId)
	    {  
	     	var content=document.getElementById("display");
	    	var showDeal=document.getElementById("showdeal");
	    	var table=document.getElementById("wrapper");
	    	var isAccept=document.getElementById("isaccept");
	          
	    	table.style.display="none";
	    	showDeal.style.display="block";
	    	isAccept.style.display="none";
	    	
	     	if(content.hasChildNodes())
	     	{ 
	     	   content.innerHTML="";
	     	}
	     	new Ajax.Request(
	     	 encodeURI("/shop01/action/dealItemMgr?act=loadPageDealItem&rand="+Math.random()+"&dealid="+dealId),
	     	 {
	     	   method:"get",
	     	   onComplete:function(xhr)
	     	   {
	     	     var html=xhr.responseText;
	     	     content.innerHTML=html;
	     	   }
	     	 }
	     	);
	    }
	    //清空订单详细、收货人信息详细的元素节点内的所有内容
	    function cleanChild(object)
	    {  
	       var parentNode=object.parentNode.parentNode.parentNode;
	       var show=parentNode.parentNode;
	       var table=document.getElementById("wrapper");
	       
	        if(parentNode.hasChildNodes())
	        {
	            parentNode.innerHTML="";
	        }
	       table.style.display="block";
	       show.style.display="none";
	    }
	    //刷新订单窗口
	    function refresh()
	    {
	     	window.location.href="<c:url value="/action/dealMgr?act=loadPageDeal"/>";
	    }
	    //确认到货
	    var orderId=0;
	    var type=""
	    
	    function sureAccept(id)
	    {
	       if(confirm("请确认已经收到货物，再点击确定"))
	       {
	          orderId=id;
	          type="accept";
	          var isAccept=document.getElementById("isaccept");
	          var pw=document.getElementById("password");
	          isAccept.style.display="block";
	          pw.value = "";
	          
	          alert("请再输入一次密码，确认收货！");
	       }
	    }
	   //申请退货
	    
	    function applyReturn(id)
	    {
	       if(confirm("确定要申请退货吗？"))
	       {
	          orderId=id;
	          type="return";
	          var isAccept=document.getElementById("isaccept");
	          var pw=document.getElementById("password");
	          isAccept.style.display="block";
	          pw.value = "";
	          
	          alert("请再输入一次密码，确定退货！");
	       }
	    }
	    //提交完成操作
	    function submit()
	    {   
	       var pw=document.getElementById("password");
	       new Ajax.Request(
            encodeURI("dealMgr?act=opt&seed="+Math.random()+"&pw="+pw.value+"&dealid="+orderId+"&type="+type),
            {
              method:"get",
              onComplete:function(xhr){
              
                if(xhr.responseText!="")
                {
                   var message=xhr.responseText.split("|");
                   if(message[0]=="successful")
                   {
                   		var isAccept=document.getElementById("isaccept");
			            isAccept.style.display="none";
			            if(type=="accept")
			            {
			            	var sureText=document.getElementById("suretext"+orderId);
			            	sureText.innerHTML="已查收";
			            }
			            else if(type=="return")
			            {  
			            	var Text=document.getElementById("suretext"+orderId);
			            	Text.innerHTML="申请退货";
			            }
			            var oprate=document.getElementById("oprate"+orderId);
			            oprate.innerHTML='<a title="点击删除订单信息" style="height:40px;margin-top:20px;text-decoration:underline;color:blue;cursor:hand;" onclick="removeDeal('+orderId+')">删除订单信息</a>';
                   }
                   else
                   {
                       alert(xhr.responseText);
                       var isAccept=document.getElementById("isaccept");
	          		   isAccept.style.display="none";
                   }
                }
             }
           });
	    }
	 //显示用户信息
	function loginChange()
	{ 
	  var login=document.getElementById("login");
	   var userName="${sessionScope.customer.customerName}";
	   if(userName=="")
	   {  
	      login.innerHTML='<a href="<c:url value="/jsps/login/login.jsp"/>">[登录]</a>';
	   }
	   else
	   {  
	      login.innerHTML='<a href="<c:url value="/action/customerMgr?act=require&rand='+Math.random()+'"/>" target="_blank">'+userName+'</a>';
	   } 
	}
	//订单信息删除
	function removeDeal(dealId)
	{ 
	     if(confirm("确认要删除订单号为"+dealId+"的订单信息吗?"))
	     { 
			location.href="<c:url value="/action/dealMgr?act=del"/>&dealid="+dealId+"&rand="+Math.random();
	     }
	}
	</script>
	</head>
  <body onload="loginChange();">
  
    <!-- 头部开始 -->
   <div id="shortcut" style="text-align:right;">
      <div class="w">
        <ul class="fr lh">
            <li class="fore1 ld" id="loginbar">您好，欢迎来到农大商城！<span id="login"><a href="/shop01/jsps/login/login.jsp">[登录]</a></span></li>
            <li class="fore2"><a href="/shop01/index.jsp" rel="nofollow">返回首页</a></li>
            <li class="fore2"><a href="" rel="nofollow">企业服务</a></li>
            <li class="fore2"><a href="" rel="nofollow">客户服务</a></li>
        </ul>
        <span class="clr"></span>
    </div>
  </div><!--shortcut end-->
  
  <!-- 头部结束 -->
  <!-- 订单显示开始 -->
    <div id="wrapper">
	     <div id="title">订单信息列表</div>
	     <div>
          <form action="<c:url value="/action/dealMgr?act=loadPageDeal"/>" method="post">
		   <span class="f_row">订单编号</span>
		   <span><input  class="f_row" type="text" name="qurydealid" value="${param.qurydealid }"/></span>
		   <span class="f_row">物流状态</span>
		   <span>
			 <select name="qurydealstatus">
			 <option value="">== 请选择 == </option>
			 <option  value="a" <c:if test="${param.qurydealstatus=='a'}">selected</c:if> >未发货</option>
			 <option  value="b" <c:if test="${param.qurydealstatus=='b'}">selected</c:if> >已发货</option>
			 <option  value="c" <c:if test="${param.qurydealstatus=='c'}">selected</c:if> >已退货</option>
		   </select>
		  </span>
		  <span class="f_row">接收状态</span>
		  <span>
			 <select name="quryisaccept">
			 <option value="-1">== 请选择 == </option>
			 <option  value="0" <c:if test="${param.quryisaccept=='0'}">selected</c:if> >未查收</option>
			 <option  value="1" <c:if test="${param.quryisaccept=='1'}">selected</c:if> >已查收</option>
			 <option  value="2" <c:if test="${param.quryisaccept=='2'}">selected</c:if> >申请退货</option>
		   </select>
		  </span>
		  <span class="f_row">下单日期</span>
          <span><input style="cursor:hand" type="text" id="calendar" class="calendar_input" readonly="readonly" name="qurydealdate" value="${param.qurydealdate}"/></span>
		  <script type="text/javascript" src="<c:url value="/js/date.js"/>" charset="gbk"></script> 
		  <span><input style="cursor:hand;width:80;text-align:center" class="f_row" type="submit" value="查找"/></span>
          <span><input style="cursor:hand;width:60;text-align:center" class="f_row" type="button" value="刷新" onclick="refresh();"/></span>
        </form>
         </div>
	     <div>
	        <table id="listtable" cellpadding="0" cellspacing="0">
	          <tr>
	            <th>订单编号</th>
	            <th>订单金额</th>
	            <th>付款方式</th>
	            <th>收货方式</th>
	            <th>收货人信息</th>
	            <th>物流状态</th>
	            <th>审核时间</th>
	            <th>下单时间</th>
	            <th>接收状态</th>
	            <th>详细信息</th>    
	            <th>订单操作</th>                                                  
	          </tr>
	          <c:forEach var="deal" items="${pagedDeal.pageContent}">
		          <tr>
		            <td>${deal.dealId}</td>
		            <td>${deal.dealSum}</td>
			        <td>
			         <c:choose>
			                <c:when test="${deal.payPattern=='b'}">账户付款</c:when>
			                <c:when test="${deal.payPattern=='c'}">网银支付</c:when>
			          </c:choose>
			        </td>
			        <td>
			           <c:choose>
			                <c:when test="${deal.receivePattern=='b'}">平邮</c:when>
			                <c:when test="${deal.receivePattern=='c'}">快递</c:when>
			                <c:when test="${deal.receivePattern=='d'}">ESM</c:when>
			          </c:choose>
			        </td>
		            <td>
		              <c:if test="${not empty deal.consigneeInfo}">
		                <script type="text/javascript">
		                   var consignee='${deal.consigneeInfo}';
		                   var array=consignee.split(":");
		                   document.write(array[0]);
		                </script>
		              </c:if>
		              <c:if test="${empty deal.consigneeInfo}">
		                 --无收货人信息--
		              </c:if>
		            </td>
		            <td id="status">
		              <c:choose>
			                <c:when test="${deal.dealStatus=='a'}">未发货</c:when>
			                <c:when test="${deal.dealStatus=='b'}">已发货</c:when>
			                <c:when test="${deal.dealStatus=='c'}">已退货</c:when>
			          </c:choose>
		            </td>
		            <td>
		              <c:if test="${empty deal.dealExamDate}">----</c:if> 
		              <c:if test="${not empty deal.dealExamDate}">${deal.dealExamDate}</c:if> 
		            </td>
		            <td>${deal.dealDate }</td>
		             <td id="suretext${deal.dealId }">
		            	<c:choose>
			            	<c:when test="${deal.isAccept==0 }">未查收</c:when>
			            	<c:when test="${deal.isAccept==1 }">已查收</c:when>
			            	<c:when test="${deal.isAccept==2 }">申请退货</c:when>
			        	</c:choose>
		            </td>
		            <td style="cursor:hand" ondblclick="getDealItem(${deal.dealId});" title="查看订单详细信息">订单详细</td>   
		            <td id="oprate${deal.dealId }">
		            	<c:if test="${deal.isAccept==0 }">
		            		<a title="货物已经送到请点击确认" style="height:40px;margin-top:20px;text-decoration:underline;color:blue;cursor:hand;" onclick="sureAccept(${deal.dealId });">确认到货</a>
		            	    <a title="点击申请退货" style="height:40px;margin-top:20px;text-decoration:underline;color:blue;cursor:hand;" onclick="applyReturn(${deal.dealId })">申请退货</a>
		            	</c:if>
		                <c:if test="${deal.isAccept==1 }"><a title="点击删除订单信息" style="height:40px;margin-top:20px;text-decoration:underline;color:blue;cursor:hand;" onclick="removeDeal(${deal.dealId })">删除订单信息</a></c:if>
		                <c:if test="${deal.isAccept==2 }"><a title="点击删除订单信息" style="height:40px;margin-top:20px;text-decoration:underline;color:blue;cursor:hand;" onclick="removeDeal(${deal.dealId })">删除订单信息</a></c:if>
		            </td>                                                 
		          </tr>          
	          </c:forEach>
	        </table>
	     </div>
	     <!-- 订单显示结束 -->
	     
         <div id="pageinfo">
	        共${pagedDeal.totalRecNum}条, 当前显示${pagedDeal.startIndex}-${pagedDeal.endIndex}条, 第${pagedDeal.pageNo}/${pagedDeal.totalPageNum}页
	           |
	           <c:if test="${pagedDeal.pageNo>1}">
	             <span class="linkspan" onclick="javascript:doQuery(1)">首页</span>&nbsp;
	           </c:if>
	           <c:if test="${pagedDeal.prePage}">
	             <span class="linkspan" onclick="javascript:doQuery(${pagedDeal.pageNo-1})">上一页</span>&nbsp;
	           </c:if>
	           <c:if test="${pagedDeal.nextPage}">
	             <span class="linkspan" onclick="javascript:doQuery(${pagedDeal.pageNo+1})">下一页</span>&nbsp;
	           </c:if>
	           <c:if test="${pagedDeal.pageNo!=pagedDeal.totalPageNum}">
	             <span class="linkspan" onclick="javascript:doQuery(${pagedDeal.totalPageNum})">末页</span>&nbsp;
	           </c:if>
	           |
	            到<input type="text" id="pageNo" size=4 style="text-align:right;" onkeypress="onlynumber();"/> 页
	           <button style="cursor:hand" onclick="javascript:doQuery($('pageNo').value);"> 跳 转 </button>   	           		           	           	              
	     </div>	     	     
     </div>
     <div id="showdeal" style="display:none">
	     <div id="title">订单详细信息</div>
	     <div id="display" style="border:1px solid gray"></div>
	 </div>
	 <div id="isaccept" style="display:none;" class="f_row">
	   <span style="font:x-large;">密码：</span><input type="password" id="password"/>
	   <button style="width:60px;cursor:hand;" onclick="submit();" title="请仔细核对过再点击">确定</button>
	 </div>
     <c:if test="${not empty error}">
      	   <script type="text/javascript">
        	 	alert('${error}');
         	</script>
    </c:if>
  </body>
</html>
