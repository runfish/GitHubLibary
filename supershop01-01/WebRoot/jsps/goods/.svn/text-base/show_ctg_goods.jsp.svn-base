<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>农大网上商城-综合网购首选，正品行货，机打发票，售后上门取件，省钱又放心 </title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/application.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/list.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/form.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/newcss/style.css"/>"/>
	<script type="text/javascript" src="<c:url value="/js/common.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/prototype.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/goods_validate.js"/>"></script>
	<script type="text/javascript">
	   //显示用户信息
	function loginChange()
	{ 
	  var login=document.getElementById("login");
	   var userName="${sessionScope.customer.customerName}";
	  
	   if(userName=="")
	   {  
	      login.innerHTML='<a href="<c:url value="/jsps/login/login.jsp"/>" class="nav2">用户登录</a>';
	   }
	   else
	   {  
	      login.innerHTML='<a href="<c:url value="/action/customerMgr?act=require&rand='+Math.random()+'"/>" class="nav2" target="_blank">欢迎'+userName+'</a>';
	      new Ajax.Request(
            encodeURI("/shop01/action/cartMgr?act=getmsg&rand="+Math.random()),
            {
              method:"get",
              onComplete:function(xhr){
                
                if(xhr.responseText!=null)
                {
                   var message=xhr.responseText;
                   var array=message.split('|');
 
                   var itemAcount=array[0].split(":")[0];
                   var total=array[0].split(":")[1];
                   var node1=document.getElementById("itemcount");
                   var node2=document.getElementById("total");
                   node1.innerHTML=itemAcount;
                   node2.innerHTML=total;
                      
                }
             }
           });
	   } 
	}
	//用户退出登入状态
	function goOut(object)
	{  
	   object.href="<c:url value="/action/securityMgr?act=logOut"/>";
	}
	
	//页面跳转设置
	      function doQuery(pageno,subctgid)

         {
           if(pageno<1 || pageno>${pagedGoods.totalPageNum})
           {
              alert("页号超出范围，有效范围：[1-${pagedGoods.totalPageNum}]!");
              ${'pageNo'}.select();
              return;
           }
           
           var f=document.forms[0];
           f.action=f.action+"&pageNo="+pageno+"&subctgid="+subctgid;
           f.submit();
           //location.href="<c:url value="/goodsMgr?act=loadall"/>&pageNo="+pageno;
         }
         
         
         function toget(bigctgid){
            location.href="<c:url value="/action/goodsMgr?act=getgoodsbyid"/>&bigctgid="+bigctgid;
         }
	//获得并显示我的订单
	function getMyDeal()
	{
	    var userName="${sessionScope.customer.customerName}";
	    if(userName=="")
	    {
	        alert("对不起请先登入账号才能查看我的订单信息！");
	        var mydeal=document.getElementById("mydeal");
	        mydeal.href="<c:url value="/jsps/login/login.jsp"/>";
	    }
	    else
	    {
	        var mydeal=document.getElementById("mydeal");
	        mydeal.href="<c:url value="/action/dealMgr?act=loadPageDeal"/>";
	    }
	}
	//获得并显示我的购物车
	function getMyCart()
	{
	    var userName="${sessionScope.customer.customerName}";
	    if(userName=="")
	    {
	        alert("对不起请先登入账号才能查看我的购物车信息！");
	        var mycart=document.getElementById("mycart");
	        mycart.href="<c:url value="/jsps/login/login.jsp"/>";
	    }
	    else
	    {
	        var mycart=document.getElementById("mycart");
	        mycart.href="<c:url value="/action/cartMgr?act=loadall"/>";
	    }
	}
   //点击加入购物车
   function clickToCart(object,goodsId)
   { 
     //object.href="<c:url value="/action/cartMgr?act=add&goodsid="/>"+goodsId;
      new Ajax.Request(
            encodeURI("/shop01/action/cartMgr?act=add&goodsid="+goodsId+"&rand="+Math.random()),
            {
              method:"get",
              onComplete:function(xhr){
                
                if(xhr.responseText!=null)
                {
                   var message=xhr.responseText;
                   var array=message.split('|');
                  
                   if(array[1]=='login')
                   {
                     alert(array[0]);
                     window.location.href="<c:url value="/action/securityMgr?act=gotoLogin"/>";
                   }
                   else
                   {
                      var itemAcount=array[1].split(":")[0];
                      var total=array[1].split(":")[1];
                      var node1=document.getElementById("itemcount");
                      var node2=document.getElementById("total");
                      node1.innerHTML=itemAcount;
                      node2.innerHTML=total;
                      alert(array[0]);
                   }
                }
             }
           });
   }
   
    //进入会员中心
    function gotoMember(object)
    {
       object.target='_blank';
       object.href='<c:url value="/action/customerMgr?act=gomember"/>';
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
	</script>
    <title>
    <c:forEach var ="ctg" items="${sctglist}">${ctg.smallCtgName}-</c:forEach>
    </title>
  </head>
  
    <body style="text-align:center;background:#E0FFFF;" onload="loginChange();">
     <div id="main_container">
     
     
     
     <!-- 查找框开始 -->
	<div class="top_bar">
    	<div class="top_search">
        	<div class="search_text"><a href="#">查 找</a></div>
            <input type="text" class="search_input" name="search" />
            <input type="image" src="/shop01/pics/images/search.gif" class="search_bt"/>
        </div>
    </div>
    <!-- 查找框结束 -->
    
    
    
    <!-- 网页顶部logo开始 -->
	<div id="header">
        
        <div id="logo">
            <a href="<c:url value="/index.jsp"/>"><img src="/shop01/pics/images/logo.png" alt="" title="" border="0" width="237" height="140" /></a>
	    </div>
        
        <div class="oferte_content">
        	<div class="top_divider"><img src="/shop01/pics/images/header_divider.png" alt="" title="" width="1" height="164" /></div>
 
            <div class="top_divider"><img src="/shop01/pics/images/header_divider.png" alt="" title="" width="1" height="164" /></div>
        	
        </div> <!-- end of oferte_content-->
    </div>
    <!-- 网页顶部logo结束 -->
    
    
    <!-- 网页顶部菜单导航条开始 -->
   <div id="main_content"> 
   
   
    <div id="menu_tab">
     <ul class="menu">     
                         <li><a href="/shop01/index.jsp" class="nav1"> 商城首页 </a></li>
                         <li class="divider"></li>

                         <li id="login"><a href="<c:url value="/action/securityMgr?act=gotoLogin"/>" class="nav2">用户登录</a></li>
                         <li class="divider"></li>
                         <li><a href="/shop01/jsps/customer/add_customer.jsp" class="nav3">免费注册</a></li>
                         <li class="divider"></li>
                         <li><a href="#" onclick="gotoMember(this);" class="nav3">会员中心</a></li>
                         <li class="divider"></li>
							<li><a id="mydeal" href="#" class="nav4" target="_top" onclick="getMyDeal();">我的订单</a></li>

							
							<li><a id="mycart" href="#" target="_top" class="nav4" onclick="getMyCart();">购物车</a></li>

							<li class="divider"><br></li>                         
                         <li><a href="#" target="_top" class="nav5" onclick="goOut(this);">退出登录</a></li>
       </ul>
    
    </div>
   
   </div>  
    <!-- 网页顶部菜单导航条结束 -->
    
    <!-- 网页主体部分开始 -->
    <div style=" background:white;width:1000px">
    
    

    <div id="left_content" class="left_content">
    <div class="title_box">商品类别分类</div>
    <!-- 商品类别分类开始 -->
        <ul class="left_menu">
        <c:forEach var="smallctg" items="${sctglist}" varStatus="status">
          <c:if test="${status.count mod 2 ==0}">
            <li class="odd"><a href="<c:url value="/action/goodsMgr?act=getsubgoodsbyid&subctgid=${smallctg.smallCtgId}&bigctgid=${bigctgid}"/>" target="_self">${smallctg.smallCtgName}</a></li>
        </c:if>
        <c:if test="${status.count mod 2==1}">
           <li class="even"><a href="<c:url value="/action/goodsMgr?act=getsubgoodsbyid&subctgid=${smallctg.smallCtgId}&bigctgid=${bigctgid}"/>" target="_self">${smallctg.smallCtgName}</a></li>
        </c:if>
         </c:forEach>
        </ul>       
     <div class="banner_adds">
     
     <a href="#"><img src="/shop01/pics/images/bann2.jpg" alt="" title="" border="0" /></a>
     </div>    
       
   </div><!-- end of left content -->
    <!-- 商品类别分类结束 -->
    
   <!-- 商品显示开始 -->
     <div class="f_row" style="text-align:left;">
        <form action="<c:url value="/action/goodsMgr?act=loadPageLastSubCtgGoods&bigctgid=${bigctgid}&subctgid=${subctgid}"/>" method="post" onSubmit="return validateEntry(this);"> 
          <span>商品名称：</span> 
            <input type="text" name="qurygoodsname" value="${param.qurygoodsname}"> 
          <span>商品价格:</span> 
	        <input type="text" class="text" name="qurymingoodsprice" size="4" value="${param.qurymingoodsprice}" onkeypress="onlynumber();"> -  
			<input type="text" class="text" name="qurymaxgoodsprice" size="4" value="${param.qurymaxgoodsprice}" onkeypress="onlynumber();">&nbsp; 
				     
         <span>商品是否有货：</span> 
        <select name="qurygoodsempty"> 
           <option value="">==请选择==</option> 
           <option value="1" <c:if test="${param.qurygoodsempty==1}">selected</c:if>>有</option> 
           <option value="2" <c:if test="${param.qurygoodsempty==2}">selected</c:if>>无</option> 
        </select> 
       <input style="width:60px" type="submit" value="查找">  
   </form>
   </div>
   
   
  <div class="center_content">
  
 	<!-- 商品显示列表开始 -->
   	<div class="center_title_bar">商品显示列表</div>
      <c:forEach var="goods" items="${pagedGoods.pageContent}" varStatus="status">
       <c:if test="${status.count==7}">
         <div class="center_title_bar">新品推荐</div>
	       <div class="prod_box">
	        	<div class="top_prod_box"></div>
	            <div class="center_prod_box">            
	                 <div class="product_img"><a href="<c:url value="/action/goodsMgr?act=getgoodsdetail&bigctgid=${bigctgid}&goodsid=${goods.goodsId}"/>" target ="_blank"><img src="<c:url value="/action/goodsMgr?act=getimage"/>&goodsid=${goods.goodsId}&randomNum=${randomNum}" alt="" title="" height="130" width="135" border="0" /></a></div>
	                 <div class="prod_price"><span class="reduce">￥${goods.goodsPrice}</span> <span class="price">￥${goods.goodsPrice }</span></div>                        
	            </div>
	            <div class="bottom_prod_box"></div>             
	            <div class="prod_details_tab">
	            <a href="#" onclick="clickToCart(this,${goods.goodsId });" title="header=[Add to cart] body=[&nbsp;] fade=[on]"><img src="/shop01/pics/images/cart.gif" alt="" title="" border="0" class="left_bt" /></a>
	            <a href="#" title="header=[Specials] body=[&nbsp;] fade=[on]"><img src="/shop01/pics/images/favs.gif" alt="" title="" border="0" class="left_bt" /></a>
	            <a href="#" title="header=[Gifts] body=[&nbsp;] fade=[on]"><img src="/shop01/pics/images/favorites.gif" alt="" title="" border="0" class="left_bt" /></a>           
	            <a href="<c:url value="/action/goodsMgr?act=getgoodsdetail&bigctgid=${bigctgid}&goodsid=${goods.goodsId}"/>" target ="_blank" class="prod_details">商品详情</a>            
	            </div>                     
	        </div>
       </c:if>
       <c:if test="${status.count != 7}">
          <div class="prod_box">
	        	<div class="top_prod_box"></div>
	            <div class="center_prod_box">            
	                 <div class="product_img"><a href="<c:url value="/action/goodsMgr?act=getgoodsdetail&bigctgid=${bigctgid}&goodsid=${goods.goodsId}"/>" target ="_blank"><img src="<c:url value="/action/goodsMgr?act=getimage"/>&goodsid=${goods.goodsId}&randomNum=${randomNum}" alt="" title="" height="130" width="135" border="0" /></a></div>
	                 <div class="prod_price"><span class="reduce">￥${goods.goodsPrice}</span> <span class="price">￥${goods.goodsPrice}</span></div>                        
	            </div>
	            <div class="bottom_prod_box"></div>             
	            <div class="prod_details_tab">
	            <a href="#" onclick="clickToCart(this,${goods.goodsId });" title="header=[Add to cart] body=[&nbsp;] fade=[on]"><img src="/shop01/pics/images/cart.gif" alt="" title="" border="0" class="left_bt" /></a>
	            <a href="#" title="header=[Specials] body=[&nbsp;] fade=[on]"><img src="/shop01/pics/images/favs.gif" alt="" title="" border="0" class="left_bt" /></a>
	            <a href="#" title="header=[Gifts] body=[&nbsp;] fade=[on]"><img src="/shop01/pics/images/favorites.gif" alt="" title="" border="0" class="left_bt" /></a>           
	            <a href="<c:url value="/action/goodsMgr?act=getgoodsdetail&bigctgid=${bigctgid}&goodsid=${goods.goodsId}"/>" target ="_blank" class="prod_details">商品详情</a>            
	            </div>                     
	        </div>
	      </c:if>
       </c:forEach>
 
     <!-- 商品列表结束 -->
         
     <!-- 商品分页区开始 -->
     <div style="width:450px;border-top:1px solid;">
         共${pagedGoods.totalRecNum}条, 当前显示${pagedGoods.startIndex}-${pagedGoods.endIndex}条, 第${pagedGoods.pageNo}/${pagedGoods.totalPageNum}页
	           |
	           <c:if test="${pagedGoods.pageNo>1}">
	             <span class="linkspan" onclick="doQuery(1,${subctgid})">首页</span>&nbsp;
	           </c:if>
	           <c:if test="${pagedGoods.prePage}">
	             <span class="linkspan" onclick="doQuery(${pagedGoods.pageNo-1},${subctgid})">上一页</span>&nbsp;
	           </c:if>
	           <c:if test="${pagedGoods.nextPage}">
	             <span class="linkspan" onclick="doQuery(${pagedGoods.pageNo+1},${subctgid})">下一页</span>&nbsp;
	           </c:if>
	           <c:if test="${pagedGoods.pageNo!=pagedGoods.totalPageNum}">
	             <span class="linkspan" onclick="doQuery(${pagedGoods.totalPageNum},${subctgid})">末页</span>&nbsp;
	           </c:if>
	           |
	            到<input type="text" id="pageNo" size=4 style="" onkeypress="onlynumber();"/> 页
	           <button onclick="doQuery($('pageNo').value,${subctgid});"> 跳 转 </button>		           		           	           	              
	 </div>	     	     
     <!-- 商品分页区结束 -->
     
     
     
     <c:if test="${not empty err}">
       <script type="text/javascript">
         alert('${err}');
       </script>
    </c:if> 
    
    
    
    
   </div>
   
   <!-- 商品显示结束 -->
   
     <!-- 购物车开始 -->
	   <div class="right_content">
	   		<div class="shopping_cart">
	        	<div class="cart_title">购物车</div>
	            
	            <div class="cart_details">
	            <span id="itemcount">0件 </span><br />
	            <span class="border_cart"></span>
	            总计: <span id="total" class="price">0元</span>
	            </div>
	            
	            <div class="cart_icon"><a href="#" title="header=[Checkout] body=[&nbsp;] fade=[on]"><img src="/shop01/pics/images/shoppingcart.png" alt="" title="" width="48" height="48" border="0" /></a></div>
	        </div>
	   <!-- 购物车结束 -->
   
     <div class="banner_adds">
     
     <a href="#"><img src="/shop01/pics/images/bann1.jpg" alt="" title="" border="0" /></a>
     </div>        
    </div>
    <!-- 网页主题部分结束 -->
    
   <!-- 网页底部开始 -->
   <div class="footer">
 
        <div class="left_footer">
        <img src="/shop01/pics/images/footer_logo.png" alt="" title="" width="170" height="49"/>
        </div>
        
        <div style=" padding-top:0px;color:gray">
         <%@ include file="/jsps/common/footer.jsp"%>
       </div>
   
   </div>                 
   <!-- 网页底部结束 -->
</div>
</div>
<!-- end of main_container -->     
 </body>
</html>
