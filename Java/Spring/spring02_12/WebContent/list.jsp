<%@page import="java.util.List"%>
<%@page import="collection.Ex1List"%>
<%@page
	import="org.springframework.context.support.GenericXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
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
		ApplicationContext ctx = 
		new GenericXmlApplicationContext("collection/list.xml");
		Ex1List list1 = ctx.getBean("list1", Ex1List.class);
		Ex1List list2 = ctx.getBean("list2", Ex1List.class);
		List<String> strList = list1.getItems();

		for (String s : strList) {
	%>
	<%=s%>
	<%
		}
	%><br>



</body>
</html>