<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>主页</title>
<link href="static/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<link href="static/css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Fashion Show Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script src="static/js/jquery-1.8.3.min.js"></script>
<!---- start-smoth-scrolling---->
<script type="text/javascript" src="static/js/move-top.js"></script>
<script type="text/javascript" src="static/js/easing.js"></script>
 <script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){		
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
			});
		});
	</script>
<!---End-smoth-scrolling---->
</head>
<body>
		<!--header-->
			<div class="header">
				<div class="container">
					<div class="header-top">
						<div class="logo">
							<a href="#">中国 <span>风</span></a>
						</div>
						<div class="top-menu">
							<span class="menu"><img src="images/nav.png" alt=""/> </span>
							<!-- <ul>
								<li><a href="zhuye.jsp" class="active">主页</a></li>
								<li><a href="huiyuanxinxichaxun.jsp">会员信息</a></li>
								<li><a href="yuyuelishi.jsp">预约历史</a></li>
								<li><a href="qingjiaguanli.jsp">请假管理</a></li>
								<li><a href="shoufeijiesuan.jsp">收费结算</a></li>
							</ul> -->
						</div>
						 <!--script-nav-->
						 <script>
						 $("span.menu").click(function(){
						 $(".top-menu ul").slideToggle("slow" , function(){
						 });
						 });
						 </script>
						<div class="clerfix"></div>
					</div>
				</div>
			</div>
		<!--header-->
		<div class="gallery-cursual">
		<!-- requried-jsfiles-for owl -->
		<link href="static/css/owl.carousel.css" rel="stylesheet">
		<script src="static/js/owl.carousel.js"></script>
			<script>
				$(document).ready(function() {
					$("#owl-demo").owlCarousel({
						items : 4,
						lazyLoad : true,
						autoPlay : true,
						pagination : false,
					});
				});
			</script>
		<div id="owl-demo" class="owl-carousel text-center">
			<div class="item">
				<img class="lazyOwl" data-src="static/images/b1.jpg" alt="name">
			</div>
			<div class="item">
				<img class="lazyOwl" data-src="static/images/b2.jpg" alt="name">
			</div>
			<div class="item">
				<img class="lazyOwl" data-src="static/images/b3.jpg" alt="name">
			</div>
			<div class="item">
				<img class="lazyOwl" data-src="static/images/b4.jpg" alt="name">
			</div>
			<div class="item">
				<img class="lazyOwl" data-src="static/images/b5.jpg" alt="name">
			</div>
			<div class="item">
				<img class="lazyOwl" data-src="static/images/b6.jpg" alt="name">
			</div>
			<div class="item">
				<img class="lazyOwl" data-src="static/images/b7.jpg" alt="name">
			</div>
			<div class="item">
				<img class="lazyOwl" data-src="static/images/b1.jpg" alt="name">
			</div>
			<div class="item">
				<img class="lazyOwl" data-src="static/images/b2.jpg" alt="name">
			</div>
			<div class="item">
				<img class="lazyOwl" data-src="static/images/b3.jpg" alt="name">
			</div>
		</div>
		<!--//sreen-gallery-cursual---->
		</div>
		<div class="content">
		<!--welcome-->
		<div class="welcome">
			<div class="container">
			<h3>欢迎来到历史小V的世界</h3>
			</div>
		</div>
		<!--welcome-->
		
	
				<!-- <div class="news">
					<div class="container">
						<h3>news</h3>
						<div class="new-grids">
							<div class="col-md-6 new-grid">
									<a href="#" class="mask">
						<img src="static/img/n4.jpg" class="img-responsive zoom-img" alt=""></a>
						</div>	
							<div class="col-md-6 new-grid1">
								<h4><a href="#">薄藤 no.1</a></h4>
								<p>适合人群：肤色偏白、秀发坚韧者<br>
									樱花粉+薰衣草紫色，美出天际！</p>
							</div>	
							<div class="clearfix"></div>
							<div class="col-md-6 new-grid1">
								<h4><a href="#">亚麻白金 no.2</a></h4>
								<p>适合人群：肤色偏白、秀发坚韧者<br>
									金色染发，发丝少的人会显得发色更浅，发丝多的话颜色变得比较深。</p>
							</div>		
							<div class="col-md-6 new-grid">
								<a href="#" class="mask">
						<img src="static/img/n5.jpg" class="img-responsive zoom-img" alt=""></a>
						</div>		
							<div class="clearfix"></div>	
							
						</div>	
					</div>	
				</div>	 -->
				<!--news-->
			
		<div class="footer-section">
						<div class="container">
							<div class="footer-top">
									</div>
							<script type="text/javascript">
						$(document).ready(function() {
							$().UItoTop({ easingType: 'easeOutQuart' });
						});
					</script>
				<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
				</div>
			</div>
</body>
</html>