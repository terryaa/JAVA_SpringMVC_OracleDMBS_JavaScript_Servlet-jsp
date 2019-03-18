<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>examChartDemo2.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script>
	$(document).ready(function() {
		var jsondata = [];
		var val=[];
		var e=10;
		$.getJSON('members/data.json1',function(data){
			console.log(data);
			for(var i=0; i<data.length;i++){
				jsondata.push([data[i].key,data[i].value]);
			}
			for(var i=0; i<data.length; i++){
				val.push([e*i]);
			}
			console.log(jsondata);
			$('#container').highcharts({
				chart:{
					type:'line'
					//column,bar,line
				},
				title:{
					text:'과일소비량'
				},
				xAxis:{					
					title:{
						text:'과일량'
					},
					categories:val
				},
				yAxis:{
					title:{
						text:"과일소비"
					}
				},
				series:[{
					name:'Jane',
					data:jsondata
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