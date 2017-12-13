<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>管理员首页</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="这是一个 index 页面">
  <meta name="keywords" content="index">
  <meta name="renderer" content="webkit">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="icon" type="image/png" href="<%=request.getContextPath() %>/static/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="<%=request.getContextPath() %>/static/i/app-icon72x72@2x.png">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/amazeui.min.css"/>
  <link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/admin.css">
  <style type="text/css">
  .admin-sidebar li{
 background: rgb(40,47,55)!important;
 cursor: pointer;
  }
  .admin-sidebar-list li a{
  color:#fff!important;
  }
  .admin-sidebar-sub{
  padding-left: 0px!important;
  border-left:5px solid #FFFF66;
  }
  .admin-sidebar-sub li{
  padding-left: 10px;
   background: #fff!important;
  }
  .admin-sidebar-sub li a{
  color:#000!important;
  font-size:13px;
  }
  </style>
</head>
<body>
	<header style="background: rgb(40,47,55);" class="am-topbar am-topbar-inverse admin-header">
		<div class="am-topbar-brand">
			<strong>历史小V智能聊天机器人</strong> <small>管理员管理端</small>
		</div>

		
		<button
			class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
			data-am-collapse="{target: '#topbar-collapse'}">
			<span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
		</button>
		<div class="am-collapse am-topbar-collapse" id="topbar-collapse">
			<ul
				class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
				<li class="am-dropdown" data-am-dropdown><a
					class="am-dropdown-toggle" data-am-dropdown-toggle
					href="javascript:;"> <span class="am-icon-users"></span> 管理员 <span
						class="am-icon-caret-down"></span>
				</a>
					<ul class="am-dropdown-content">
						<li onclick="zhuye()"><a><span class="am-icon-user"></span> 主页</a>
						

					</ul></li>
				<li class="am-hide-sm-only"><a href="javascript:;"
					id="admin-fullscreen"><span class="am-icon-arrows-alt"></span>
						<span class="admin-fullText">开启全屏</span></a></li>
			</ul>
		</div>
	</header>

	<div class="am-cf admin-main">
		<!-- sidebar start -->
		<div style="background: rgb(40,47,55);overflow: hidden" class="admin-sidebar am-offcanvas" id="admin-offcanvas">
			<div class="am-offcanvas-bar admin-offcanvas-bar">
				<ul class="am-list admin-sidebar-list">

					<li class="admin-parent"><a class="am-cf"
						data-am-collapse="{target: '#collapse-nav'}"><span
							class="am-icon-file"></span> 用户<span
							class="am-icon-angle-right am-fr am-margin-right"></span></a>
						<ul class="am-list am-collapse admin-sidebar-sub"
							id="collapse-nav">
							<li onclick="admin()" id="admin"><a><span
									class="am-icon-check"></span>用户列表</a></li>
							<li onclick="adminReso()" id="adminReso"><a><span
									class="am-icon-puzzle-piece"></span> 热门订阅</a></li>
							<li onclick="adminDingyue()" id="adminDingyue"><a><span
									class="am-icon-check"></span>用户订阅</a></li>
						</ul></li>

					<li class="admin-parent" onclick="adminApply()"><a><span
							class="am-icon-table"></span> 用户申请审批 <span
							class="am-icon-angle-right am-fr am-margin-right"></span></a>
						<!-- <ul class="am-list am-collapse admin-sidebar-sub"
							id="collapse-nav1">
							<li onclick="dengdaichuli()"><a><span
									class="am-icon-check"></span> 等待处理</a></li>
							<li onclick="yichangchuli()"><a><span
									class="am-icon-puzzle-piece"></span> 异常处理</a></li>
							<li onclick="yuyuelishi()"><a><span
									class="am-icon-table"></span> 预约历史</a></li>
						</ul> --></li>

					<!-- <li class="admin-parent"><a class="am-cf"
						data-am-collapse="{target: '#collapse-nav2'}"><span
							class="am-icon-pencil-square-o"></span> 理发师管理 <span
							class="am-icon-angle-right am-fr am-margin-right"></span></a>
						<ul class="am-list am-collapse admin-sidebar-sub"
							id="collapse-nav2">
							<li onclick="qingjiaguanli()"><a><span
									class="am-icon-check"></span> 请假管理</a></li>
							<li onclick="xinxiguaynli()"><a><span
									class="am-icon-puzzle-piece"></span> 信息管理</a></li>
							<li onclick="tianjialifashi()"><a><span
									class="am-icon-table"></span> 添加理发师</a></li>
						</ul></li>

					<li class="admin-parent"><a class="am-cf"
						data-am-collapse="{target: '#collapse-nav3'}"><span
							class="am-icon-sign-out"></span> 财务管理 <span
							class="am-icon-angle-right am-fr am-margin-right"></span></a>
						<ul class="am-list am-collapse admin-sidebar-sub"
							id="collapse-nav3">
							<li onclick="shoufeijiesuan()"><a><span
									class="am-icon-check"></span> 收费结算</a></li>
							<li onclick="huiyuanxiaofeijilu()"><a><span
									class="am-icon-puzzle-piece"></span> 会员消费记录</a></li>
							<li onclick="huiyuanchongzhijilu()"><a><span
									class="am-icon-table"></span> 会员充值记录</a></li>
						</ul></li>

				</ul> -->

				 <div class="am-panel am-panel-default admin-sidebar-panel">
					<div class="am-panel-bd">
						<p>
							<span class="am-icon-bookmark"></span> 名句
						</p>
						<p>我志在删述。垂辉映千春。希圣如有立。绝笔于获麟—— 李白</p>
					</div>
				</div> 
			</div>
		</div>
		<!-- sidebar end -->

		<!-- content start -->
		<div class="admin-content">
			<div class="admin-content-body">


				<iframe id="iframe" src="zhuye.jsp" width="100%" height=""> </iframe>


			</div>

			
		</div>
		<!-- content end -->

	</div>

	<a href="#"
		class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu"
		data-am-offcanvas="{target: '#admin-offcanvas'}"></a>

	<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

	<!--[if (gte IE 9)|!(IE)]><!-->
	<script src="<%=request.getContextPath() %>/static/js/jquery.min.js"></script>
	<!--<![endif]-->
	<script src="<%=request.getContextPath() %>/static/js/amazeui.min.js"></script>
	<script src="<%=request.getContextPath() %>/static/js/app.js"></script>
	<script type="text/javascript">
	
		$(function() {
			var windowHeight = $(window).height();
			$("#iframe").css("height", windowHeight);
		});
		function zhuye() {
			$("#iframe").attr("src", "zhuye.jsp");
		};
		function ditu() {
			$("#iframe").attr("src", "ditu.jsp");
		};
		function admin() {
			$("#iframe").attr("src", "admin.jsp");
			$("li>ul>li").attr("style","background:#fff!important");
			$("#admin").attr("style","background:#eee!important");
		};
		function adminApply() {
			$("#iframe").attr("src", "adminApply.jsp");
			$("li>ul>li").attr("style","background:#fff!important");
			$("#adminApply").attr("style","background:#eee!important");
		};
		function adminReso() {
			$("#iframe").attr("src", "adminReso.jsp");
			$("li>ul>li").attr("style","background:#fff!important");
			$("#adminReso").attr("style","background:#eee!important");
		};
		function adminDingyue() {
			$("#iframe").attr("src", "adminDingyue.jsp");
			$("li>ul>li").attr("style","background:#fff!important");
			$("#adminDingyue").attr("style","background:#eee!important");
		};
		function yichangchuli() {
			$("#iframe").attr("src", "<%=request.getContextPath()%>/jsp/yichangchuli.jsp");
			$("li>ul>li").attr("style","background:#fff!important");
			$("#yyls").attr("style","background:#eee!important");
		};
		function yuyuelishi() {
			$("#iframe").attr("src", "<%=request.getContextPath()%>/jsp/yuyuelishi.jsp");
			$("li>ul>li").attr("style","background:#fff!important");
			$("#yyls").attr("style","background:#eee!important");
		};
		function qingjiaguanli() {
			$("#iframe").attr("src", "<%=request.getContextPath()%>/jsp/qingjiaguanli.jsp");
			$("li>ul>li").attr("style","background:#fff!important");
			$("#yyls").attr("style","background:#eee!important");
		};
		function xinxiguaynli() {
			$("#iframe").attr("src", "<%=request.getContextPath()%>/jsp/xinxiguanli.jsp");
			$("li>ul>li").attr("style","background:#fff!important");
			$("#yyls").attr("style","background:#eee!important");
		};
		function tianjialifashi() {
			$("#iframe").attr("src", "<%=request.getContextPath()%>/jsp/tianjialifashi.jsp");
			$("li>ul>li").attr("style","background:#fff!important");
			$("#yyls").attr("style","background:#eee!important");
		};
		function shoufeijiesuan() {
			$("#iframe").attr("src", "<%=request.getContextPath()%>/jsp/shoufeijiesuan.jsp");
			$("li>ul>li").attr("style","background:#fff!important");
			$("#yyls").attr("style","background:#eee!important");
		};
		function huiyuanxiaofeijilu() {
			$("#iframe").attr("src", "<%=request.getContextPath()%>/jsp/huiyuanxiaofeijilu.jsp");
			$("li>ul>li").attr("style","background:#fff!important");
			$("#yyls").attr("style","background:#eee!important");
		};
		function huiyuanchongzhijilu() {
			$("#iframe").attr("src", "<%=request.getContextPath()%>/jsp/huiyuanchongzhijilu.jsp");
			$("li>ul>li").attr("style","background:#fff!important");
			$("#yyls").attr("style","background:#eee!important");
		};
		function dianpuxiangqing() {
			$("#iframe").attr("src", "<%=request.getContextPath()%>/jsp/dianpuxiangqing.jsp");
			$("li>ul>li").attr("style","background:#fff!important");
			$("#yyls").attr("style","background:#eee!important");
		};
	</script>
</body>
</html>
