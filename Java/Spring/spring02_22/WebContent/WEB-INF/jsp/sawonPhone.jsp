<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>sawonPhone.jsp</title>
<style>
	#wrap{width: 800px; margin: auto; border: 1px dotted;}
</style>
</head>
<body>
	<div id="wrap">
		<ul style="color: black;">
			<li>�����ȣ: ${sawon.sabun }</li>
			<li>�����å: ${sawon.sajob }</li>
			<li>����̸�: ${sawon.saname }</li>
			<li>����ȣ: ${sawon.sphone.phnum }</li>
			<li>����: ${sawon.sphone.pmodel }</li>
		</ul>
	</div>
</body>
</html>