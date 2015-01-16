<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>

<style type="text/css">
<!--
body {
	color: #333333;
	background-color: #fbfdff;
	font-size: 12px;
	font-family: "宋体", arial, Times, serif;
	line-height: 18px;
	word-break: break-all;
	margin: 0;
	padding: 0;
	height: 100%;
}

img {
	border: none;
}

table,td,tr,th {
	font-size: 12px;
}

ul,li {
	list-style-type: none;
	margin: 0;
	padding: 0;
}

.mTop {
	margin-top: 7px;
}

.bg {
	position: absolute;
	top: 50%;
	left: 50%;
	width: 800px;
	height: 495px;
	margin: -275px 0 0 -400px;
	border: 1px solid #4c93d0;
}
-->
</style>

<script type="text/javascript">
	
	function loginCheck(){
		try{
			var username = $('#j_username').val();
			var password = $('#j_password').val();
			username = $.trim(username);
			password = $.trim(password);
			if(!username || !password){
				//appBaseJS.html("messageShowPanel","账号或密码错误");
				if("messageShowPanel"){
					var showMsgPanel = $("#messageShowPanel");
					if(showMsgPanel.length >0){
						showMsgPanel.empty();
						showMsgPanel.html("账号或密码错误");
					}
				}
				return false;
			}	
		}catch(e){}
		return true;
	}
	
	function loginAct(_account,_password){
		var resultView = appBaseJS.getResultView("session/login",{account: _account, password: _password},false);
		if(resultView.code == "1"){
			top.location.reload();
		}else{
			appBaseJS.html("messageShowPanel",resultView.code + " : " + resultView.message);
		}
	}
	
	/*
	$.post("Ajax.aspx", { Action: "post", Name: "lulu" },     
   function (data, textStatus){        
    // data 可以是 xmlDoc, jsonObj, html, text, 等等.  
    //this;
    // 这个Ajax请求的选项配置信息，请参考jQuery.get()说到的this  
   alert(data.result);        }, "json");*/
	
</script>
</head>

<body>
	<div class="bg">
		<div
			style="background:url(<%=path%>/css/base/images/login-top.png) no-repeat 0 0; height:160px;"></div>
		<div
			style="background:#f2faff url(<%=path%>/css/base/images/login-mid.png) no-repeat center center; width:800px; height:300px; ">
			<div style="padding-left:320px;">
				<form action="/zspringmvc/login" onsubmit="return loginCheck();" method="post">


					<table width="280" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>&nbsp;</td>
							<td height="105">&nbsp;</td>
						</tr>
						<tr>
							<td height="34">用 户 名：</td>
							<td><input type="text" name="j_username" id="j_username"
								style="width:150px;" />
							</td>
						</tr>
						<tr>
							<td height="34">密 码：</td>
							<td><input type="password" name="j_password" id="j_password"
								style="width:150px;" />
							</td>
						</tr>
						<tr>
							<td height="32">&nbsp;</td>
							<td align="right"><input type="submit" class="JUI_ButtonCls"
								value="&nbsp;&nbsp;&nbsp;登&nbsp;&nbsp;录&nbsp;&nbsp;&nbsp;">
							</td>
						</tr>
						<tr>
							<td id="messageShowPanel" name="messageShowPanel" height="65"
								colspan="2" style="color:#F00; text-align:center;">&nbsp;</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div
			style="background: #66b4f8; line-height:31px; height:31px; margin-top:4px; color:#FFF">&nbsp;*仅支持IE8以上版本浏览器；推荐使用1024*768分辩率</div>
	</div>
</body>
</html>
