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
		<p>부서번호 : ${dlist1.deptno } | 부서명 : ${dlist1.dname }</p>
		<c:forEach var="e" items="${dlist1.sawon }">
		<p>사원번호: ${e.sabun } |사원이름: ${e.saname } |사원직책: ${e.sajob } |
		사원급여: ${e.sapay }</p><br>
		<p>휴대폰번호: ${e.sphone.phnum } | 지급모델: ${e.sphone.pmodel } | 지급날짜: ${e.sphone.pdate } |  
		<hr />
		</c:forEach>
		
	</div>
</body>
</html>