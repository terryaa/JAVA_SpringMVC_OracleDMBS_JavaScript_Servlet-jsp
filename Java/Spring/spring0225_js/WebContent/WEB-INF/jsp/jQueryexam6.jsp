<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="resImg" value="../resources/img"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	#wrap{width:400px;margin:auto}
	body ul li{list-style:none; float:left}
	body ul li img {width:50px; height:30px; cursor:pointer}
	div img{width:200px;}
</style>
	
	
</head>
<body>
<div>
	<div id="wrap">
		<div><a href=""><img src="${resImg }/1.jpg" id="big"></a></div>
	<ul><c:forEach begin="1" end="6" step="1" varStatus="e">
		<li><img src="${resImg }/${e.index}.jpg" ></li>
		</c:forEach>
	</ul>
	</div>
</div>


</body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$("ul li img").on({
	mouseenter:function(){
		console.log("on");
 		$('#big').attr('src',$(this).attr('src'));
 		
	},
	mouseleave:function(){
		console.log("off");
	},
	click:function(){
		console.log("click");
	}
});
//:first => first(),last(),prev(),next(),child() api 찾아서 
//eq()=> 예제작성해보기바랍니다.
</script>

</html>