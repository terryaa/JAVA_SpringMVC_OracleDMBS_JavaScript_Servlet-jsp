<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>chartDemo.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script> 
<!-- highchart는 jQuery에 의존하므로 jQuery라이브러리 밑에 써줘야 한다. -->
<script>
//	[{"key":"Math0","value":"101"},	{"key":"Math1","value":"102"},{"key":"Math2","value":"103"},
//	{"key":"Math3","value":"104"},	{"key":"Math4","value":"105"},{"key":"Math5","value":"106"},
//	{"key":"Math6","value":"107"},	{"key":"Math7","value":"108"},{"key":"Math8","value":"109"},
//	{"key":"Math9","value":"110"},	{"key":"Math10","value":"111"},{"key":"Math11","value":"112"},
//	{"key":"Math12","value":"113"}]
	$(document).ready(function() {
		//Ajax를 사용해서 json데이터를 비동기식으로 받아오기
		var pro_json = [];
		$.getJSON('members/data.json',function(data){
			console.log("점검1");
			console.log(data);
			for(var i = 0; i < data.length; i++){
				//Populate series 데이터 타입으로 데이터를 저장하기 위한 processed_json배열을 생성한 후
				// Ajax로 전송되어온 데이터를 읽어오면서 processed_json에 값을 저장한다.
				pro_json.push([data[i].key,data[i].value]);		
			}
			console.log(pro_json);
			//차트 view 요소를 선택자
			$("#container").highcharts({
				chart:{
					type:"column"
				},
				title:{
					text:"학생데이터"
				},
				subtitle:{
					text:"여기는 서브타이틀"
				},
				xAxis:{
					type:'category',
					allowDecimals:false,//정수로만 표기!
					title:{
						text:'x축'
					}
				},
				yAxis:{
					title:{
						text:"Scores"	
					}
				},
				series:[{
					name:'Subjects',
					data: pro_json
				}]
			});
		});//getJson 끝
	});
</script>
</head>
<body>
<div style="width: 800px; margin: auto; border: 1px solid red;">
차트 데모</div>
<div id="container" style="height: 400px;"></div>
</body>
</html>