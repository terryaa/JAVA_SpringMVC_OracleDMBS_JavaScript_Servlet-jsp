<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<!-- 
css함수 : style 적용시 inline방식으로 적용
*: 모든요소를 의미한다.
모든요소에 css함수 적용시켜보기
$("*").css("background","red"); ==> 문제발생. 원하지않는 요소까지 스타일이 적용됨.
 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	//$("*").css("background","red");
	$("body *").css("background","red");
	$("#btn").click(function(){
		$("body *").css("background","yellow");
		$(this).text("clicked!");
	});
});
</script>
</head>
<body>
<div>
<h2>This is a heading</h2>

<p>This is a paragraph.</p>
<p>This is another paragraph.</p>

<button id="btn">Click me</button>
</div>


</body>
</html>