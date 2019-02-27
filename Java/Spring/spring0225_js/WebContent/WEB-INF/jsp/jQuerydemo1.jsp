<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %> 
<c:set var="resImg" value="resources/img"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jQuerydemo1</title>

<style>
	#wrap{width : 350px; height: 300px;}
	#img{align:center;}
</style>

</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<div id="wrap">
	<p>
		<img src="${resImg }/pic_bulboff.gif" id="target">
	</p>
	<p>
		<input type="button" id="hideBtn" value="Hide">
		<input type="button" id="showBtn" value="Show">
	</p>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(function(){
		$('#hideBtn').click(function(){
			console.log("Hide Btn Clicked!");
			$('#target').hide("fast",function(){
				$('#wrap').css("background","yellow")
			});
		});
	//hide fast�ɼ��� hide�� �����ϸ� �� ���� function�� ���������
		$('#showBtn').click(function(){
			console.log("Show Btn Clicked!");
			$('#target').show("slow");
			$('#wrap').css("background","red")
		});
	});
	//slow�� slow�� �� ����ǰ��� ���Լ�������ȴ�.
</script>

</body>
</html>