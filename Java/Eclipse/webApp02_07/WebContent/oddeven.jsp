<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%
	int num;
	//내장객체
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	div{width:300px;border:1px solid blue; margin:auto}
</style>
</head>
<body>
	<div>
		<form method="post" action="self">
			<p>숫자입력: <input type="number" name="num" ></p>
			<p><input type="submit" value="전송"></p>
			<%num=Integer.parseInt(request.getParameter("num")); %>
		</form>
	</div>
	<div>
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
	</div>
</body>
</html>