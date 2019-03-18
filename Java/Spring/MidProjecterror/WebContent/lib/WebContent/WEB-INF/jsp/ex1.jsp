<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	#res{
	width:200px;
	height: 35px;
	background:pink;
	}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
	$('img').attr('width',150);
	$('img').attr('width',function(index){
		if(index===0)
			return 100;
		else if(index===1)
			return 250;
		else if(index===2)
			return 500;
	});
	$('img').attr({
		border:'1px solid red',
		height : function(index){
			if(index==0){
				return 100;
			}
			else if(index==1){
				return 250;
			}
			else
				return 500;
		}
	})
});
</script>
</head>
<body>
<div id="res">
<img src="resources/img/1.jpg"/>
<img src="resources/img/2.jpg"/>
<img src="resources/img/3.jpg"/>
</div>
</body>
</html>