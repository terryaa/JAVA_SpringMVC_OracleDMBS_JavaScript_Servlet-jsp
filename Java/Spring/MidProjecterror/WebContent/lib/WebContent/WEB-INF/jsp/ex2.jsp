<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
	$(document).ready(function(){
		//innerHTML같가
		$('div').html('<h1>Test 1 </h1>');
		$('div').html(function(index){
			return '<p> test'+index+'</p>';
		});
		
		$('div').html(function(index){
			return '<h'+parseInt(index+1,10)+'> Test'+'</h1'+parseInt(index+1,10)+'>';
		});
		$('div').css({
			width:300,
			border:'1px solid red',
			height:120
		});
	});
	</script>
<body>
<div></div>
<div></div>
<div></div>

</body>
</html>