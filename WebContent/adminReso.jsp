<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <script src="<%=request.getContextPath() %>/static/js/echarts.js"></script>
 
<script src="<%=request.getContextPath() %>/static/js/jquery.min.js?v=2.1.4"></script>
<script src="<%=request.getContextPath() %>/static/js/bootstrap.min.js?v=3.3.6"></script>
<script src="<%=request.getContextPath() %>/static/js/plugins/peity/jquery.peity.min.js"></script>
<script src="<%=request.getContextPath() %>/static/js/plugins/jqgrid/i18n/grid.locale-cn.js?0820"></script>
<script src="<%=request.getContextPath() %>/static/js/plugins/jqgrid/jquery.jqGrid.min.js?0820"></script>
<link href="<%=request.getContextPath() %>/static/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="<%=request.getContextPath() %>/static/css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="<%=request.getContextPath() %>/static/css/plugins/jqgrid/ui.jqgrid.css?0820" rel="stylesheet">
<link href="<%=request.getContextPath() %>/static/css/animate.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/static/css/style.css?v=4.1.0" rel="stylesheet">
</head>
<body>
<h1 style="text-align: center;margin-top: 60px;">热门订阅模板图表</h1>
<div id="main" style="width: 500px;height:300px;margin-left: auto;margin-right: auto;margin-top: 50px;" class="ECharts"></div>
<script>
var dataArray = [];
var dataName = new Array();
var pic;
$(document).ready(function(){
	
	  $.ajax({
       		async:false,
       		cache:false,
       		type:"post",
       		url:"<%=request.getContextPath()%>/userServlet?methodName=dingyue_muban",
       		success:function(list){
       			mydata = eval(list);
       			for(var i = 0 ; i < mydata.length; i++){
       				var map = {};
       				map.name = mydata[i].data;
       				map.value = '';
       				dataName[i] = mydata[i].data;
       				map.value = mydata[i].count;
       				dataArray.push(map);
       			}
       		}

	       	});
	       
	 })
</script>

<script type="text/javascript">
		setTimeout(function() {

			// 基于准备好的dom，初始化echarts实例
			var myChart = echarts.init(document.getElementById('main'));

			// 指定图表的配置项和数据
			var option = {
				tooltip : {
					trigger : 'item',
					formatter : "{a} <br/>{b}: {c} ({d}%)"
				},
				legend : {
					orient : 'vertical',
					x : 'left',
					data : dataName
				},
				series : [ {
					name : '热门朝代',
					type : 'pie',
					radius : [ '50%', '70%' ],
					avoidLabelOverlap : false,
					label : {
						normal : {
							show : false,
							position : 'center'
						},
						emphasis : {
							show : true,
							textStyle : {
								fontSize : '30',
								fontWeight : 'bold'
							}
						}
					},
					labelLine : {
						normal : {
							show : false
						}
					},
					data : dataArray
				} ]
			};

			// 使用刚指定的配置项和数据显示图表。
			myChart.setOption(option);
		}, 1000);

    </script>
</body>
</html>