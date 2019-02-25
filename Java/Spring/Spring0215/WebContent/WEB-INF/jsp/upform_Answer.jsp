<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>upup.jsp</title>
</head>
<body>

<div id="wrap">
	<fieldset>
	<legend>파일업로드예제</legend>
	<form action="upup" method="post" enctype="multipart/form-data">
		<p>writer
		<p>
		이미지 파일 : <input name="mfile" id="mfile" type="file">
		</p>
		<p>
		<input type="submit" value="send">
		</p>
	
	</form>
	</fieldset>
</div>
</body>
</html>