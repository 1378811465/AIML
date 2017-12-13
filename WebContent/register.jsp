<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>注册</title>
<style type="text/css">
body{
/* background-image: url("image/ti.jpeg");
background-size:cover; */
margin:0;border:0;padding:0;
}
/* .a{
   width:300px;
   height:230px;
   background-image: url("image/zhu.png");
   background-size: cover;
   margin-left: 500px;
   margin-top: -100px;
}
.b{
margin-top: -60px;
}
#file{
position: absolute;
margin-top:80px;
margin-left:-15px;
color:blue;
} */
#zhongjiankuang{
	width: 6%;
	height: 80%;
	margin-left: 5%;
	margin-top: 6%;
	
	float:left;
}
#zhongjiankuang1{
	
	width: 86%;
	height: 80%;
	margin-left: 12%;
	margin-top: 6%;
	
	
}
#yiyi{
	width: 80%;
	height: 24px;
	margin-top: 3%;
	margin-left: 2%;
}
#niu{
	background-image: url("image/qwe1.png") ;
	background-size:cover;
	width: 70px;
	height: 30px;
	margin-top: 15%;
	display: block;
}
#tiao{
	width: 80%;
	height: 40%;
}
#file{
	margin-top: 3%;
	margin-left: 10%;
}
#touxiang{
position:absolute;
margin-top: -16%;
margin-left: -4%;
}
</style>
</head>
<body>
<div style=" position:absolute; left:0px; top:0px; width:100%; height:100%">
	<img src="image/beibeijia.png" width="100%" height="100%"  style="z-index: -1;" />
	<div style=" position:absolute; left:0px; top:0px; width:100%; height:100%">
	<img src="image/beibeijia.png" width="100%" height="100%"  style="z-index: -1;" />
	<div  style="border-radius:5%;border: 1px solid  #b1a28d;width: 30.2%; height:33%; 	position: absolute; margin-top: -29.5%;margin-left: 43.7%">
		<div id="zhongjiankuang">
			<img src="image/ren2.png" style="width: 25px;height: 24px;margin-top: 60%;">
			<img src="image/suo2.png" style="width: 25px;height: 24px;margin-top: 60%;">
		</div>
		<div id="zhongjiankuang1">
		<form action="${pageContext.request.contextPath}/userServlet?methodName=register"method="post"  enctype="multipart/form-data">
			<input type="text" name="userName" placeholder="账号" id="yiyi" >
			<input type="password" name="passWord" placeholder="密码" id="yiyi">
			<input type="hidden" value="login" name="methodName">
			<div id="tiao">
			<input  type="reset" value="重置"  id="niu"  style="margin-left: 10%;color:white">
			<a href="register.jsp"  ><input  type="submit" value="注册" id="niu" style="float: left;margin-left: 70%;margin-top: -10.5%;color:white"  ></a></div>
			<div id="touxiang">
				<input type="file" name="file" id="file">
			</div>
		</form>
		<a href="denglu.jsp" style="position:absolute;margin-left:-42%;text-decoration: none;font-size: 10px;margin-top: 1%">已有账号，点击登录!</a>
		<center style="color:blue;margin-top:-190px;margin-left:-150px;">
		<%
			if(request.getAttribute("a")!=null){
				out.print(request.getAttribute("a"));
			}
		%>
	</center>
		</div>
	</div>
</div>
<%-- <br><br><br>
<div class="b"><img alt="" src="image/mn.png" height="300px" width="300px"></div>
<div class="a"><br><br><br><br>
<center>
<form action="${pageContext.request.contextPath}/userServlet?methodName=register"method="post"  enctype="multipart/form-data">
	&nbsp;&nbsp;<input type="text" name="userName" placeholder="账号" onkeyup="value="/blog/value.replace(/["^d]/g,")  "onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^d]/g,'))"><br><br>
	&nbsp;&nbsp;<input type="password" name="passWord" placeholder="密码" onkeyup="value="/blog/value.replace(/[W]/g,")  "onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^d]/g,'))"><br><br>
	<input type="file" name="file" id="file">
	<input type="submit" value="注册" >
	<input type="reset" value="重置" >
	<!-- 判断用户名是否存在 -->
	
</form>
	<a href="denglu.jsp" style="color:gray;margin-left:20px;text-decoration: none;">已有账号，点击登录!</a>
</center>
</div>
	<center>
	<%
	if(request.getAttribute("a")!=null){
		out.print(request.getAttribute("a"));
	}
	%>
	</center> --%>
</body>
</html>