<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>deptalllist.jsp</title>
<style> #wrap{width: 800px; margin: auto;}</style>
</head>
<body>
	<div id="wrap">
		<p>�μ���ȣ : ${dlist.deptno } | �μ��� : ${dlist.dname }</p>
		<c:forEach var="e" items="${dlist.sawon }">
		<p>�����ȣ: ${e.sabun } |����̸�: ${e.saname } |�����å: ${e.sajob } |
		����޿�: ${e.sapay }</p>
		<hr />
		</c:forEach>
	</div>
</body>
</html>