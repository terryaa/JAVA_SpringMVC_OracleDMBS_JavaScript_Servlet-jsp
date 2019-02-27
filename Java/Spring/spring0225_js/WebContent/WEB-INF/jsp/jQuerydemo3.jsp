<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	#target{ width:200px; height:200px}
	.cs1{background:orange; border:1px dotted;}
</style>
</head>
<body>
<%--
1. jQuery�� Dom �߽� ����̴�. �ڹٽ�ũ��Ʈ ���̺귯���� �ϳ�.
2. jQuery������ ������ �ڵ�, ������ �÷����� Ȱ���̴�.
 --%>
 
 <div id="wrap">
 	<p id="target"> jQuery����: style ���ϰ� �����ϱ�.</p>
 	<p>
 	<input type="button" id="btn1" value="AddStyle">
 	<input type="button" id="btn2" value="removeStyle">
 	</p>
 </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(function(){
		$('#btn1').click(function(){
			$('#target').addClass("cs1");
		});
		$('#btn2').click(function(){
			$('#target').removeClass("cs1");
		});
	});
	
</script>
</body>
</html>