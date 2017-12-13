<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="static/js/jquery.min.js"></script>
<style type="text/css">
body{
/* background-image: url("image/beibeijia.png");
background-size:cover; */
	
	margin:0;border:0;padding:0;
}
.a{
   width:300px;
   height:230px;
   background-image: url("image/sss.png");
   background-size: cover;
   margin-left:500px;
   margin-top:-100px;
}
.b{
margin-top: -50px;
}
input{
margin-left: 100px;
}
.lolo{
margin-left: -50px
}
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
	margin-top: 10%;
	display: block;
}
#tiao{
	width: 80%;
	height: 40%;
	
	
}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$("#denglu").hide(setTimeout(function(){
			$("#denglu").show(setTimeout(function(){
			},1500));
		},1500));
	});
</script>
</head>
<body>
<div style=" position:absolute; left:0px; top:0px; width:100%; height:100%">
	<img src="image/beibeijia.png" width="100%" height="100%"  style="z-index: -1;" />
	<div  style="border-radius:5%;border: 1px solid  #b1a28d;width: 30.2%; height:33%; 	position: absolute; margin-top: -29.5%;margin-left: 43.7%">
		<div id="zhongjiankuang">
			<img src="image/ren2.png" style="width: 25px;height: 24px;margin-top: 60%;">
			<img src="image/suo2.png" style="width: 25px;height: 24px;margin-top: 60%;">
		</div>
		<div id="zhongjiankuang1">
		<form action="${pageContext.request.contextPath}/userServlet" method="post">
			<input type="text" name="userName" placeholder="账号" id="yiyi" >
			<input type="password" name="passWord" placeholder="密码" id="yiyi">
			<input type="hidden" value="login" name="methodName">
			<div id="tiao">
			<input type="submit" value="登录"   id="niu"  style="margin-left: 10%;color:white">
			<a href="register.jsp"  ><input type="button" id="niu" value="注册" style="float: left;margin-left: 70%;margin-top: -10.5%;color:white"  ></a></div>
		</form>
			<!-- 判断用户名是否存在 -->
		<center style="margin-left:30px;margin-top:-155px;position:absolute;color:blue;">
			<%
			if(request.getAttribute("a")!=null){
				out.print(request.getAttribute("a"));
			}
			%>
		</center>
		</div>
	</div>
	
	
	
</div>
	
<!-- <div class="b"><img alt="" src="image/mao1.png" height="300px" width="300px"></div> -->

<%-- <div class="a"><br><br><br><br>
		<form action="${pageContext.request.contextPath}/userServlet" method="post">
			<input type="text" name="userName" placeholder="账号"><br><br>
			<input type="password" name="passWord" placeholder="密码"><br><br>
			<input type="hidden" value="login" name="methodName">
			<input type="submit" value="登录"  >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="register.jsp"><input type="button" value="注册" class="lolo"></a>
		</form>
		<br><br><br><br>
		
		<!-- 判断用户名是否存在 -->
		<%
		if(request.getAttribute("a")!=null){
			out.print(request.getAttribute("a"));
		}
		%>
	</div> --%>


</body>
</html>