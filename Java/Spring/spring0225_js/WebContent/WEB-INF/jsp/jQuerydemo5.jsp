<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<p>List 1:</p>
<ul>
  <li>Coffee</li>
  <li>Milk</li>
  <li>Tea</li>
</ul>

<p>List 2:</p>
<ul>
  <li>Coffee</li>
  <li>Milk</li>
  <li>Tea</li>
</ul>

<button>Click me</button>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("button").click(function(){
	  $("ul li:first-child").css("color","red");
	  $("ul li:nth-child(2)").css("color","blue");
	  $("ul li:last-child").css("background","orange");
	  
  });
});
</script>
</body>
</html>