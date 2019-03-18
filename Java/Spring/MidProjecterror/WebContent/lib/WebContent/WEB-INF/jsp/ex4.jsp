<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	.cng{background:orange;color:red;}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
	$('h1').bind({
		click : function(){
			$(this).html(function(index,html){
				return "<p>러브러브</p>";
			});
		},
		mouseenter:function(){
			$(this).addClass("cng");
		},
		mouseleave:function(){
			$(this).removeClass("cng");
		}
	});
});
</script>
</head>
<body>
<h1>Hello world!</h1>
<h1>Hello world!</h1>
<h1>Hello world!</h1>

</body>
</html>