<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>小V聊天间</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/jquery.min.js"></script>
<style>
   body{
		background-image: url("image/laozhebeijing4.png");
		background-repeat: no-repeat;
		position: absolute;
		background-size:100%;
	}
	#talk{
		width: 700px;
		height: 350px;
		overflow: auto;
		font-family: "华文新魏";
		overflow:auto;
        padding-top: 30px;
        margin-left:20px;
        margin-top:-20px;
       
  
	}
	.big{
		width: 760px;
		height: 570px;
		background: white;
		margin-left: 315px;
		margin-top: -540px;
		border-radius:20px;
		font-family: "华文新魏";
		opacity:0.7;
		z-index:5;
	}
	.a{
	    margin-top:-570px;
		margin-left:35px;
		opacity:1;
	}
	#say{
		width:430px;
		height:60px;
		border-radius:10px 10px 10px 10px;
		border: 1px solid #6d9eeb;
		outline: 0;
		margin-left:85px;
		margin-top:-225px;
	}
	#yangshixin{
		height:22px;
	    width:120px;
		font-size: 12px;
		background-color: #737a90;
		color: white;
		border-radius:  30px 30px 30px 30px; 
		text-align: center;
		font-family: "华文新魏";
		text-align: center;
		z-index:9;
		
	}
	#yangshixin:hover{
	    background-color: white;
		opacity: 0.9;
		color:  #737a90;

	}
	.fasong{
	border: none;
	position:absolute;
	left:900px; 
	top:460px;
	color: white;
	font-size: 20px;
	height:120px;
	width:120px;
	font-family: "华文新魏";
	background: none;
	border:none;
    outline:medium;
	}
	
	
	.anniu{
	margin-left: 580px;
	margin-top:-260px;
	width: 120px;
	height: 120px;
	}
	.d{
		width:550px;
		height:600px;
		border-radius:10px 10px 10px 10px;
		border: 1px solid #6d9eeb;
		margin-left: 780px;
		margin-top: -605px;
	}
	.e{
		width:200px;
		height:150px;
		border-radius:10px 10px 10px 10px;
		margin-left:50px;
		margin-top: 40px;
	}
	.f{
		width:100px;
		height:100px;
		border-radius: 50%;
		border: 1px solid #6d9eeb;
	}
	.g{
	    height:30px;
	    width:230px;
		font-size: 20px;
		display: block;
		border-radius:  30px 30px 30px 30px; 
		text-align: center;
		z-index:9;
		margin-left: 250px;
		font-family: "华文新魏";
		margin-left: 10px;
		margin-top:-70px;
		outline: 0;
		background-color: #737a90;
		color: white;
		
		
	}
	.g:hover{
	    background-color: white;
		opacity: 0.9;
		color:  #737a90;

	}
	#tuisong{
		margin-left:25px;
		margin-top:-35px;
		font-family: "华文新魏";
		width: 800px;
		font-size: 20px;
		padding-top: 5px;
	}
	#select_lishi{
		display:none;
		position:absolute;		
	    width: 260px;
        height: 390px;
        color:black;
       
        font-family: "华文新魏";
        font-size: 16px;
        overflow: scroll; 
		overflow-x:hidden;
		
		opacity: 1;
	}
	.z{
   		width: 280px;
   		height: 480px;  		
   		margin-top: -10px;
   		padding-top: 10px;
   		opacity: 0.7;
   		
   		
   		
	}
	.s{
   		font-family: "华文新魏";
   		font-size: 20px;
	}
	.x{
		
		height: 450px;
		width: 230px;
		margin-left: 1100px;
		margin-top: -25px;
		border-radius:15px;
		overflow: auto;
		
		opacity: 1;
		
	}
	#X{
	color:black;
	opacity: 1;
	}
	.y{
		font-family: "华文新魏";
		font-size: 17px;
		color: black;
		opacity: 1;
	}
	#wantSubscription{
        position:relative;
        z-index:1;
        width: 230px;
		height: 30px;
		font-size: 18px;
		display: block;
		transition:box-shadow 0.3s ease 0s;
		background-color:#737a90;
		color:#fff;
		border-radius:  30px 30px 30px 30px; 
		text-align: center;	
		z-index:9;
		margin-left: 1089px;
        margin-top: -550px;
		font-family: "华文新魏";
		outline: 0;
	}
	#wantSubscription:hover{
		opacity: 0.9;
		background: #fff;
		color: #737a90;
		box-shadow:0 0 0 0px #D8D8D8  inset;
	
		outline: 0;
	}
	#user_dy{
		display:none;
		list-style:none;
		margin-top:65px;
	}
	#dy_con{
		list-style:none;
		margin-top:65px;
	}
	#dy_conTwo{
		list-style:none;
		margin-top:65px;
	}
	#user_dyTwo{
		display:none;
		list-style:none;
		margin-top:65px;
	}
	#subscription{
		position:absolute;
		display:none;
		margin-left:1150px;
		margin-top:100px;
	}
	#dingyue{
		width: 80px;
		height: 20px;
		background:white;
		color:blue;
		border-radius: 15px;
		margin-left: -20px;
		margin-top: 460px;
		position: absolute;	
		
	}
	#my_dingyue{
		width: 80px;
		height: 20px;
		background:white;
		color:blue;
		border-radius:15px;
		margin-left: 80px;
		position: absolute;
		margin-top: 460px;
		outline: 0;
		opacity: 1;
	}
	#a{
		position:relative;
	}
	a{
		text-decoration: none;
	}
	a:link{
		color: blue;
	}
	a:visited{
		color:blue;
	}
	.weixiaok{
		border-radius: 50%;		
	}
	.duihuakuang{
		width:790px;
		height:300px;
		margin-left:-120px;
		margin-top: 540px;
	}
	.maobi{
	height: 25px;
	width: 25px
	}
    .shu{
    height: 50px;
    width: 50px;
    }
    .p{
    margin-top: -22px;
    margin-left: 25px;
    opacity:1;
    }
    strong{
    color: white;
    font-size: 20px;
    }
    .hy{
    
    }
    .zhou{
    height: 180px;
    width: 500px;
    position: absolute;
    top:180px; 
    left: -80px
    }
    #applyFOr{
    	position:absolute;
    	margin-left:90px;
    	margin-top:-500px;
    }
