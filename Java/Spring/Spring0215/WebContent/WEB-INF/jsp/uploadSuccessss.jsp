<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<p>
	<h1>	${dto.writer}</h1>
	<h1> ${dto.title }</h1>
	
		
<p>
	<img src="${pageContext.request.contextPath }/resources/img/${imgName}">
	</p>
</body>
</html>