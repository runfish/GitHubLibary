<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
     <title>商品信息详细</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/application.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/list.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/form.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/newcss/style.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/jquery.jqzoom.css"/>">
	<script type="text/javascript" src="<c:url value="/js/jquery-1.6.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.jqzoom-core.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/common.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/prototype.js"/>"></script>	
	<script type="text/javascript">

       jQuery.noConflict();

    </script>
    
    
	    <script type="text/javascript">
	
		jQuery(document).ready(function() {
			jQuery('.jqzoom').jqzoom({
		            zoomType: 'standard',
		            lens:true,
		            preloadImages: false,
		            alwaysOn:false
		        });
			//$('.jqzoom').jqzoom();
		});
	
	
	</script>
	
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
    
    
	</script>
  <title>农大商城——${goods.goodsName}</title>
    
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
                         <li class="divider"><br></li>
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
        
        <c:if test="${not empty sctglist}">
        <c:forEach var="smallctg" items="${sctglist}" varStatus="status">
          <c:if test="${status.count mod 2 ==0}">
            <li class="odd"><a href="<c:url value="/action/goodsMgr?act=getsubgoodsbyid&subctgid=${smallctg.smallCtgId}&bigctgid=${bigctgid}"/>" target="_self">${smallctg.smallCtgName}</a></li>
        </c:if>
        <c:if test="${status.count mod 2==1}">
           <li class="even"><a href="<c:url value="/action/goodsMgr?act=getsubgoodsbyid&subctgid=${smallctg.smallCtgId}&bigctgid=${bigctgid}"/>" target="_self">${smallctg.smallCtgName}</a></li>
        </c:if>
         </c:forEach>
        </c:if>
        
         <c:if test="${not empty bigctglist}">
        <c:forEach var="bigctg" items="${bigctglist}" varStatus="status">
          <c:if test="${status.count mod 2 ==0}">
            <li class="odd"><a href="<c:url value="/action/goodsMgr?act=getgoodsbyid|${bigctg.ctgId}"/>"  target="_self">${bigctg.ctgName}</a></li>
        </c:if>
        <c:if test="${status.count mod 2==1}">
           <li class="even"><a href="<c:url value="/action/goodsMgr?act=getgoodsbyid|${bigctg.ctgId}"/>"  target="_self">${bigctg.ctgName}</a></li>
        </c:if>
         </c:forEach>
        </c:if>
        </ul>       
     <div class="banner_adds">
     
     <a href="#"><img src="/shop01/pics/images/bann2.jpg" alt="" title="" border="0" /></a>
     </div>    
       
   </div><!-- end of left content -->
    <!-- 商品类别分类结束 -->
    
    
   <div class="center_content">
   	<div class="center_title_bar">${goods.goodsName }</div>
    
    	<div class="prod_box_big">
        	<div class="top_prod_box_big"></div>
            <div class="center_prod_box_big">            
                  <div class="clearfix" id="content">
				  <div class="clearfix  product_img_big">
				        <a href="<c:url value="/action/goodsMgr?act=getimage"/>&goodsid=${goods.goodsId}"  class="jqzoom" rel='gal1'  title="${goods.goodsName}" style="text-decoration:none;float:left;">
				            <img src="<c:url value="/action/goodsMgr?act=getimage"/>&goodsid=${goods.goodsId}"  title="${goods.goodsName}"  style="border:0px;height:200px;width:190px;">
				        </a>
				  </div>
				</div>
                     <div class="details_big_box">
                         <div class="product_title_big">${goods.goodsName}</div>
                         <div class="specifications">
                            商品名称: <span class="blue">${goods.goodsName}</span><br />

                            商品价格: <span class="blue">￥${goods.goodsPrice}</span><br />
                            
                            商品库存数量: <span class="blue">${goods.goodsQty}件</span><br />
                         </div>
                        <div class="prod_price_big specifications">折扣信息:<span class="reduce">￥${goods.goodsPrice }</span> <span class="price">￥${goods.goodsPrice}</span></div>
                        <div class="specifications"style="50px;width:50px;">
                         <a href="#" class="addtocart" onclick="clickToCart(this,${goods.goodsId });"><span>加入购物车</span></a>
                        </div>
                       </div> 
                  
            </div>
            <div class="bottom_prod_box_big"></div> 
            <div>
            <span style="font-size:20px; color:red;">商品详情</span>
            <textarea rows="10" cols="68" style="text-align:left;font-size:14px;">${goods.goodsDesc }</textarea>
            </div>         
                                                 
        </div>  
     <!-- 商品列表结束 -->
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
