<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>


		<title>商品信息录入</title>

		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript" src="<c:url value="/js/prototype.js"/>"></script>
		<link rel="stylesheet" type="text/css"
			href="<c:url value="/css/form.css"/>" />

		<script type="text/javascript">
		
		
		function WidthCheck(s, n){   
			var w = 0;   
			for (var i=0; i<s.length; i++) {   
			   var c = s.charCodeAt(i);   
			 //单字节加1   
			   if ((c >= 0x0001 && c <= 0x007e) || (0xff60<=c && c<=0xff9f)) {   
			    w++;   
			   }   
			   else {   
			    w+=2;   
			   }   
			}   
			if (w > n) {   
			   return false;   
			}   
			return true;   
		}  
		
	
	    function validateEntry(inputFrm){
	        with(inputFrm){
	           //alert('asdsds');
	          //  alert(goodsctgid.value);
	           if(goodsname.value==""){
	               alert('商品名称不能为空，请重新录入');
	               ${'goodsname'}.select();
	               return false;
	           }
	           
	           if( WidthCheck(goodsname.value, 40)==false){
	             alert('请将商品名称长度控制在40个字符之内');
	             return false;
	           }
	           if(goodsprice.value==""){
	               alert('商品价格不能为空，请重新录入');
	               ${'goodsprice'}.select();
	               return false;
	           }
	           if(isNaN(goodsprice.value)){
	              alert('商品价格必须为数字，请重新录入');
	              ${'goodsprice'}.select();
	              return false;
	           }
	           if(goodsbigctgid.value==0){
	             alert('请选择商品的大类别');
	             return false;
	           }
	            if(subctgid.value==0){
	             alert('请选择商品的小类别');
	             return false;
	           }
	           
	           if(goodsqty.value==""){
	              alert('商品库存数量不能为空，请重新录入');
	              ${'goodsqty'}.select();
	              return false;
	           }
	           if(isNaN(goodsqty.value)||(goodsqty.value<0)){
	               alert('商品库存数量必须为大等于零的数字');
	               ${'goodsqty'}.select();
	               return false;
	           }
	           
	           if( WidthCheck(goodsdesc.value, 300)==false){
	              alert('请将商品信息详情长度控制在300个字符之内');
	              return false ;
	           }
	       
	        }
	    }
	//刷新图片
	    function changeImage(object)
	    {
	       var picUrl=getPath(object);
	       if(picUrl)
	       {
           		var goodsView=document.getElementById("goodsview");
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

	<body onload="buildSelector(0)">
		<div id="f_title">
			品信息登记
		</div>
		<form action="<c:url value="/action/goodsMgr"/>" method="post"
			onsubmit="return validateEntry(this);" enctype="multipart/form-data">
			<input type="hidden" name="act" value="create" />
			<input type="hidden" name="subctgid" />
			<input type="hidden" name="goodsadmin"
				value="${admin.administratorId}" />
			<div class="f_row">
				<span>商品名称:</span>
				<input type="text" name="goodsname" size="20"
					value="${param.goodsname}" />
			</div>

			<div class="f_row">
				<span>商品单价:</span>
				<input type="text" name="goodsprice" size="20"
					value="${param.goodsprice}" />
			</div>
			<div class="f_row">
				<span>商品大类别</span>
				<select name="goodsbigctgid"
					onchange="buildSelector(this.options[this.options.selectedIndex].value)">
					<option value="0">
						======请 选 择=====
					</option>
					<c:forEach var="bigcategory" items="${biglist}">
						<option value="${bigcategory.ctgId }">
							${bigcategory.ctgName}
						</option>
					</c:forEach>
				</select>
				<script type="text/javascript">
         
         
                  
            function buildSelector(bigctgid){
                  new Ajax.Request(
                    encodeURI("goodsMgr?act=getSubCtgs&seed="+Math.random()+"&bigctgid="+parseInt(bigctgid)),
                   {
                    method:"get",
                    onComplete:function(xhr){
                    
                      var subCtgStr=xhr.responseText;
                      if(xhr.responseText==""){
                        document.all.goodsctgid.options.length = 1;
                        return;
                      }
                      
                      if(bigctgid==0){
                      document.all.goodsctgid.options.length = 1;
                      return;
                      }
                     document.all.goodsctgid.options.length = 1; 
                     var optionStr=subCtgStr.split("|");
                     for(i = 0 ;i<optionStr.length;i++){
                         var opt=document.createElement("OPTION");
                         opt.value=optionStr[i].split(":")[0];
                         opt.text=optionStr[i].split(":")[1];
                         $("goodsctgid").add(opt);
                     }
                     
               }
    
        }
       );     
  }
         
         
         </script>


				<span>商品小类别:</span>
				<select name="goodsctgid"
					onchange="rembersubctg(this.options[this.options.selectedIndex].value)">
					<option value="0">
						==请选择==
					</option>
				</select>


				<script type="text/javascript">
          
          function rembersubctg(subctgid){
          document.forms[0].subctgid.value=subctgid;
       }
          
          
          
          
          
          </script>






			</div>
			<div class="f_row">
				<span>商品库存数量</span>
				<input type="text" name="goodsqty" size="20"
					value="${param.goodsqty}" />
			</div>

			<div id="imagepath" class="f_row">
				<span style="margin-left: 55px;"> <image id="goodsview"
						width="200px" height="160px"
						src="<c:url value="/pics/default.gif"/>" />
				</span>
				<br />

             <p style="color:red; font-size:14px;"> 请您先把需要上传的商品图片尺寸调整为(1280 * 1024), 谢谢 ！</p>

				<span>商品图片:</span>
				<input type="file" id="goodsimage" name="goodsimage" size="60"
					onchange="changeImage(this);" />
			  </div>

			<div class="f_row">
				<span>商品说明</span>
				<textarea rows="6" cols="50" name="goodsdesc">${param.goodsdesc}</textarea>

			</div>

			<div class="f_row">
				<input id="submit" type="submit" value="保存信息" />
			</div>
		</form>
		<c:if test="${not empty err}">
			<script type="text/javascript">
         alert('${err}');
       </script>
		</c:if>
	</body>
</html>
