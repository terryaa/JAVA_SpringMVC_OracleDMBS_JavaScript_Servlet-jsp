<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div id="wrap">
	<table style="width:100%">
		<tbody>
			<tr>
				<td class="item">Test내용입니다.</td>
			</tr>
			<tr>
				<td class="item select">Test내용입니다.</td>
			</tr>
			<tr>
				<td class="item">Test내용입니다.</td>
			</tr>
			<tr>
				<td class="item select">Test내용입니다.</td>
			</tr>
			<tr>
				<td class="item">Test내용입니다.</td>
			</tr>
		</tbody>
	</table>
</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
// $(function (){
// 	console.log("gg");
// 	while(true){
// 	setTimeout(function (){
// 		$(".item").css("background","blue");
// 		$(".select").css("background","red");	
// 	},3000);
// 	$(".item").css("background","red");
// 	$(".select").css("background","blue");
// 	}
// }
$(function(){
	while("true"){
		setTimeout(function(){
			$('.item').css('background','red');
			$('.item.select').css('background','blue');
	 		console.log("first");
		},1000);
		console.log("third");
		setTimeout(function(){
			$('.item').css('background','blue');
			$('.item.select').css('background','red');
		 	console.log("second");
		},1000);
	}
});
//왜안될까?



</script>
</html>