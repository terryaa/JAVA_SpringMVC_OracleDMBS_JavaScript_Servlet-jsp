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
		<p>�μ���ȣ : ${dlist1.deptno } | �μ��� : ${dlist1.dname }</p>
		<c:forEach var="e" items="${dlist1.sawon }">
		<p>�����ȣ: ${e.sabun } |����̸�: ${e.saname } |�����å: ${e.sajob } |
		����޿�: ${e.sapay }</p><br>
		<p>�޴�����ȣ: ${e.sphone.phnum } | ���޸�: ${e.sphone.pmodel } | ���޳�¥: ${e.sphone.pdate } |  
		<hr />
		</c:forEach>
		
	</div>
</body>
</html>