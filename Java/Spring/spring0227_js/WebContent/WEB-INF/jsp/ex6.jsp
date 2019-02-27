<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$('input[type=text]:first').val("myquery1").prop("readonly",true);
		$('input[type=text]:eq(2)').val("myquery12");
		$('input[type=text]:last').val("myquery13");
		$('input[type=text]:eq(0)').attr('name','gId');
		$('input[type=text]:eq(1)').attr('name','age');
		$('input[type=text]:eq(2)').attr('name','gname');
		$('input[type=text]:eq(3)').attr('name','addr');
		$('input[type=text]:eq(4)').attr('name','id');
		$('input[type=password]').attr('name','pwd');
	});
</script>
</head>
<body>
	<div>

		<form method="post" action="ex5_data">
			<fieldset>
			<legend>동적으로 폼의 속성 추가 예제</legend>
				<p><label>gId</label><input type="text" /></p>
				<p><label>age</label><input type="text" /></p>
				<p><label>gname</label><input type="text" /></p>
				<p><label>addr</label><input type="text" /></p>
				<p><label>id</label><input type="text" /></p>
				<p><label>pwd</label><input type="password" /></p>
				<p><input type="submit" value="send"></p>				
			</fieldset>
		</form>
	</div>
</body>
</html>