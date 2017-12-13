<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
   <meta name="keywords" content="">
    <meta name="description" content="">
 <link rel="shortcut icon" href="favicon.ico"> <link href="../static/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="../static/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="../static/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="../static/css/animate.css" rel="stylesheet">
    <link href="../static/css/style.css?v=4.1.0" rel="stylesheet">

<style type="text/css">

body, html{width: 100%;height: 100%;margin:0;font-family:"微软雅黑";font-size:14px;}
#allmap {
	width: 100%;
	height: 450px;
	margin: 0;
	font-family: "微软雅黑";
	margin-top: 13px;
}
#r-result{width:100%;}
</style>
</head>
<body>
	地图搜索
	<br />
	<div id="r-result">
		查找:<input type="text" id="suggestId" placeholder="请输入您要查找的地方l" class="form-control" style="width: 200px; height:38px; margin-top: -26px; margin-left: 60px;" value="">
		<button onclick="getPosition()" class="btn btn-sm btn-primary pull-right m-t-n-xs" type="submit" style="margin-right: 70%; margin-top: -34px;">获取坐标
	</div>
	<div id="allmap"></div>
	<div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>
	
	
</body>
<script type="text/javascript">
	//百度地图API功能
	function loadJScript() {
		var script = document.createElement("script");
		script.type = "text/javascript";
		script.src = "http://api.map.baidu.com/api?v=2.0&ak=aIG45mNEga3KrEVb4cs1ydQEwurLmLms&callback=init";
		document.body.appendChild(script);
	}
	var map;
	var myValue;
	var marker;
	function init() {
		map = new BMap.Map("allmap"); // 创建Map实例
		map.centerAndZoom("北京",12);                   // 初始化地图,设置城市和地图级别。
		map.enableScrollWheelZoom(true);
		var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
			{"input" : "suggestId"
			,"location" : map
		});

		ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
		var str = "";
			var _value = e.fromitem.value;
			var value = "";
			if (e.fromitem.index > -1) {
				value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
			}    
			str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
			
			value = "";
			if (e.toitem.index > -1) {
				_value = e.toitem.value;
				value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
			}    
			str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
			G("searchResultPanel").innerHTML = str;
		});

		ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
		var _value = e.item.value;
			myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
			G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
			
			setPlace();
		});
	}
	// 百度地图API功能
	function G(id) {
		return document.getElementById(id);
	}
	function setPlace(){
		map.clearOverlays();    //清除地图上所有覆盖物
		function myFun(){
			var pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
			map.centerAndZoom(pp, 18);
			marker = new BMap.Marker(pp);
			map.addOverlay(marker);    //添加标注
		}
		var local = new BMap.LocalSearch(map, { //智能搜索
		  onSearchComplete: myFun
		});
		local.search(myValue);
	}
	function getPosition(){
		if(marker != undefined){
			var p = marker.getPosition();       //获取marker的位置
			alert("marker的位置是" + p.lng + "," + p.lat);
		}else{
			alert('请先选择地址');
		}
	}
	window.onload = loadJScript; //异步加载地图
</script>
</html>