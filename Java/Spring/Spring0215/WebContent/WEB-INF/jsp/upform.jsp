<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <!-- ���� ���ε� �� ��  "enctype" �̰� ������ �����Ͱ� ����Ǵ°�.
    ������ ĳ���� ��Ʈ��. ������ ����Ʈ ��Ʈ��.  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>upform.jsp</title>
</head>
<body>
<div id="wrap">
	<fieldset>
	<legend>���Ͼ��ε忹��</legend>
	<form action="upload" method="post" enctype="multipart/form-data">
		
		<p>
		�̹��� ���� : <input name="mfile" id="mfile" type="file">
		</p>
		<p>
		<input type="submit" value="send">
		</p>
	
	</form>
	</fieldset>
</div>

</body>
</html>