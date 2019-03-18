<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>examChartDemo.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script>
	$(document).ready(function() {
		$('#container').highcharts({
			chart:{
				type:'line'
				//column,bar,line
			},
			title:{
				text:'���ϼҺ�'
			},
			xAxis:{
				catagories:['Apples','Bananas','Oranges']
			},
			yAxis:{
				title:{
					text:"���ϼҺ�"
				}
			},
			series:[{
				name:'Jane',
				data:[1,0,7]
			},
			{
				name:'kim',
				data:[5,7,2]
			},
			{
				name:'jeong',
				data:[1,2,5]
			}]
		});
	});
</script>
</head>
<body>
<div id="container" style="width: 100%; height: 400px;"></div>
</body>
</html>