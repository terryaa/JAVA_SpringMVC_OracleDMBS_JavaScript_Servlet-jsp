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

//�̰� �񵿱�����ξȵ� ������?
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
	//�����κ��� ����� �����Ҷ� �����ϴ� �Լ� ����(�ݹ��Լ�)
	xhr.onreadystatechange=res;
	//�������� ȣ���ϱ� ���� �غ�
	//���۹��,�ּ�,�񵿱��(true),�����(false)
	xhr.open("GET","ajax/ajaxData1?subject="+param,true);
	//�������� ��û������
	xhr.send(null);//�츰 get������� ������� �߱⶧���� ���ڴ� �ݵ�� null
	//post��� null�̾ƴ϶�, �������� �ϴ� �Ķ���͸� ���ڿ��� �־�� �Ѵ�.
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
			alert("����"+xhr.status);
		}
	}
	
}

</script>
</html>