<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="webApp02_07.oddEven"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
<%
	String choice=request.getParameter("button");
	oddEven oddeven=new oddEven();
	boolean result=oddeven.oddeven(choice);
	if(result)
		%><p>�����Դϴ� </p>
<%
else
%><p>Ʋ�Ƚ��ϴ�!</p>
</body>
</html>