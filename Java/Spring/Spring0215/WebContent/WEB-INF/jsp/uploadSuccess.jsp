<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
${imgName} 
<p>
	<img src="${pageContext.request.contextPath }/resources/img/${imgName}">
	</p>
</body>
</html>