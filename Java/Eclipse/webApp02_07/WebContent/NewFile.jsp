<%@page import="webApp02_07.MyObjectDemo"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		MyObjectDemo ref=new MyObjectDemo();
		int num=1;
		
	%>
	<p><%= ref.message(num) %></p>

</body>
</html>