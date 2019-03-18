<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>chartDemo.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script> 
<!-- highchart�� jQuery�� �����ϹǷ� jQuery���̺귯�� �ؿ� ����� �Ѵ�. -->
<script>
//	[{"key":"Math0","value":"101"},	{"key":"Math1","value":"102"},{"key":"Math2","value":"103"},
//	{"key":"Math3","value":"104"},	{"key":"Math4","value":"105"},{"key":"Math5","value":"106"},
//	{"key":"Math6","value":"107"},	{"key":"Math7","value":"108"},{"key":"Math8","value":"109"},
//	{"key":"Math9","value":"110"},	{"key":"Math10","value":"111"},{"key":"Math11","value":"112"},
//	{"key":"Math12","value":"113"}]
	$(document).ready(function() {
		//Ajax�� ����ؼ� json�����͸� �񵿱������ �޾ƿ���
		var pro_json = [];
		$.getJSON('members/data.json',function(data){
			console.log("����1");
			console.log(data);
			for(var i = 0; i < data.length; i++){
				//Populate series ������ Ÿ������ �����͸� �����ϱ� ���� processed_json�迭�� ������ ��
				// Ajax�� ���۵Ǿ�� �����͸� �о���鼭 processed_json�� ���� �����Ѵ�.
				pro_json.push([data[i].key,data[i].value]);		
			}
			console.log(pro_json);
			//��Ʈ view ��Ҹ� ������
			$("#container").highcharts({
				chart:{
					type:"column"
				},
				title:{
					text:"�л�������"
				},
				subtitle:{
					text:"����� ����Ÿ��Ʋ"
				},
				xAxis:{
					type:'category',
					allowDecimals:false,//�����θ� ǥ��!
					title:{
						text:'x��'
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
		});//getJson ��
	});
</script>
</head>
<body>
<div style="width: 800px; margin: auto; border: 1px solid red;">
��Ʈ ����</div>
<div id="container" style="height: 400px;"></div>
</body>
</html>