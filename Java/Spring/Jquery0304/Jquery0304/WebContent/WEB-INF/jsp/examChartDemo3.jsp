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
		var json1=[];
		var json2=[];
		$.getJSON('members/data.json2',function(data){
			console.log(data);
			$.each(data,function(index,item){
				console.log(index+","+item.name+","+item.list);
				$.each(item.list,function(idx,itm){
					if(item.name=="jane"){json1.push(itm);}
					else{json2.push(itm);}
				});
			});
			console.log(json1);
			console.log(json2);
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
					}
				},
				yAxis:{
					title:{
						text:"과일소비"
					}
				},
				series:[{
					name:"jane",
					data:json1
				},
				{
					name:"lee",
					data:json2
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