</style>
<script type="text/javascript">
var url = '<%=request.getContextPath()%>/aimlServlet';

	$(document).ready(function(){
		$("#bt").click(function(){
			selectHistor('<%=request.getSession().getAttribute("z") %>');
			if(document.getElementById("bt").value == "查看我的历史记录"){
				$("#select_lishi").show();
				document.getElementById("bt").value = "收缩我的历史记录";
			}else{
				$("#select_lishi").hide();
				document.getElementById("bt").value = "查看我的历史记录";
			}
		});
		$('#talk').hover(
			    function(){
			        $('body').css('overflow', 'hidden');
			    },
			    function(){
			        $('body').css('overflow', 'auto');
			    })
  	});
	function initBot(){
		wantSubscription('<%=request.getSession().getAttribute("z") %>');
		if(say != ""){
			var userName = $("#userName").val();
			$.get(url+"?say=welcome&userName&userId="+userName,callback);
		}
	}
	function sendSay(){
		if(say != ""){
			var say = $("#say").val();
			callback("you say:"+"<br />"+say)
			$("#say").val("");
			$.get(url+"?say="+say,callback);
		}
	}
	function callback(data){
		<!--dataSmiple = date+"...";-->//将查询的内容运用方法只选取前100字进行输出
		var content = $("#talk").html();
		if(content == '' || content == undefined){
			$("#talk").html(data);
		}else{
			<!--$("#talk").html(content + '<br />'+"<a href='http://localhost:8080/TestAIML/denglu.jsp?data='" +data+"' >"+dataSmiple+"</a>");-->
			$("#talk").html(content + '<br />'+"<img alt='' src='image/mao.png' class='maobi'>"+data);

			selectHistor('<%=request.getSession().getAttribute("z") %>');
		}
	}
	$(function(){
		var talk = $('#talk');
		talk.bind('DOMNodeInserted', function(e) { 
			var offsetHeight = $('#talk').get(0).scrollHeight;
			$('#talk').scrollTop(offsetHeight); 
		}); 
	});
	document.onkeypress = function(){
		if(event.keyCode == 13) {
		sendSay();
		}
	}
	$(document).ready(function(){
		$("#dingyue").click(function(){
			if(document.getElementById("dingyue").value == "查看订阅"){
				$("#dy_con").show();
				$("#user_dy").hide();
				document.getElementById("tishi").innerHTML = "-请选择-";
			}
		});
	});
	$(document).ready(function(){
		$("#my_dingyue").click(function(){
			if(document.getElementById("my_dingyue").value == "我的订阅"){
				$("#user_dyTwo").show();
				$("#dy_conTwo").hide();
				document.getElementById("qx_tishi").innerHTML = "-请选择-";
			}
		});
	});
	$(document).ready(function(){
		$("#dingyue").click(function(){
			if(document.getElementById("dingyue").value == "查看订阅"){
				$("#dy_conTwo").show();
				$("#user_dyTwo").hide();
			}
		});
	});
	$(document).ready(function(){
		$("#my_dingyue").click(function(){
			if(document.getElementById("my_dingyue").value == "我的订阅"){
				$("#user_dy").show();
				$("#dy_con").hide();
			}
		});
	});
	$(document).ready(function(){
		$("#wantSubscription").click(function(){
			if(document.getElementById("wantSubscription").value == "我要订阅"){
				$("#subscription").show();
				$("#x").hide();
				document.getElementById("wantSubscription").value = "我要看订阅";
			}else{
				$("#subscription").hide();
				$("#x").show();
				document.getElementById("wantSubscription").value = "我要订阅";
			}
		});
	});
	function selectHistor(name){
	  $.ajax({
		  	data:{name:name},
			type:'post',
			url:"${pageContext.request.contextPath}/selectHistor?methodName=selectHistor",
			success:function(json){
			    $("#select_lishi").empty();
			    $("#select_lishi").empty();
				for(var i=0;i<json.length;i++){
				    var id = json[i].id;
				    var name = "小V：";
				    var user = json[i].username;
				    var problem = json[i].problem;
				    var answer = json[i].answer;
				    var time = json[i].time;
				    $("#select_lishi").append("<a>"+user+"：</a><a>"+time+"</a><br><a class='dd-handle'>"+problem+"</a><br>");
				    $("#select_lishi").append("<a>"+name+"</a><a>"+time+"</a><br><a class='dd-handle'>"+answer+"</a><br>" );
				    $("#az").scrollTop($("#az")[0].scrollHeight);
				}
			},
			error:function(){
				alert("请求失败");
			}
		});
	}
	
	function DingYue(name){
		var xmlhttp;
		if (window.XMLHttpRequest)
		  {// code for IE7+, Firefox, Chrome, Opera, Safari
		  xmlhttp=new XMLHttpRequest();
		  }
		else
		  {// code for IE6, IE5
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		xmlhttp.onreadystatechange=function()
		  {
		  if (xmlhttp.readyState==4 && xmlhttp.status==200)
		    {
		    document.getElementById("tishi").innerHTML=xmlhttp.responseText;
		    }
		  }
		xmlhttp.open("post","${pageContext.request.contextPath}//userServlet?methodName=dingyue&name="+name,true);
		xmlhttp.send();
	}
	
	//Ajax取消订阅
	function qx_dingyue(id){
		  $.ajax({
			  	data:{id:id},
				type:'post',
				url:"${pageContext.request.contextPath}/selectHistor?methodName=qx_dingyue",
				success:function(json){
					$("#mingzi").empty();
				    $("#content").empty();
					for(var i=0;i<json.length;i++){
					    var id = json[i].id;
					    var name = json[i].name;
					    var data = json[i].data;
					    $("#mingzi").append("<a>"+name+"</a><br>");
					    $("#content").append("<a onclick='qx_dingyue(\""+id+"\")'>取消订阅</a><br>" );
					    $("#user_dy").scrollTop($("#user_dy")[0].scrollHeight);
					}
					document.getElementById("qx_tishi").innerHTML="取消模板成功！";
				},
				error:function(){
					alert("请求失败");
				}
			});
		
		}
	function my_dingyue(name){
		  $.ajax({
			  	data:{name:name},
				type:'post',
				url:"${pageContext.request.contextPath}/selectHistor?methodName=my_dingyue",
				success:function(json){

				    $("#mingzi").empty();
				    $("#content").empty();
					for(var i=0;i<json.length;i++){
					    var id = json[i].id;
					    var name = json[i].name;
					    var data = json[i].data;

					    $("#mingzi").append("<a>"+name+"</a><br>");
					    $("#content").append("<a onclick='qx_dingyue(\""+id+"\")'>取消订阅</a><br>" );
					    $("#user_dy").scrollTop($("#user_dy")[0].scrollHeight);
					}
				},
				error:function(){
					alert("请求失败");
				}
			});
		}
	$(document).ready(function(){
		$("#queren").click(function(){
			if(document.getElementById("queren").value == "确认"){
				$("#tanchuang").hide();
			}else{
				$("#tanchuang").hide();
			}
		});
	});
	$(document).ready(function(){
				$("#tanchuang").hide();
				$("#xiugai").hide();
				$("#xiugaiTanChaung").hide();
	});
	$(document).ready(function(){
		$("#qx").click(function(){
			if(document.getElementById("qx").value == "取消"){
				$("#tanchuang").hide();
			}else{
				$("#tanchuang").hide();
			}
		});
	});
	$(document).ready(function(){
		$("#shenqing").click(function(){
				$("#tanchuang").show();
				
		});
	});
	$(document).ready(function(){
		$("#touxiang").click(function(){
				$("#xiugaiTanChaung").show();
				
		});
	});
	$(document).ready(function(){
		$("#xiugaiTiao").click(function(){
				$("#xiugai").show();
				$("#xiugaiTanChaung").hide();
				
		});
	});
	$(document).ready(function(){
		$("#exit").click(function(){
				$("#xiugaiTanChaung").hide();
				
		});
	});
	$(document).ready(function(){
		$("#qxXiugai").click(function(){
				$("#xiugai").hide();
				
		});
	});
	
	function applyFor(name){
		  $.ajax({
			  	data:{name:name},
				type:'post',
				url:"${pageContext.request.contextPath}/selectHistor?methodName=applyFor",
				success:function(json){
					alert("申请成功，请耐心等待！")
				},
				error:function(){
					alert("请求失败");
				}
			});
		}
	function wantSubscription(name){
		  $.ajax({
			  	data:{name:name},
				type:'post',
				url:"${pageContext.request.contextPath}/selectHistor?methodName=my_dingyue",
				success:function(json){

				    $("#dingyue_name").empty();
				    $("#dingyue_data").empty();
					for(var i=0;i<json.length;i++){
					    var id = json[i].id;
					    var name = json[i].name;
					    var data = json[i].data;

					    $("#dingyue_name").append("<a>"+name+"</a><br><br>");
					    $("#dingyue_name").append("<a>"+data+"</a><br><br>" );
					    $("#x").scrollTop($("#x")[0].scrollHeight);
					}
				},
				error:function(){
					alert("请求失败");
				}
			});
		}
	function xiugai(){
		var password = $("#password").val();
		  $.ajax({
			  	data:{password:password},
				type:'post',
				url:"${pageContext.request.contextPath}/selectHistor?methodName=xiugaiPassword",
				success:function(json){
					if(json=='成功'){
						alert("修改密码成功！")
						$("#xiugai").hide();
					}else{
						alert("用户密码只能用3-12位的字母和数字组成!")
					}
					
				   
				},
				error:function(){
					alert("请求失败");
				}
			});
		}

</script>
<meta http-equiv="Expires" content="0">  
<meta http-equiv="kiben" content="no-cache">
</head>
<body onload="initBot()">

<div id="subscription">
<input type="button" value="查看订阅" id="dingyue" name="methodName">
<input type="button" value="我的订阅" id="my_dingyue" name="methodName" onclick="my_dingyue('<%=request.getSession().getAttribute("z") %>')">
	<div id="dy_con">
		<table>
		<c:forEach items="${select}" var="stList">
			<tr>
				<td>${stList.name}</td>
				<td style="color:blue;" onclick = "DingYue('${stList.name}')">订阅</td>
			</tr>
		</c:forEach>
			<%
			if(request.getAttribute("a")!=null){
				out.print(request.getAttribute("a"));
			}
			%>
			<p id="tishi">-请选择-</p>
		</table>
	</div>
	<div id="dy_conTwo">
		<table>
		<c:forEach items="${dylist}" var="stList">
			<tr>
				<td>${stList.name}</td>
				<td style="color:blue;" onclick = "DingYue('${stList.name}')">订阅</td>
			</tr>
		</c:forEach>
		</table>
	</div>
	<div id="user_dy">
		<table>
		<c:forEach items="${findAll}" var="fdList">
			<tr>
				<td><div id="mingzi"></div></td>
				<td style="color:blue;"><div id="content"></div></td>
			</tr>
			<input type="hidden" value="${fdList.name}" name = "qx_dingyue">
		</c:forEach>
		<p id="qx_tishi">-请选择-</p>
		</table>
	</div>
	<div id="user_dyTwo">
		<table>
		<c:forEach items="${my_dylist}" var="fdList">
			<tr>
				<td>${fdList.name}</td>
				<td style="color:blue;"><a href="${pageContext.request.contextPath}/userServlet?methodName=qx_dingyue&name=${fdList.name}">取消订阅</a></td>
			</tr>
			<input type="hidden" value="${fdList.name}" name = "qx_dingyue">
		</c:forEach>
		</table>
	</div>
</div>
<div>
   <div class="e">
      <center>
      <img id="touxiang" src="${pageContext.request.contextPath }/image/<%=request.getSession().getAttribute("img") %>" style="width:80px;height:80px;margin-left:-152px;margin-top:-10px;border-radius:50%;position:absolute;border: 3px solid white;">
      
      <div class="weixiao"></div><br>
         <div class="hy"><strong>欢迎您&nbsp;<span><% out.print(request.getSession().getAttribute("z")); %></span></strong></div>
         <div style="color:white;" id="shenqing"><% out.print(request.getSession().getAttribute("quanxian")); %></div>
      </center>
	</div>
	<input type="button" value="查看我的历史记录" class="g" id="bt" >
	<div class="z" id="az">
	   <div id="select_lishi">
		  
	   </div>
	</div>
</div>
<!-- 聊天 -->
<div id="xiugaiTanChaung" style="width:160px;height:100px;background-color:gray;margin-left:50%;margin-top:-25%;z-index:1;position:absolute;">
	<div style="margin-left:25px;margin-top:20px;">
	<input type="button" value="修改密码" id="xiugaiTiao" style="width:100px;">
	<input type="button" value="退出" id="exit" style="width:100px;margin-top:10px;">
	</div>
</div>
<div id="xiugai" style=" width:200px;height:80px;background-color:gray;margin-left:50%;margin-top:-25%;z-index:1;position:absolute;">
	<div style="margin-left:20px;">
		<input type="text" placeholder="新密码" id="password" style="margin-top:10px;">
		<input type="button" value="确认" onclick="xiugai()" style="margin-left:10px;margin-top:20px;">
		<input type="button" value="取消" id="qxXiugai" style="margin-left:100px;margin-top:-20px;">
	</div>
	<%
		if(request.getAttribute("a")!=null){
			out.print(request.getAttribute("a"));
		}
	%>
</div>
<div id="tanchuang" style="width: 250px; height:130px; background-color: #D9D9D9;margin-left:40%;margin-top:-25%;position:absolute;z-index:1;">
   <div class="form-group">
   <br><br>
      <label style="float:left;">你是否需要申请升级为高级用户？</label>
   </div>
   <br><br><br>
   <div style="margin-left:60px;">
		     <input type="button" class="btn btn-sm btn-primary " style="border-radius:20%; background-color: white; width: 60px;" id="queren" value="确认" onclick = "applyFor('<%=request.getSession().getAttribute("z") %>')">
		     <input type="button" class="btn btn-sm btn-primary " style="border-radius:20%; background-color: white; width: 60px;" id="qx" value="取消" onclick = "qx_applyFor()">
   </div>
</div>


<div class="big">
	
   <div id="tuisong">
      <img alt="" src="image/anniu.png" class="shu"><p class="p">根据你的常搜内容，向你推荐：<c:forEach items="${list}" var="user">${user.problem};</c:forEach></p>
   </div>
   <div id="talk"></div>
<div class="a">
   <div><img alt="" src="image/toto.png" class="duihuakuang"><input type="text" id="say" /></div>
   <img alt="" src="image/mao.png" class="anniu">
   <button type="button" onclick="sendSay()" class="fasong"></button>
</div>
</div>
<div class="l">
<input type="button" value="我要订阅" id="wantSubscription" onclick="wantSubscription('<%=request.getSession().getAttribute("z") %>')">
</div>
<div class="x">
<br>
	<strong><div id="x">
	   <p class="y">根据你的订阅向你推荐：</p>
	    <table style="color:gray;font-size:16px;">
	    	<tr id="dingyue_name"></tr>
	    	<tr id="dingyue_data"></tr>
	    </table>
			
	</div>	</strong>
</div>

</body>
</html>