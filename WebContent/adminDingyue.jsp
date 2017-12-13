<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css" />
<title>用户订阅</title>
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
 <script>
        $(document).ready(function () {
        	var mydata = [];
            $.jgrid.defaults.styleUI = 'Bootstrap';
            $.ajax({
        		async:false,
        		cache:false,
        		type:"post",
        		url:"<%=request.getContextPath()%>/userServlet?methodName=listDingYue",
        		success:function(list){
        			///alert(list);
        			mydata = eval(list);
        		}
        	});
            $("#table_list_1").jqGrid({
                data: mydata,
                datatype: "local",
                height: 250,
                autowidth: true,
                shrinkToFit: true,
                rownumbers :true,
                rowNum: 10,
                rowList: [5, 10, 20],
                jsonReader: { 
                    page: "page", 
                    total: "total", 
                    records: "records", 
                    root: "rows", 
                    repeatitems: true ,
                    id:"id",
                },
                colNames: ['ID','ID','用户姓名','用户订阅','订阅内容'],
                colModel: [
                    {
                        name: 'id',
                        index: 'id',
                        hidden:true,
                        hidedlg:false,
                        editable: true,
                        width: 0,
                    },
                    {
                        name: 'id',
                        index: 'id',
                        width: 100,
                        editable: true,
                        search: true,
                        align:'center'
                    },
                    {
                        name: 'user',
                        index: 'user',
                        editable: true,
                        width: 60,
                        align:'center'
                    },
                    {
                        name: 'name',
                        index: 'name',
                        width: 60,
                        editable: true,
                        search: true,
                        align:'center'
                    },
                    {
                        name: 'data',
                        index: 'data',
                        width: 60,
                        editable: true,
                        search: true,
                        align:'center'
                    }
                ],
                 gridComplete:function(){
                	var ids = jQuery("#table_list_1").jqGrid('getDataIDs');
		        	for (var i = 0; i < ids.length; i++) {
		        	var id = ids[i];
		        	var curRowData = $("#table_list_1").jqGrid('getRowData', id);
		        	var ID = curRowData['shop_id'];
		        	var update = "<a href='#' style='color:#f60' onclick=update('"+ ID + "') >修改信息</a>";
		        	jQuery("#table_list_1").jqGrid('setRowData', ids[i] , {update: update});
		        	}
                	}, 
                pager: "#pager_list_1",
                viewrecords: true,
                caption: "--用户订阅-- ",
                hidegrid: false,
                	})
      
             $(window).bind('resize', function () {
                var width = $('.jqGrid_wrapper').width();
                $('#table_list_1').setGridWidth(width);
            });
            
             $("#table_list_1").jqGrid('navGrid', '#pager_list_1', {
                edit: false,
                add: false,
                del: false,
                search: true
            }, {
                height: 200,
                reloadAfterSubmit: true
            }); 
        });
        function update(id) {
        	$.ajax({
				data:"id="+id,
				type : 'post',
				url:"",
				success:function(){
					
				}
			});
        }  
    </script>
<style type="text/css">
body {
	padding-bottom: 4px;
	background-image: url("image/laozhebeijing.jpg");
	background-repeat: no-repeat;
	background-size:100%;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>

<style>
        #alertmod_table_list_2 {
            top: 900px !important;
        }
    </style>
</head>
<body class="gray-bg">
<br><br><br><br><br>
<div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox ">
                    <div class="ibox-content">     
                        <div class="jqGrid_wrapper">
                            <table id="table_list_1"></table>
                            <div id="pager_list_1"></div>
                        </div>                    
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>