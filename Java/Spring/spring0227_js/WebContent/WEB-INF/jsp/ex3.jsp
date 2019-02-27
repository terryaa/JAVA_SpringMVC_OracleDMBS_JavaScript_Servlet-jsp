<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	#wrap{width:300; height:200;}
</style>
</head>
<body>
<div id="wrap">
<h1>hello</h1>
</div>

</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$('#wrap').css('backgroundColor','red');
	$('#wrap').css('test-aling','center');
	$('#wrap h1').css('color','white');
	setTimeout(function(){
		$('#wrap').css('backgroundColor','pink');
		$('#wrap h1').css('color','yellow');
	},5000);
</script>
</html>