<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<!-- 
css�Լ� : style ����� inline������� ����
*: ����Ҹ� �ǹ��Ѵ�.
����ҿ� css�Լ� ������Ѻ���
$("*").css("background","red"); ==> �����߻�. �������ʴ� ��ұ��� ��Ÿ���� �����.
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