<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>greeting.jsp</title>
</head>
<body>
	<p style="color:green;font-size: 20px">${msg }</p>
	<div>
		<form method="post" action="login.kosta">
		<input type="hidden" name="cmd" value="login">
			���̵� : <input type="text" name="id"><br>
			��й�ȣ : <input type="password" name="pwd"><br>
			<input type="submit" value="send">
		</form>
	</div>
</body>
</html>