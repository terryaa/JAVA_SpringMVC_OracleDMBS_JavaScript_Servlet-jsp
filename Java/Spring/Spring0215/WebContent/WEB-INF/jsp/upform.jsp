<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <!-- 파일 업로드 할 때  "enctype" 이게 없으면 데이터가 저장되는거.
    없으면 캐릭터 스트림. 있으면 바이트 스트림.  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>upform.jsp</title>
</head>
<body>
<div id="wrap">
	<fieldset>
	<legend>파일업로드예제</legend>
	<form action="upload" method="post" enctype="multipart/form-data">
		
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