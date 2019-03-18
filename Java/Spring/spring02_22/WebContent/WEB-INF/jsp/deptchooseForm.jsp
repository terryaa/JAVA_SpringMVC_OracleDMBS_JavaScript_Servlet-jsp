<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>deptchooseForm.jsp</title>
<style>
	#wrap{width: 800px; margin: auto;}
</style>
</head>
<body>
	<div id="wrap">
		<form method="post" action="deptalllist">
			부서번호: <select	name="deptno">
			<option>10</option>
			<option>20</option>
			<option>30</option>
			<option>40</option>
			<option>50</option>
			</select><input type="submit" value="검색">
		</form>
	</div>
</body>
</html>