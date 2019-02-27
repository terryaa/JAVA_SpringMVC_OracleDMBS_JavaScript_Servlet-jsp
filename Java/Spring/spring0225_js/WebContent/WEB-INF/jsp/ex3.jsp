<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
숫자:<input type="number" name="num1" id="num1">
<select id="oper">
  <option value="sum">+</option>
  <option value="mul">*</option>
  <option value="sub">-</option>
  <option value="div">/</option>
</select>
<input type="number" name="num2" id="num2">
<input type="button" id="btn" value="=">
<p id="demo"></p>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
	$('#btn').click(function(){
		console.log("1");
		sum();
	});
});

function sum(){
	let num1=parseInt($('#num1').val());
	let num2=parseInt($('#num2').val());
	let oper=$("#oper").val();
	let result;
	if(oper==="sum")
		result=num1+num2;
	else if(oper==="mul")
		result=num1*num2;
	else if(oper==="sub")
		result=num1-num2;
	else if(oper==="div")
		result=num1/num2;
 	$('#demo').html(result);
// 	let num1=document.getElementById("num1").value;
// 	let num2=document.getElementById("num2").value;
// 	document.getElementById("demo").innerHTML=parseInt(num1,10)+parseInt(num2,10);
}
//연습문제1. select +,-,x,/ 선택하는것으로.
//jquery로 변경
</script>
</body>
</html> 