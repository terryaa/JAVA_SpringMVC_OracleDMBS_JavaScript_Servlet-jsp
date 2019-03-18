<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ex1.jsp</title>
</head>
<body>
	<h1>주문확인!</h1>
	<input type="text" name="name" id="name"><br/>
	<input type="text" name="orderNum" id="orderNum"><br/>
	<input type="button" value="확인" id="btn1"><br/>
	<div id="res">Status :</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		/* $.ajax({옵션속성:값}); // jQuery.ajax();
		url:문자열 - 요청 url설정
		type:문자열 -  GET,POST 설정
		data:객체,문자열 - 요청 매개변수 설정
		success:함수-성공시 호출할 함수설정
		async:불리언 - 동기/비동기 설정
		error:함수 - 실패시 호출할 함수
		*/
		$('#btn1').click(function() {
			var n = $('#name').val();
			var on = $('#orderNum').val();
			console.log("name:"+n);
			console.log("Num:"+on);
			$.ajax({
				url:"exam2?cmd=ex3_ajax&name="+n+"&orderNum="+on,
				success:function(data,status){
					alert(data+","+status);
					$('#res').html(data);
				},
				error:function(e){
		               alert(e);
	            }
			});
		});
	});
</script>
</html>