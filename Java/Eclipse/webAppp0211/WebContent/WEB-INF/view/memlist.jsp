<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="e" items="${list }">
	<p>
	${e.num } | ${e.id } | ${e.name } | ${e.email }
	${e.hiredate } | ${e.tel }
	</p>
	</c:forEach>
	<br>
	<input type="button" value="����" onclick="location='*.kosta?cmd=mform'">
	<!--  onclick�� �ڹٽ�ũ����. location�� JS�� �Լ�.  -->
	</body>
</html>