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
    <script type="text/javascript" src="<c:url value="/js/common.js"/>"></script> 
    <script type="text/javascript" src="<c:url value="/js/prototype.js"/>"></script>
  
  	<script type="text/javascript">
  	     //系统时间
  	     var serviceDate="";
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
	   //删除订单
	    function removeDeal(dealId,type,itemId)
	    { 
	      if(type=="deal")
	      {
	        if(confirm("确认要删除订单号为"+dealId+"的订单信息吗?"))
	        {   
				location.href="<c:url value="/action/dealMgr?act=del"/>&dealid="+dealId+"&rand="+Math.random();
	        }
	      }
	      else if(type=="dealItem")
	      {
	       
	        if(confirm("确认要删除订单条目编号为"+itemId+"的订单条目信息吗?"))
	        {  
				new Ajax.Request(
					encodeURI("/shop02/action/dealItemMgr?act=del&rand="+Math.random()+"&itemid="+itemId),
					{
					  method:"get",
					  onComplete:function(xhr)
					  {
					    if(xhr.responseText!=null)
					    {
					    	var dealId=parseInt(${sessionScope.dealId});
					    	getDealItem(dealId);
					    	alert(xhr.responseText);
					    }
					  }
					}
				);
	        }
	      }
	    }
	    
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
			         serviceDate=serviceDate+array[0];
			        
			         if(array[1]<10)
			         {
			             serviceDate=serviceDate+"-0"+array[1];
			         }
			         else
			         {
			         	 serviceDate=serviceDate+"-"+array[1];
			         }
			         if(array[2]<10)
			         {
			              serviceDate=serviceDate+"-0"+array[2];
			         }
			         else
			         {
			         	  serviceDate=serviceDate+"-"+array[2];
			         }
			   }
		}
	   });
	 }
	    //全局变量记录当前字段的值
	    var payValue="";
	    var receiveValue="";
	    var dealExamValue="";
	    //付款方式
	    function payChangeTdToSelect(object)
	    {
	     	var parentNode=object;
	     	var text=parentNode.firstChild;
	     	parentNode.removeChild(text);
	     	var select=document.createElement("SELECT");
	     	var option1=document.createElement("OPTION");
	     	var option2=document.createElement("OPTION");
	     	var option3=document.createElement("OPTION");
	     	option1.setAttribute("value","a");
	     	option2.setAttribute("value","b");
	     	option3.setAttribute("value","c");
	     	
	     	var textNode1=document.createTextNode("==请选择==");
	     	var textNode2=document.createTextNode("账户支付");
	     	var textNode3=document.createTextNode("网银支付");
	     	option1.appendChild(textNode1);
	     	option2.appendChild(textNode2);
	     	option3.appendChild(textNode3);
	     	select.appendChild(option1);
	     	select.appendChild(option2);
	     	select.appendChild(option3);
	        parentNode.appendChild(select);
	    }
	    function payChangeSelectToTd(object,dealId)
	    {
	       var parentNode=object;
	       var select=parentNode.firstChild;
	       var optionNodes=select.childNodes;
	       for(var i=0;i<optionNodes.length;i++)
	           if(optionNodes[i].selected)
	           {
	             if(optionNodes[i].value=="a")
	             {
	             	var node=document.createTextNode(payValue);
	            	parentNode.removeChild(select);
			       	parentNode.appendChild(node);
			       	return ;
	             }
	       
	             var textNode=optionNodes[i].firstChild;
	             var selectedValue=optionNodes[i].value;
	             var text=document.createTextNode(textNode.nodeValue);
	             break;
	           }
	           if(confirm("确定更改订单编号为："+dealId+"的付款方式为："+textNode.nodeValue+"吗？"))
	           {
	                new Ajax.Request(
		            encodeURI("/shop02/action/dealMgr?act=update&type=payPattern&seed="+Math.random()+"&selectedvalue="+selectedValue+"&dealid="+dealId),
		            {
		              method:"get",
		              onComplete:function(xhr){
		               var msg=xhr.responseText;
		               var array=msg.split("|");
		               if(array[0]=="input")
		               {
		                 parentNode.removeChild(select);
			       	     parentNode.appendChild(text);
			       	     alert("订单编号为："+dealId+"的付款方式成功更改为："+text.nodeValue+"！");
			       	   }
			       	    else if(array[0]=="error")
			       	    {
			       	       alert(array[1]);
			       	    }
		             }
		           });
	           }
	           else
	           {
	                var node=document.createTextNode(payValue);
	            	parentNode.removeChild(select);
			       	parentNode.appendChild(node);
	           }
	    }
	    function payPatternDbClickChange(object,dealId)
	    {
	       var parentNode=object;
	       
	       if(parentNode.firstChild.nodeName=="#text")
	       {
	           payValue=parentNode.firstChild.nodeValue;
	           payChangeTdToSelect(object)
	       }
	       else if(parentNode.firstChild.nodeName=="SELECT")
	       {   
	       		payChangeSelectToTd(object,dealId,payValue)
	       }
	    }
	    //收货方式
	    function receiveChangeTdToSelect(object)
	    { 
	     	var parentNode=object;
	     	var text=parentNode.firstChild;
	     	parentNode.removeChild(text);
	     	var select=document.createElement("SELECT");
	     	var option1=document.createElement("OPTION");
	     	var option2=document.createElement("OPTION");
	     	var option3=document.createElement("OPTION");
	     	var option4=document.createElement("OPTION");
	     	option1.setAttribute("value","a");
	     	option2.setAttribute("value","b");
	     	option3.setAttribute("value","c");
	     	option4.setAttribute("value","d");
	     	
	     	var textNode1=document.createTextNode("==请选择==");
	     	var textNode2=document.createTextNode("平邮");
	     	var textNode3=document.createTextNode("快递");
	     	var textNode4=document.createTextNode("ESM");
	     	option1.appendChild(textNode1);
	     	option2.appendChild(textNode2);
	     	option3.appendChild(textNode3);
	     	option4.appendChild(textNode4);
	     	select.appendChild(option1);
	     	select.appendChild(option2);
	     	select.appendChild(option3);
	     	select.appendChild(option4);
	        parentNode.appendChild(select);
	    }
	    function receiveChangeSelectToTd(object,dealId)
	    {
	       var parentNode=object;
	       var select=parentNode.firstChild;
	       var optionNodes=select.childNodes;
	       for(var i=0;i<optionNodes.length;i++)
	           if(optionNodes[i].selected)
	           {
	           	 if(optionNodes[i].value=="a")
	           	 {
	           	 	var node=document.createTextNode(receiveValue);
	                parentNode.removeChild(select);
			        parentNode.appendChild(node);
			        return ;
	           	 }
	             var textNode=optionNodes[i].firstChild;
	             var selectedValue=optionNodes[i].value;
	             var text=document.createTextNode(textNode.nodeValue);
	             break;
	           }
	        if(confirm("确定更改订单编号为："+dealId+"的收货方式为："+textNode.nodeValue+"吗？"))
	        {
		        new Ajax.Request(
	            encodeURI("/shop02/action/dealMgr?act=update&type=receivePattern&seed="+Math.random()+"&selectedvalue="+selectedValue+"&dealid="+dealId),
	            {
	              method:"get",
	              onComplete:function(xhr){
	              
	                 var msg=xhr.responseText;
	                 var array=msg.split("|");
	                 if(array[0]=="input")
	                 {
	                  	 parentNode.removeChild(select);
		       		     parentNode.appendChild(text);
		       		     alert("订单编号为："+dealId+"的收货方式成功更改为"+textNode.nodeValue+"！");
		       	     }
		       	     else if(array[0]=="error")
		       	     {
		       	        alert(array[1]);
		       	     }
	             }
	           });
	         }
	         else
	         {
	         	var node=document.createTextNode(receiveValue);
	            parentNode.removeChild(select);
			    parentNode.appendChild(node);
	         }
	    }
	    function receivePatternDbClickChange(object,dealId)
	    {
	       var parentNode=object;
	       
	       if(parentNode.firstChild.nodeName=="#text")
	       {
	           receiveValue=parentNode.firstChild.nodeValue;
	           receiveChangeTdToSelect(object)
	       }
	       else if(parentNode.firstChild.nodeName=="SELECT")
	       {
	       		receiveChangeSelectToTd(object,dealId,receiveValue)
	       }
	    }
	    //收货人信息详细
	    function getConsigneeInfoDetial(dealId)
	    {   
	    	var content=document.getElementById("update");
	    	var showconsignee=document.getElementById("showconsignee");
	    	var table=document.getElementById("wrapper");
	    	table.style.display="none";
	    	showconsignee.style.display="block";
	    	
	     	if(content.hasChildNodes())
	     	{
	     	   content.innerHTML="";
	     	}
	        new Ajax.Request(
            	encodeURI("/shop02/action/dealMgr?act=getDealInfo&type=part&seed="+Math.random()+"&dealid="+dealId),
            	{
            		 method:"get",
              		 onComplete:function(xhr){
              		  
              		    var result=xhr.responseText;
                		array=result.split("|");
                		if(array[0]=="input")
                		{
                		    var consigneeInfo=array[1];
                			var list=consigneeInfo.split(":");
                			var form=document.createElement("FORM");
					     	form.setAttribute("action","#");
					     	form.setAttribute("method","post");
				
					     	var div1=document.createElement("DIV");
					     	div1.style.margin="10px";
					     	var textNode1=document.createTextNode("收货人名：");
					     	var input1=document.createElement("INPUT");
					     	input1.setAttribute("type","text");
					     	input1.setAttribute("id","consigneename");
					     	input1.setAttribute("value",list[0]);
					     	div1.appendChild(textNode1);
					     	div1.appendChild(input1);
					     	
					     	var div2=document.createElement("DIV");
					     	div2.style.margin="10px";
					     	var textNode2=document.createTextNode("收货地址：");
					     	var input2=document.createElement("INPUT");
					     	input2.setAttribute("type","text");
					     	input2.setAttribute("id","consigneeaddress");
					     	input2.setAttribute("value",list[1]);
					     	div2.appendChild(textNode2);
					     	div2.appendChild(input2);
					     	
					     	var div3=document.createElement("DIV");
					     	div3.style.margin="10px";
					     	var textNode3=document.createTextNode("邮政编码：");
					     	var input3=document.createElement("INPUT");
					     	input3.setAttribute("type","text");
					     	input3.setAttribute("id","consigneecode");
					     	input3.setAttribute("value",list[2]);
					     	div3.appendChild(textNode3);
					     	div3.appendChild(input3);
					     	
					     	var div4=document.createElement("DIV");
					     	div4.style.margin="10px";
					     	var textNode4=document.createTextNode("联系方式：");
					     	var input4=document.createElement("INPUT");
					     	input4.setAttribute("type","text");
					     	input4.setAttribute("id","consigneetel");
					     	input4.setAttribute("value",list[3]);
					     	div4.appendChild(textNode4);
					     	div4.appendChild(input4);
					     	
					     	var div5=document.createElement("DIV");
					     	div5.style.margin="10px";
					     	var textNode5=document.createTextNode("电子邮箱：");
					     	var input5=document.createElement("INPUT");
					     	input5.setAttribute("type","text");
					     	input5.setAttribute("id","consigneeemail");
					     	input5.setAttribute("value",list[4]);
					     	div5.appendChild(textNode5);
					     	div5.appendChild(input5);
					     	
					     	var div6=document.createElement("DIV");
					     	div6.style.margin="10px";
					     	var submit=document.createElement("INPUT");
					     	submit.setAttribute("type","button");
					     	submit.setAttribute("value","保存");
					     	submit.onclick=function(){submitForm(submit,dealId)};
					     	submit.style.cursor="hand";
					     	submit.style.width="80";
					     	submit.style.align="center";
					     	submit.title="点击保存收货人信息";
					     	var back=document.createElement("INPUT");
					     	back.setAttribute("type","button");
					     	back.setAttribute("value","返回");
					     	back.onclick=function(){cleanChild(back)};
					     	back.style.cursor="hand";
					     	back.style.width="80";
					     	back.style.align="center";
					     	back.title="点击返回订单列表";
					     	div6.appendChild(submit);
					     	div6.appendChild(back);
					     	
					     	form.appendChild(div1);
					     	form.appendChild(div2);
					     	form.appendChild(div3);
					     	form.appendChild(div4);
					     	form.appendChild(div5);
					     	form.appendChild(div6);
					     	content.appendChild(form);
                		}
                		else if(array[0]=="error")
                		{
                			alert(array[1]);
                			return ;
                		}
             	}
           	});   	
	    }
	    //提交收货信息表单
	    function submitForm(object,dealId)
	    {
	    	var array=new Array();
	    	array[0]=document.getElementById("consigneename").value;
	    	array[1]=document.getElementById("consigneeaddress").value;
	    	array[2]=document.getElementById("consigneecode").value;
	    	array[3]=document.getElementById("consigneetel").value;
	    	array[4]=document.getElementById("consigneeemail").value;
	    	
	    	var selectedValue=array.join(":");
	    	
	    	if(confirm("确定要修改订单编号为："+dealId+"的收货人："+array[0]+"的信息吗？"))
	    	{
	    		 new Ajax.Request(
            		encodeURI("/shop02/action/dealMgr?act=update&type=consigneeInfo&seed="+Math.random()+"&selectedvalue="+selectedValue+"&dealid="+dealId),
            		{
            		  method:"get",
              		  onComplete:function(xhr){
                      	var msg=xhr.responseText;
                 		var message=msg.split("|");
                 		if(message[0]=="input")
                 		{    
                  			 alert("收货人的信息已成功更改！");
                  			 var consignee = document.getElementById("consignee"+dealId);
                  			 consignee.innerHTML=array[0];
	       	     		}
	       	    		else if(message[0]=="error")
	       	    		{
	       	        		alert(message[1]);
	       	     		}
             		}
           		});
	    	}
	    	else
	    	{
	    		updateInfo(dealId);
	    	}
	    }
	    //订单审核
	    function dealExamChangeTdToSelect(object)
	    {
	     	var parentNode=object;
	     	var text=parentNode.firstChild;
	     	parentNode.removeChild(text);
	     	var select=document.createElement("SELECT");
	     	var option1=document.createElement("OPTION");
	     	var option2=document.createElement("OPTION");
	     	var option3=document.createElement("OPTION");
	     	option1.setAttribute("value","a");
	     	option2.setAttribute("value","b");
	     	option3.setAttribute("value","c");
	     	
	     	var textNode1=document.createTextNode("==清选择==");
	     	var textNode2=document.createTextNode("已审核");
	     	var textNode3=document.createTextNode("审核未通过");
	     	option1.appendChild(textNode1);
	     	option2.appendChild(textNode2);
	     	option3.appendChild(textNode3);
	     	select.appendChild(option1);
	     	select.appendChild(option2);
	     	select.appendChild(option3);
	        parentNode.appendChild(select);
	    }
	    function dealExamChangeSelectToTd(object,dealId)
	    {
	       var parentNode=object;
	       var sibling=parentNode.nextSibling; //下一个兄弟节点
	      
	       var date=serviceDate;
	       var siblingChild=sibling.firstChild;
	       var select=parentNode.firstChild;
	       var optionNodes=select.childNodes;
	       
	       for(var i=0;i<optionNodes.length;i++)
	           if(optionNodes[i].selected)
	           {
		            if(optionNodes[i].value=="a")
		            {
		               var node=document.createTextNode(dealExamValue);
		               parentNode.removeChild(select);
				       parentNode.appendChild(node);
		               return ;
		            }
	               var textNode=optionNodes[i].firstChild;
	               var selectedValue=optionNodes[i].value;
	               var text=document.createTextNode(textNode.nodeValue);
	               break;
	           }
	        if(confirm("确定更改订单编号为："+dealId+"的状态为："+textNode.nodeValue+"吗？"))
	        {
		        new Ajax.Request(
	            encodeURI("/shop02/action/dealMgr?act=update&type=dealExam&seed="+Math.random()+"&selectedvalue="+selectedValue+"&date="+date+"&dealid="+dealId),
	            {
	              method:"get",
	              onComplete:function(xhr){
	              
	                 var msg=xhr.responseText;
	                 var array=msg.split("|");
	                 if(array[0]=="input")
	                 {
	                  	 parentNode.removeChild(select);
		       		     parentNode.appendChild(text);
		       		     sibling.removeChild(siblingChild);
		       		     var dateValue=document.createTextNode(date);
		       		     sibling.appendChild(dateValue);
		       		     alert("订单编号为："+dealId+"的订单状态成功更改为："+text.nodeValue+"!");
		       	     }
		       	     else if(array[0]=="error")
		       	     {
		       	        alert(array[1]);
		       	     }
	             }
	           });
	         }
	         else
	         {
	         	var node=document.createTextNode(dealExamValue);
	            parentNode.removeChild(select);
			    parentNode.appendChild(node);
	         }
	    }
	    function dealExamDbClickChange(object,dealId)
	    {
	       var parentNode=object;
	       
	       if(parentNode.firstChild.nodeName=="#text")
	       {
	           dealExamValue=parentNode.firstChild.nodeValue;
	           dealExamChangeTdToSelect(object);
	       }
	       else if(parentNode.firstChild.nodeName=="SELECT")
	       {
	       		dealExamChangeSelectToTd(object,dealId,dealExamValue);
	       }
	    }
	    //订单详细信息
	    function getDealItem(dealId)
	    {  
	     	var content=document.getElementById("display");
	    	var showDeal=document.getElementById("showdeal");
	    	var table=document.getElementById("wrapper");
	    	table.style.display="none";
	    	showDeal.style.display="block";
	    	
	     	if(content.hasChildNodes())
	     	{ 
	     	   content.innerHTML="";
	     	}
	     	new Ajax.Request(
	     	 encodeURI("/shop02/action/dealItemMgr?act=loadPageDealItem&rand="+Math.random()+"&dealid="+dealId),
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
	    function onMouseOver(object)
	    {
	       object.style.background="gray";
	    }
	    function noMouseOut(object)
	    {
	       object.style.background="white";
	    }
	    //刷新订单窗口
	    function refresh()
	    {
	     	window.location.href="<c:url value="/action/dealMgr?act=loadPageDeal"/>";
	    }
	</script>
	</head>
  <body onload="getSystemDate();">
    <div id="wrapper">
	     <div id="title">订单信息列表</div>
	     <div>
          <form action="<c:url value="/action/dealMgr?act=loadPageDeal"/>" method="post">
		   <span class="f_row">订单编号</span>
		   <span><input  class="f_row" type="text" name="qurydealid" value="${param.qurydealid }"/></span>
		   <span class="f_row">订单状态</span>
		   <span>
			 <select name="qurydealstatus">
			 <option value="">== 请选择 == </option>
			 <option  value="a" <c:if test="${param.qurydealstatus=='a'}">selected</c:if> >未审核</option>
			 <option  value="b" <c:if test="${param.qurydealstatus=='b'}">selected</c:if> >已审核</option>
			 <option  value="c" <c:if test="${param.qurydealstatus=='c'}">selected</c:if> >审核未通过</option>
		   </select>
		  </span>
		  <span class="f_row">接收状态</span>
		   <span>
			 <select name="quryisaccept">
			 <option value="-1">== 请选择 == </option>
			 <option  value="0" <c:if test="${param.quryisaccept=='0'}">selected</c:if> >未查收</option>
			 <option  value="1" <c:if test="${param.quryisaccept=='1'}">selected</c:if> >已查收</option>
			 <option  value="2" <c:if test="${param.quryisaccept=='1'}">selected</c:if> >申请退货</option>
		   </select>
		  </span>
		  <span class="f_row">下单日期</span>
          <span><input style="cursor:hand" type="text" id="calendar" class="calendar_input" readonly="readonly" name="qurydealdate" value="${param.qurydealdate}"/></span>
		  <script type="text/javascript" src="<c:url value="/js/date.js"/>" charset="gbk"></script> 
		  <span><input style="cursor:hand;width:60;text-align:center" class="f_row" type="submit" value="查找"/></span>
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
	            <th>订单状态</th>
	            <th>审核时间</th>
	            <th>下单时间</th>
	            <th>接收状态</th>
	            <th>详细信息</th>
	            <th>管理员</th>
	            <th>操作</th>                                                            
	          </tr>
	          <c:forEach var="deal" items="${pagedDeal.pageContent}">
		          <tr onmouseover="onMouseOver(this);" onmouseout="noMouseOut(this);">
		            <td>${deal.dealId }</td>
		            <td>${deal.dealSum }</td>
			        <td title="双击可修改支付方式" style="cursor:hand" ondblclick="payPatternDbClickChange(this,${deal.dealId});">
			         <c:choose>
			                <c:when test="${deal.payPattern=='b'}">账户支付</c:when>
			                <c:when test="${deal.payPattern=='c'}">网银支付</c:when>
			          </c:choose>
			        </td>
			        <td title="双击可修改收货方式" style="cursor:hand" ondblclick="receivePatternDbClickChange(this,${deal.dealId});">
			           <c:choose>
			                <c:when test="${deal.receivePattern=='b'}">平邮</c:when>
			                <c:when test="${deal.receivePattern=='c'}">快递</c:when>
			                <c:when test="${deal.receivePattern=='d'}">ESM</c:when>
			          </c:choose>
			        </td>
		            <td id="consignee${deal.dealId}" title="双击可查看并修改收货人信息" style="cursor:hand" ondblclick="getConsigneeInfoDetial(${deal.dealId});">
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
		            <td title="双击可修改订单状态" style="cursor:hand" ondblclick="dealExamDbClickChange(this,${deal.dealId});">
		              <c:choose>
			                <c:when test="${deal.dealStatus=='a'}">未审核</c:when>
			                <c:when test="${deal.dealStatus=='b'}">已审核</c:when>
			                <c:when test="${deal.dealStatus=='c'}">审核未通过</c:when>
			          </c:choose>
		            </td>
		            <td>
		              <c:if test="${empty deal.dealExamDate}">----</c:if> 
		              <c:if test="${not empty deal.dealExamDate}">${deal.dealExamDate}</c:if> 
		            </td>
		            <td>${deal.dealDate }</td>
		            <td>
		            	<c:choose>
			            	<c:when test="${deal.isAccept==0 }">未查收</c:when>
			            	<c:when test="${deal.isAccept==1 }">已查收</c:when>
			            	<c:when test="${deal.isAccept==2 }">申请退货</c:when>
			        	</c:choose>
		            </td>
		            <td title="双击可查询订单详细信息" style="cursor:hand" ondblclick="getDealItem(${deal.dealId});">订单详细</td>
		            <td>${sessionScope.admin.administratorName}</td>
		            <td>
		               <button title="点击可删除该订单下的所有信息" style="cursor:hand" onclick="javascript:removeDeal(${deal.dealId},'deal',1);"> 删 除 </button>
		            </td>                                                            
		          </tr>          
	          </c:forEach>
	        </table>
	     </div>
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
	 <div id="showconsignee"  style="display:none">
     	<div  id="title">收货人详细信息</div>
     	<div id="update" style="border:1px solid gray""></div>
     </div>
     <c:if test="${not empty error}">
      	   <script type="text/javascript">
        	 	alert('${error}');
         	</script>
     </c:if>
  </body>
</html>
