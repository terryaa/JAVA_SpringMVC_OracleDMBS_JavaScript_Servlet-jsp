<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<p id="p1">Enter this paragraph.</p>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("p").mouseenter(function(){
	  $(this).append("jQuery 실습!").css({"color":"pink"},{"fontSize":"20px"});
	  
    //$("p").css("background-color", "yellow");
  });
  $("p").mouseleave(function(){
	  $(this).empty().append("Enter this paragraph").css({"color":"red"},{"fontSize":"20px"});
    //$("p").css("background-color", "lightgray");
  });
});
</script>
</body>
</html>