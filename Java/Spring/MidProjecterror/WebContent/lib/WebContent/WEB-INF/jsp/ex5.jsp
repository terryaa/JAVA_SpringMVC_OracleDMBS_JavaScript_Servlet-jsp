<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	/*
	ex2_load_test.jsp
	p��Ҹ��� �����ͼ� ���� ������
	div��Ҿȿ� �ֱ� ���ؼ� �Ʒ���
	���� ������ ������ �� �ִ�.
	p�̿ܿ��� , �� ����ؼ� span��ҵ� ������ �� �ִ�.
	p, span p.
	*/
	$('#loadTest').click(function(){
		console.log($('#target').load('ajax/ex2_load_test?cmd=1'));
		$('#target').load('ajax/ex2_load_test?cmd=1',function(response,status,xhr){
			console.log("Response :"+response);
			console.log("Status :"+status)
			console.log("XHR:"+xhr.status);
			$('#target2').html(response);
			$(this).css("background","yellow");
		}); 
	});
	$('#loadData').click(function(){
		console.log($('#target').load('ajax/ex2_load_test?cmd=2'));
		$('#target').load('ajax/ex2_load_test?cmd=2 #goal + h5',function(response,status,xhr){
			console.log($('#goal').next().text());
// 			$('#target').html($('#goal').next().text());
			console.log("Response :"+response);
			console.log("Status :"+status)
			console.log("XHR:"+xhr.status);
			$(this).css("background","yellow");
		}); 
	});

});
</script>
</head>
<body>
<div>
<input type="button" id="loadTest" value="AjaxTest">
<input type="button" id="loadData" value="LoadData">
</div>
<div id="target"></div>
<div id="target2" style="background:orange; width:300;"></div>
</body>
</html>