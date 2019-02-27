<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	#wrap{width : 350px; height: 300px;}
</style>
</head>
<body>
<div>
	<input type="color" id="color">
	<input type="button" id="btn" value="select">
</div>
<div id="wrap" class="pp">
</div>
</body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$("#btn").click(function(){
		let color=$("#color").val();
		$("div.pp").css("background",color);
	});
</script>
</html>