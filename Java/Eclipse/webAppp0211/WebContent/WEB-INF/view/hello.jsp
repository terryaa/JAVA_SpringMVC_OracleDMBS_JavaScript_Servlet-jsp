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
	<a href="*.kosta?cmd=greeting&id=login">�α���</a>
	</c:when>
	<c:otherwise>
	${ sessionScope.uid} �� �ݰ����ϴ�.
	<a href="*.kosta?cmd=logout">�α׾ƿ�</a>
	</c:otherwise>
</c:choose>
</body>
</html>