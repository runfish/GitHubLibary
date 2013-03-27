<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>订单信息填写</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/application.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/list.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/form.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/passport.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/regist.css"/>">
	
	
    <script type="text/javascript" src="<c:url value="/js/common.js"/>"></script> 
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
	      login.innerHTML='<a href="<c:url value="/action/customerMgr?act=require&rand='+Math.random()+'"/>" target="_blank">'+userName+'</a>';
	   } 
	}
	//收货人信息表单验证
	function checkForm()
	{ 
	   if($("consignee_name").value==""||$("consignee_name").value=="暂无")
	   {
	   		alert("收货人姓名不能为空，请输入收货人信息！");
	   		return false;
	   }
	   else if($("address").value==""||$("address").value=="暂无")
	   {
	   		alert("收货人住址不能为空，请输入收货人住址信息！");
	   		return false;
	   }
	   else if($("post_code").value==""||$("post_code").value=="暂无")
	   {
	   		alert("收货人所在地邮政编码不能为空，请输入收货人邮政编码信息！");
	   		return false;
	   }
	   else if(!$("post_code").value.match("^[1-9][0-9]{5}$"))
	   {
	   		alert("收货人所在地邮政编码格式不正确或数字串长度大于6位，例如：（福州）350001！");
	   		return false;
	   }
	   else if($("tel").value==""||$("tel").value=="暂无")
	   {
	   		alert("收货人联系方式不能为空，请输入收货人联系方式信息！");
	   		return false;
	   }
	   else if(!$("tel").value.match("[1-9][0-9]{10}|[0-9]{4}-[1-9][0-9]{7}"))
	   {      
	   		alert("联系方式输入格式不正确！手机号码为11位数字串如：18059047226,固定电话请在电话号码前加上区号如：0595-85486726！")
	   		return false;
	   }
	   else if($("email").value==""||$("email").value=="暂无")
	   {
	   		alert("收货人电子邮箱信息不能为空，请输入收货人电子邮箱信息！");
	   		return false;
	   }
	   else if(!$("email").value.match("^[a-zA-Z0-9]*[@].*\.com$"))
	   {
	   		alert("请输入正确的邮箱格式，如：hhg0012@163.com");
	   		return false;
	   }
	   else if($("pay_pattern").value=="a")
	   {
	   		alert("请选择付款方式！");
	   		return false;
	   }
	   else if($("receive_pattern").value=="a")
	   {
	   		alert("请选择收货方式！");
	   		return false;
	   }
	   return true;
	}
	//前往我的购物车
	function goToMyCart()
	{
	    var userName="${sessionScope.customer.customerName}";
	    if(userName=="")
	    {
	        alert("对不起请先登入账号才能查看我的购物车信息！");
	        window.location.href="<c:url value="/jsps/login/login.jsp"/>";
	    }
	    else
	    {
	         window.location.href="<c:url value="/action/cartMgr?act=loadall"/>";
	    }
	}
	
	//判断用户账户金额是否大于所购商品金额
	
	function validateaccount(goodsprice,account){
	
	    if(goodsprice > account){
	      
	        alert('您的账户余额不足 请您先充值在付款!');
	        
	        return false;
	    }
	
	}
	
   </script>
  </head>
  
  <body style="text-align:center;background:Snow;" onload="loginChange();">
  
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
  
  <!-- 订单主体开始 -->
	
	<div id="page" style="background:LightYellow;width:1000px;height:100%;">
	<br><br><br>
		<div>  
		  <div style="float:left;">
	        <h3><span style="padding:0,0.5cm,0,0.5cm;cursor:hand;" title="返回我的购物车" onclick="goToMyCart();">1. 查看购物车</span> >>
	        <span style="padding:0,0.5cm,0,0.5cm;background:Orange">2. 确认订单信息</span> >>
	        <span style="padding:0,0.5cm,0,0.5cm;">3. 商品付款</span> >>
	        <span style="padding:0,0.5cm,0,0.5cm;">4. 确认收货</span></h3>
	    </div>
 <br><br><br>
  <!-- 订单填写开始 -->
   <form action="<c:url value="/action/dealMgr?act=add"/>" method="post" onsubmit="return checkForm();">
   <input type="hidden" name="mycart_totalAmount" value="${mycart.totalAmount}">
   <div style="background:green;width:1000px;">
    <div style="color:white;font-size:20;text-align:left;border-bottom:1px solid black;">
      填写提交订单
    </div>
    <div style="background:#98FB98;color:green;text-align:left;border-bottom:1px solid black;">
      填写收货地址（温馨提示：请您认真详细填写收货姓名和地址，否则，您不能按时收到货！）
    </div>
    <div style="background:#F0E68C;text-align:left;border-bottom:1px solid black;">
     收货人名：
    <input id="consignee_name" type="text" name="consignee_name" value="${customer.customerName}">
    </div>
    <div style="background:#F0E68C;text-align:left;border-bottom:1px solid black;">
     收货地址：
    <input id="address" type="text" name="address" value="${customer.customerAddress}">
    </div>
    <div style="background:#F0E68C;text-align:left;border-bottom:1px solid black;">
     邮政编码：
    <input id="post_code" type="text" name="post_code" value="${customer.customerPostCode}">
    </div>
    <div style="background:#F0E68C;text-align:left;border-bottom:1px solid black;">
     联系方式：
    <input id="tel" type="text" name="tel" value="${customer.customerTel}">
    </div>
    <div style="background:#F0E68C;text-align:left;border-bottom:1px solid black;">
     电子邮箱：
    <input id="email" type="text" name="email" value="${customer.customerMail}">
    </div>
    <div style="background:#98FB98;color:green;text-align:left;border-bottom:1px solid black;">
        付款、发货
    </div>
    <div style="background:#F0E68C;text-align:left;border-bottom:1px solid black;">
        付款方式：
    <select id="pay_pattern" name="pay_pattern">
     <option value="a" <c:if test="${param.pay_pattern=='a'}">selected</c:if>>==请选择==</option>
     <option value="b" <c:if test="${param.pay_pattern=='b'}">selected</c:if>>账户支付</option>
     <option value="c" <c:if test="${param.pay_pattern=='c'}">selected</c:if>>网银支付</option>
    </select>
    </div>
    <div style="background:#F0E68C;text-align:left;border-bottom:1px solid black;">
     发货方式：
    <select id="receive_pattern" name="receive_pattern">
     <option value="a" <c:if test="${param.receive_pattern=='a'}">selected</c:if>>==请选择==</option>
     <option value="b" <c:if test="${param.receive_pattern=='b'}">selected</c:if>>平邮</option>
     <option value="c" <c:if test="${param.receive_pattern=='c'}">selected</c:if>>快递</option>
     <option value="d" <c:if test="${param.receive_pattern=='d'}">selected</c:if>>ESM</option>
    </select>
    </div>
    <div style="background:#F0E68C;text-align:left;border-bottom:1px solid black;">
       ※发货/运费<br>
    运输：由铁路、公路、航空运输(液体制剂不能走航空),直接发货给买家，买家如在一定时间内收不到货，请速与平台再联系。<br>
    时间：（如果选择网上支付）确认到款一天,备货一天，发货3-5天，1000公里以上要加2-3天<br>
    运费：全国免运费
    </div>
    <div style="background:#98FB98;color:green;text-align:left;border-bottom:1px solid black;">
    商品清单
    </div>
    <div style="background:#F0E68C;text-align:left;border-bottom:1px solid black;">
    <table id="listtable" style="margin:0">
     <tr>
      <th>编号</th>
      <th>名称</th>
      <th>类型</th>
      <th>价格</th>
      <th>数量</th>
      <th>小计</th>
    </tr>
    <c:forEach var="cartItem" varStatus="status" items="${mycart.cartList}">
      <tr>
       <td>${status.count}</td>
       <td>
	       <c:forEach var="goods" items="${goodslist}">
	        <c:if test="${cartItem.goodsId==goods.goodsId}">${goods.goodsName}</c:if>
	       </c:forEach>
	   </td>
	   <td>
	       <c:forEach var="smallCtg" items="${ctglist}">
	         <c:if test="${cartItem.goodsCtgId==smallCtg.smallCtgId}">${smallCtg.bigCategory.ctgName}->${smallCtg.smallCtgName}</c:if>
	       </c:forEach>
	   </td>
       <td>${cartItem.goodsPrice}</td>
       <td>${cartItem.goodsQty}</td>
       <td>${cartItem.goodsPrice*cartItem.goodsQty}</td>
      </tr>
     </c:forEach>
    </table>
    </div>
    <div style="background:#F0E68C;text-align:left;">
    <span style="font-size:20px;font:bold;">总计：</span><span>${mycart.totalAmount}元</span>
    </div>
    <div><input type="submit" value="确认订单并付款" onclick=" return validateaccount(${mycart.totalAmount},${customer.customerAccount});"></div>
   </div>  
  </form>
   <!-- 订单填写结束 -->
  </div>
   <!-- 订单主体结束 -->
   <c:if test="${not empty error}">
      	   <script type="text/javascript">
        	 	alert('${error}');
         	</script>
    </c:if>
  </body>
</html>
