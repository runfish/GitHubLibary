<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>用户免费注册</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/passport_add.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/regist_add.css"/>">
   <script type="text/javascript">
   
   function $(id)
   {
       return document.getElementById(id);
   }
    //刷新验证码图片
    function changeImage(object)
    { 
       var node=object.parentNode;
       parentNode=node.childNodes[2];
       parentNode.firstChild.src='<c:url value="/action/checkCode?rand="/>'+Math.random();
    }
    //用户信息表单验证
    function checkForm()
    { 
    	if(!($("customername").value.match("^[a-zA-Z][a-zA-Z0-9]{5,11}")))
    	{  
    	   alert("请输入6-12位以字母开头的用户名！");
    	   return false;
    	}
    	if(!($("customerpwd").value.match("^[a-zA-Z]+[0-9]+.*$")&&$("customerpwd").value.length>=6))
    	{
    	   alert("请输入以字母开头的6位以上的密码，且至少包含数字和字母两种组合！");
    	   return false;
    	}
    	if($("customerpwd2").value == "")
    	{
    	   alert("密码确认不能为空，请输入确认密码！");
    	   return false;
    	}
    	if($("authcode").value == "")
    	{
    	   alert("验证码不能为空，请输入验证码！");
    	   return false;
    	}
    	
    	return true;
    }
   </script>
  </head>
  
  <body style="text-align:center">
  
  
  <!-- 头部开始 -->
   <div id="shortcut">
      <div class="w">
        <ul class="fr lh">
            <li class="fore1 ld" id="loginbar">您好，欢迎来到农大商城！<span><a href="/shop01/jsps/login/login.jsp">[登录]</a></span></li>
            <li class="fore2"><a href="/shop01/index.jsp" rel="nofollow">返回首页</a></li>
            <li class="fore2"><a href="#" rel="nofollow">企业服务</a></li>
            <li class="fore2"><a href="#" rel="nofollow">客户服务</a></li>
        </ul>
        <span class="clr"></span>
    </div>
  </div><!--shortcut end-->
  
  <!-- 头部结束 -->



  <!-- logo区 -->
  <div class="w" id="logo">
        <div><a href="#"><img src="/shop01/pics/images/logo_forlogin.png" alt="农大商城" width="1000px" height="60"></a></div>
  </div>
  <!-- logo区结束 -->
  
  <!-- 注册区 -->
  <div class="w" id="regist">
  
	<div class="mt">
	    <h2>注册新用户</h2>
	    <b></b><span style="text-align: right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='' href="#">English</a></span> <span>我已经注册，现在就&nbsp;<a href="/shop01/jsps/login/login.jsp" class="flk13">登录</a></span>
	</div>
	
	
	<hr>
	
	
	
	<div class="mc">
	
	<ul class="tab">
	</ul>
        <!-- 用户填写信息表单开始-->
		<form action="<c:url value="/action/customerMgr?act=add"/>" method="post" onsubmit="return checkForm();">	
		    <div class="form">
		
		        <div class="item">
		            <span class="label"><b class="ftx04">*</b>我的账户：</span>
		
		            <div class="fl">
		                <input id="customername" type="text" name="customername" value="${param.customername }"  height="25px" style="width=250px;">	        		                		             
		            </div>
		        </div>
		
		        <div id="o-password">
		            <div class="item">
		                <span class="label"><b class="ftx04">*</b>请输入密码：</span>
		
		                <div class="fl">
		                    <input id="customerpwd" name="customerpwd" height="25px" style="width=250px;  type="password">
		                </div>
		            </div>
		            <div class="item">
		                <span class="label"><b class="ftx04">*</b>请确认密码：</span>
		                <div class="fl">
		                    <input id="customerpwd2" name="customerpwd2" height="25px" style="width=250px; type="password">		                   
		                </div>
		            </div>
		        </div>
		
		        <div class="item">
		            <span class="label"><b class="ftx04">*</b>验证码：</span>
		
		            <div class="fl">
		                <input id="authcode"  name="authcode"  maxlength="6" type="text">
		                <label class="img">
		                    <img style="cursor:pointer;width:100px;height:26px;display:block;" src="<c:url value="/action/checkCode"/>"> 
		                </label>
		                <label class="ftx23" style="text-decoration:underline;color:blue;cursor:hand;" onclick="changeImage(this);">&nbsp;看不清？换一张</label>		                		                
		            </div>
		        </div>
		        <div class="item">
		            <span class="label">&nbsp;</span>
		            <input class="" id="registsubmit" value="同意以下协议，提交" type="submit" />
		        </div>
		        <div class="phone">
		            <img src="/shop01/pics/images/logo_add.jpg" width="220" height="180">
		        </div>
		    </div>
		</form>
<!--[if !ie]>form end<![endif]-->
     <!-- 表单结束 -->

   </div>
</div>
<!--  注册区结束--> 
    <div class="w">
    <div id="footer">
        <div class="links">
        <a href="" target="_blank">关于我们</a>
        |<a href="#" target="_blank">联系我们</a>
        |<a href="#" target="_blank">人才招聘</a>
        |<a href="#" target="_blank">广告服务</a>
        |<a href="#" target="_blank">友情链接</a>
        |<a href="#" target="_blank">English Site</a></div>
        <div class="copyright">北京市公安局朝阳分局备案编号110105014669&nbsp;&nbsp;|&nbsp;&nbsp;京ICP证070359号&nbsp;&nbsp;|&nbsp;&nbsp;互联网药品信息服务资格证编号(京)-非经营性-2011-0034<br><a target="_blank" href="#">音像制品经营许可证苏宿批005号</a>&nbsp;&nbsp;|&nbsp;&nbsp;出版物经营许可证编号新出发(苏)批字第N-012号&nbsp;&nbsp;|&nbsp;&nbsp;互联网出版许可证编号新出网证(京)字150号<br>Copyright&#169;2004-2012&nbsp;&nbsp;农大商城&nbsp;版权所有
        </div>
        <div class="authentication">
        <a href="" target="_blank"><img src="/shop01/pics/images/footer_1.gif" alt="经营性网站备案中心" width="108" height="40"></a>
        <a href="" tabindex="-1" id="urlknet" target="_blank"><img src="/shop01/pics/images/footer_2.gif" alt="可信网站" name="CNNIC_seal"  border="true"></a>
        <a href="" target="_blank"><img src="/shop01/pics/images/footer_4.png" width="112" height="40"></a></div>
    </div>
</div><!-- footer end --> 
<c:if test="${not empty error}">
      	   <script type="text/javascript">
        	 	alert('${error}');
         	</script>
     </c:if>
  </body>
</html>
