<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	int num=Integer.parseInt(request.getParameter("num"));
	//내장객체
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	table{width:100px; margin:auto;}
	table thead td{background:orange;}
	table tbody td{background:yellow; border:1px solid; text-align:center;}
</style>
</head>
<body>
	<table>
		<thead>
			<tr><td>숫자:<%=num %></td></tr>
		</thead>
		<tbody>
		<% for(int i=0; i<num;i++){ %>
		<tr><td><%=i %></td></tr>
		<%} %>
		</tbody>
		<tfoot></tfoot>
	</table>
</body>
</html>