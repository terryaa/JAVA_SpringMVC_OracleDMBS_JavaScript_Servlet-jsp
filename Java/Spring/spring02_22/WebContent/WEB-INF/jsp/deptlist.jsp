<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>deptlist.jsp</title>
<style>
	#wrap{width: 800px; margin: auto;}
	table{border: 1px dotted; width: 100%}
	td{border: 1px solod;}
	.no{width: 20%; background: orange; text-align: center;}
</style>
</head>
<body>
	<div id="wrap">
		<table>
			<tr><th>부서번호</th><th>부서명</th><th>위치</th></tr>
			<c:forEach var="e" items="${dlist }">
				<tr>
					<td class="no">${e.deptno }</td>
					<td style="text-align: center">&nbsp;&nbsp;${e.dname }</td>
					<td style="text-align: center">&nbsp;&nbsp;${e.loc }</td>
				</tr>		
			</c:forEach>
		</table>
	</div>
</body>
</html>