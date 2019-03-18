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
			<li>사원번호: ${sawon.sabun }</li>
			<li>사원직책: ${sawon.sajob }</li>
			<li>사원이름: ${sawon.saname }</li>
			<li>폰번호: ${sawon.sphone.phnum }</li>
			<li>폰모델: ${sawon.sphone.pmodel }</li>
		</ul>
	</div>
</body>
</html>