<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>board</title>
</head>
<body>
	<div>
		<form method="post" action="insertboard">
			<fieldset>
				<legend>�Խ��� ���ۼ�</legend>
				<p><label>title</label>
				<input type="text" name="title" id="title"></p>
				<p><label>content</label>
				<input type="text" name="content" id="content" style="width: 550px; height: 650px"></p>
				<p><label name="id" id="id">${sessionScope.uid}</label>
				<br><input type="submit" value="����"> 
			</fieldset>
		</form>
	</div>
</body>
</html>