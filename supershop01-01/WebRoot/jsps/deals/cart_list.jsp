<%@ page language="java" import="java.util.*,java.io.File" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta name="data-spm" content="a1z0d"/>
    <title>我的购物车</title>
	
    <link rel="stylesheet" href="http://a.tbcdn.cn/??p/global/1.0/global-min.css,p/c2c/header-top-min.css,tbsp/tbsp.css?t=2012121220100214.css" /><!-- end vmc css 3.1-->
    <link rel="stylesheet" href="http://a.tbcdn.cn/apps/cart/120219/cart/cart-min.css" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/passport.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/regist.css"/>">
	<script type="text/javascript" src="<c:url value="/js/prototype.js"/>"></script>
    <script type="text/javascript">
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
	      login.innerHTML='<a href=href="<c:url value="/action/customerMgr?act=require&rand='+Math.random()+'"/>" target="_blank">'+userName+'</a>';
	   } 
	}
	//将商品移出购物车
	function removeGoods(index,object)
	{
	   if(confirm("确定要将该商品移除购物车吗？"))
	   {
	      object.href="<c:url value="/action/cartMgr?act=del&rand="/>"+Math.random()+"&index="+index;
	   }
	}
	//修改购物车内的商品数量
	function changeQty(index,type,object)
	{ 
	   new Ajax.Request(
	   encodeURI("/shop01/action/cartMgr?act=changeqty&rand="+Math.random()+"&index="+index+"&type="+type),
	   { 
	     method:'get',
	     onComplete:function(xhr){
	     
	         if(xhr.responseText!=null)
	         { 
	           var message=xhr.responseText.split("|");
	      
	           if(message[0]=="error")
	           {
	                alert(message[1]);
	           }
	           else
	           {
	           		if(type=="add")
		            {  
		            	var goodsQty=object.nextSibling.firstChild;
		            	goodsQty.value=message[1];
		            	var count=document.getElementById("count");
		                count.innerHTML=message[2]+" 件";
		                var total=document.getElementById("J_Total");
		                total.innerHTML=message[3];+" 元";
		                var smallTotal=document.getElementById("price"+index);
		                smallTotal.innerHTML=message[4];
		            }
		            else if(type=="sub")
		            {
		                var goodsQty=object.previousSibling.previousSibling;
		            	goodsQty.firstChild.value=message[1];
		            	var count=document.getElementById("count");
		                count.innerHTML=message[2]+" 件";
		                var total=document.getElementById("J_Total");
		                total.innerHTML=message[3];+" 元";
		                var smallTotal=document.getElementById("price"+index);
		                smallTotal.innerHTML=message[4];
		            }
		       }
	        }
	     }
	   }
	   );
	}
	//提交购物车信息
	function submitInfo()
	{
	   if(confirm("确定现在就要结算购物车中的商品吗？"))
	   {
	        
	   		window.location.href="<c:url value="/action/cartMgr?act=gotoconfirm"/>";
	   }
	}
    </script>
</head>
<body style="text-align:center;background:#E0FFFF;" onload="loginChange();">

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
  
	<!-- 购物车头部开始 -->
	
	<div id="page">
		<div id="content" class="grid-c">  
		  <div class="flow-steps">
	    	<ol class="num5">
	        <li class="current"><span class="first">1. 查看购物车</span></li><li><span>2. 确认订单信息</span></li><li><span>3. 商品付款</span></li><li><span>4. 确认收货</span></li>
	    	</ol>
	    </div>
	    
	<!-- 购物车头部结束 -->    		

	<!-- 购物车商品显示区开始 -->
	
	<div id="cart">
	 
	    <div class="status-wrapper">
	        
	        <div class="status-bar" id="status-bar">
	            <div class="J_StatusContent">
	                <div class="box">
	                    <div class="box-status" id="J_StatusInStatusBox">
	                          当前购物车商品数量：
	                     <span class="num" id="count">${mycart.cartItemAmount}件</span>
	                     </div>
	                </div>
	            </div>
	        </div>
	        
	  
	    <table cellspacing="0" cellpadding="0" class="order-table" id="J_CartEnable">
			
			<thead>
				<tr>
				    <th class="s-amount">编号</th>
					<th class="s-title">商品名称</th>
					<th class="s-amount">数量</th>
					<th class="s-price">单价(元)</th>
					<th class="s-total">小计(元)</th>
					<th class="s-del">操作</th>
				</tr>
			</thead>
					
		    <tbody class="J_Order">	 
		    <c:forEach var="cartItem" items="${mycart.cartList}" varStatus="status">   																 			
		      <tr>
		      <td><em class="J_Price">${status.index+1}</em></td>
			    <td class="s-title">
	    		    <div>
	    		      <img src="<c:url value="/action/goodsMgr?act=getimage"/>&goodsid=${cartItem.goodsId}" class="itempic">
	    				 <c:forEach var="goods" items="${goodslist}">
	    				 <c:if test="${cartItem.goodsId==goods.goodsId}"><a href="<c:url value="/action/goodsMgr?act=getgoodsdetail&bigctgid=index&goodsid=${goods.goodsId}"/>" title="查看商品详细信息" target="_blank" class="J_Del">${goods.goodsName} ${goods.goodsDesc}</a></c:if>
	    				 </c:forEach>
	    		      </div>
				 </td>
					
			     <td class="s-amount ">
			        <span style="font-size:20px;font-weight:bold;cursor:hand;background:#DCDCDC;width:0.6cm;height:0.3cm;" onclick="changeQty(${status.index},'add',this);"> + </span>
		            <span><input type="text" value="${cartItem.goodsQty}" class="text text-amount"/></span>
		            <span style="font-size:20px;font-weight:bold;cursor:hand;background:#DCDCDC;width:0.6cm;height:0.3cm;" onclick="changeQty(${status.index},'sub',this)";> - </span>
		         </td>
	            	
	             <td><em class="J_Price">${cartItem.goodsPrice}</em></td>
			     <td class="s-total"><em id="price${status.index}">${cartItem.goodsPrice*cartItem.goodsQty}</em></td>
			     <td class="s-del">
					<a href="#" title="将该商品从购物车删除" class="J_Del" onclick="removeGoods(${status.index},this);">删除</a>
			     </td>			
	 	     </tr>	
	 	     </c:forEach>
		   </tbody>
	   </table>
	   
	 <!-- 购物车商品显示区结束 -->
 
	 <!-- 购物车结算区开始 -->
	 
	    <div id="float-bar" class="float-bar default clearfix">
			
	        <button style="cursor:hand;background:#ffa500;color:white;" class="btn un-go" type="button" id="J_Go" onclick="submitInfo();">结　算</button>
	        <span class="total-price g_price">商品总价(不含运费)：<span>&yen;</span><em class="total" id="J_Total">${mycart.totalAmount }元</em></span>
	    </div>
	    
	 <!-- 购物车结算区结束 -->
		
	 
	</div>
	<c:if test="${not empty error}">
      	   <script type="text/javascript">
        	 	alert('${error}');
         	</script>
    </c:if>
</body>
</html>
