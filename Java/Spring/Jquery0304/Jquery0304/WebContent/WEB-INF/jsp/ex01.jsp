<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ex1.jsp</title>
</head>
<body>
	<h1>�ֹ�Ȯ��!</h1>
	<input type="text" name="name" id="name"><br/>
	<input type="text" name="orderNum" id="orderNum"><br/>
	<input type="button" value="Ȯ��" id="btn1"><br/>
	<div id="res">Status :</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		/* $.ajax({�ɼǼӼ�:��}); // jQuery.ajax();
		url:���ڿ� - ��û url����
		type:���ڿ� -  GET,POST ����
		data:��ü,���ڿ� - ��û �Ű����� ����
		success:�Լ�-������ ȣ���� �Լ�����
		async:�Ҹ��� - ����/�񵿱� ����
		error:�Լ� - ���н� ȣ���� �Լ�
		*/
		$('#btn1').click(function() {
			var n = $('#name').val();
			var on = $('#orderNum').val();
			console.log("name:"+n);
			console.log("Num:"+on);
			$.ajax({
				url:"exam2?cmd=ex3_ajax&name="+n+"&orderNum="+on,
				success:function(data,status){
					alert(data+","+status);
					$('#res').html(data);
				},
				error:function(e){
		               alert(e);
	            }
			});
		});
	});
</script>
</html>