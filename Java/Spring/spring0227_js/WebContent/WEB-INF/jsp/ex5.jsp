<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
#wrap{width:450px;margin:auto;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$('.item').css('color','orange');
	$('div h1 .item').css('background','red');
	$('div .item.select').css('background','blue');
});
</script>
</head>
<body>

	<div>
		<h1 class="item">Hello World</h1>
		<h1 class="item select">Hello World</h1>
		<h1 ><p class="item">Hello World</p></h1>
	</div>
</body>
</html>