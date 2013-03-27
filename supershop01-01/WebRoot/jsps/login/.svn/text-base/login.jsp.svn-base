<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>登录农大商城</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/passport.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/regist.css"/>">
	<style type="text/css">
	    #button { 
				    width: 100px;
				    height: 30px;
				    background-image: url(../pics/images/login_btn.jpg) no-repeat 0px -31px;
				    font-size: 14px;
				    font-weight: bold;
				   
       } 
	</style>
	<script type="text/javascript">
	 //刷新验证码图片
    function changeImage(object)
    { 
       var node=object.parentNode;
       parentNode=node.childNodes[2];
       parentNode.firstChild.src='<c:url value="/action/checkCode?rand="/>'+Math.random();
    }
    //验证表单
    function checkForm()
    { 
       var loginName=document.getElementById("loginname").value;
       var loginPwd=document.getElementById("loginpwd").value;
       var authCode=document.getElementById("authcode").value;
       if(loginName=="")
       {
       	   alert("账户名不能为空，请输入账户名!");
           return false;
       }
       else if(loginPwd=="")
       {
           alert("账户密码不能为空，请输入账户密码!");
       	   return false;
       }
       else if(authCode=="")
       {
       	   alert("验证码不能为空，请输入验证码!");
       	   return false;
       }
    }
	</script>
  </head>
  
  <body style="text-align:center">
    <form id="formlogin" action="<c:url value="/action/securityMgr?act=login"/>" method="post" onsubmit="return checkForm();">
    <!-- 表单开始 -->
  <div id="shortcut">
    <div class="w">
        <ul class="fr lh">
            <li class="fore1 ld" id="loginbar">您好，欢迎来到农大商城！<span><a href="/shop01/jsps/login/login.jsp">[登录]</a></span></li>
            <li class="fore2"><span><a href="/shop01/jsps/customer/add_customer.jsp" class="link-regist">[免费注册]</a></span></li>
            <li class="fore2"><a href="/shop01/index.jsp">返回首页</a></li>
            <li class="fore2"><a href="#">企业服务</a></li>
            <li class="fore2"><a href="#">客户服务</a></li>
        </ul>
        <span class="clr"></span>
    </div>
</div><!--shortcut end--> 


    <div class="w" id="logo">
        <div><a href="#"><img src="<c:url value="/pics/images/logo_forlogin.png"/>" alt="农大商城" width="1000px" height="60"></a></div>
    </div>
   
    <input id="loginType" value="pinLogin" type="hidden">
    
    <div class="w" id="entry">
    
        <div class="mt"><h2>用户登录</h2><b></b><span style="text-align:right"></span></div>
        
       
        <div class="mc" style="padding-top:20px;">
       
          <!-- 用户登录区开始 -->
         
            <div class="form">
           
               <!-- 账户名开始 -->
                <div class="item">
                   <span class="label">账户名：</span>

                    <div class="fl">
                        <input id="loginname" name="loginname"  height="25px" style="width:250px;" value="${param.loginname}">
                    </div>
                </div>
                <!-- 账户名结束 -->
                
                <!-- 密码开始 -->
                <div class="item">
                    <span class="label">密码：</span>
               
                    <div class="fl">
                        <input id="loginpwd" name="loginpwd" type="password" height="25px" style="width:250px;"> 
                                   
                        <label><a href="#" class="flk13">&nbsp; &nbsp;找回密码</a></label>                     
                    </div>
                </div>
                 <!-- 密码结束 -->
                
                <!-- 验证码开始 -->
                <div class="item " id="o-authcode">
                    <span class="label">验证码：</span>

                    <div class="fl">
                        <input id="authcode" name="authcode"  type="text">
                        <label class="img">
                            <img style="width:100px;height:26px;display:block;" src="<c:url value="/action/checkCode"/>"  id="JD_Verification1">
                        </label>
                        <label onclick="changeImage(this);" class="ftx23" style="cursor:hand;color:blue;text-decoration:underline;">&nbsp;看不清？换一张</label>
                        <label id="authcode_succeed" class="blank invisible"></label>
                        <span class="clr"></span>
                        <span id="authcode_error"></span>
                    </div>
                </div>
                
                <!-- 验证码结束 -->
                
                <!-- 登录开始 -->
                <div class="item">
                    <span class="label">&nbsp;</span>
                    <input class="btn" id="button" value="登录"  type="submit" height="30" width="100"/>
                </div>
               
                 <!-- 登陆结束 -->
                
                
                <div class="item extra">
               
                 <!-- 这里可以放友情链接 -->
                   
                </div>
                 
            </div>
            <!-- 用户登录区结束 -->
            
            
            <!-- 用户注册区开始 -->
            <div id="guide">
            
               <h5>还不是农大商城用户？</h5>

                <div class="content">现在免费注册成为农大商城用户，便能立刻享受便宜又放心的购物乐趣。</div>
                
                <a href="/shop01/jsps/customer/add_customer.jsp" style="font-size:20px;">注册新用户</a>

                <div class="btns">
                    <a href="/shop01/jsps/customer/add_customer.jsp">企业用户注册</a>
                    <a href="/shop01/jsps/customer/add_customer.jsp">校园用户注册</a>
                </div>
                
                <div class="ept-enter">
                    <a href="/shop01/jsps/customer/add_customer.jsp">International Customers</a>
                </div>
                
                <div class="app"><a target="_blank" href=""></a></div>
                
                
            </div>
            
            <span class="clr"></span>
    
        <!-- 用户注册区结束 -->

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
