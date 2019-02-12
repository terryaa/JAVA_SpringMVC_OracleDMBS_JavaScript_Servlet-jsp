
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	div{width:300px;border:1px solid blue; margin:auto}
</style>
</head>
<body>
	<div>
		<form method="post" action="ex2_pro.jsp">
			<p>숫자입력: <input type="number" name="num" min="0" max="25" ></p>
			<p><input type="submit" value="전송"></p>
		</form>
	</div>
</body>
</html>