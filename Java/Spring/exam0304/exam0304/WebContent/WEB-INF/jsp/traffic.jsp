<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>traffic.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script>
	$(document).ready(function() {
		
		var chartdata = [];
		
		$.getJSON('traffic/traffic_detail?idx=${idx}',function(data){
			console.log(data);
			console.log(data.list);
			for (key in data.list) {
				console.log(data.list[key]);
				chartdata.push([key,data.list[key]]);
			}
			console.log(chartdata);
			$('#container').highcharts({
				chart:{
					type:'pie'
					//column,bar,line
				},
				title:{
					text:data.date
				},
				xAxis:{					
					title:{
						text:'date'
					}
				},
				yAxis:{
					title:{
						text:"traffic"
					}
				},
				 series: [{
	                  name: 'Brands',
	                  colorByPoint: true,
	                  sliced: true,
                      selected: true,
	                  data: 
	                      chartdata
	              }]
			});
		});		
	});
</script>
</head>
<body>
<div id="container" style="width: 100%; height: 400px;"></div>
</body>
</html>