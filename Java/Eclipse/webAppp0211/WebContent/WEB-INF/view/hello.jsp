<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>hello</title>
</head>
<body>
<h1>${msg } / ${sessionScope.uid}</h1>
<c:choose >
	<c:when test="${sessionScope.uid==null }">
	<a href="*.kosta?cmd=greeting&id=login">로그인</a>
	</c:when>
	<c:otherwise>
	${ sessionScope.uid} 님 반갑습니다.
	<a href="*.kosta?cmd=logout">로그아웃</a>
	</c:otherwise>
</c:choose>
</body>
</html>