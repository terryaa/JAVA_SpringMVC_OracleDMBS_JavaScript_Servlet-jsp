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
<%-- 
\${5+2} : ${5+2} <br>
\${5 / 2 } : ${5/2 } <br>
\${5 mod 2} : ${5 mod 2 }<br>
\${2 gt 10} : ${2 gt 10 } <br>
<%
	String input=null;	
%>
\${empty input} : ${empty input }<br>
--%>

<ul>
<c:forEach begin="1" end="10" step="1" var="i">
<c:if test="${i%2==0 }">
<span style="color:blue;">${i}</span><br>
</c:if>
<c:if test="${i%2!=0 }">
<span style="color:red;">${i}</span><br>
</c:if>
</c:forEach>
</ul>
</body>
</html>