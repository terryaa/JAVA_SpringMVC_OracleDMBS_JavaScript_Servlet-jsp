<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	#wrap{width:100; height:200;background:orange;margin:auto;}
</style>
</head>
<body>
<p>
	<input type="button" id="hide" value="hide" onclick="test('orange')" >
	<input type="button" id="show" value="show" onclick="test('green')">
<div id="wrap" style="width:100">123
</div>

</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
// $('#hide').click(function(){
// 	$('#wrap').css('background','orange');
// });
// $('#show').click(function(){
// 	$('#wrap').css('background','green');
// }); onclick="test('green')"onclick="test('orange')"

//이건 비동기식으로안됨 이유는?
//$('#hide').click(test('orange'));
//$('#show').click(test('green'));

var xhr;
function test(str){
	console.log('click');
	var param=str;
	if(window.ActiveXObject){
		xhr=new ActiveXObject("Microsoft.XMLHTTP");
	}else{
		xhr=new XMLHttpRequest();
	}
	//서버로부터 결과가 도착할때 수행하는 함수 지정(콜백함수)
	xhr.onreadystatechange=res;
	//서버에게 호출하기 위한 준비
	//전송방식,주소,비동기식(true),동기식(false)
	xhr.open("GET","ajax/ajaxData1?subject="+param,true);
	//서버에게 요청보내기
	xhr.send(null);//우린 get방식으로 보내기로 했기때문에 인자는 반드시 null
	//post라면 null이아니라, 보내고자 하는 파라미터를 문자열로 넣어야 한다.
	//xhr.send(s);
		
}
function res(){
	console.log("ReadyState:"+xhr.readyState)
	if(xhr.readyState==4){
		if(xhr.status==200){
			let txt=document.getElementById("wrap");
			txt.style.backgroundColor=xhr.responseText;
			//alert(xhr.responsText);
		}else{
			alert("실패"+xhr.status);
		}
	}
	
}

</script>
</html>