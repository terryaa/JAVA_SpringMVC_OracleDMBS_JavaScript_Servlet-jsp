<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>dynamicSawonForeachList.jsp</title>
</head>
<body>
<form method="post" action="dyfor">
	<fieldset>
			<legend>��� ����Ʈ ����</legend>
			<div>
				<table style="width: 80%">
					<tr style="background: pink; height: 50px">
						<th>�����ȣ</th>
						<th>����̸�</th>
						<th>�μ���ȣ</th>
						<th>��å</th>
						<th>����</th>
						<th>���Գ�¥</th>
					</tr>
					<c:forEach items="${list}" var="svo">
						<tr align ="center">
						<td>${svo.sabun}</td>
						<td>${svo.saname}</td>
						<td>${svo.deptno}</td>
						<td>${svo.sajob}</td>
						<td>${svo.sgender}</td>
						<td>${svo.sahire}</td>	
						</tr>			
					</c:forEach>
					<tr>
						<th colspan="6">
						<input type="checkbox" name="dlist" value="10">10
						<input type="checkbox" name="dlist" value="20">20
						<input type="checkbox" name="dlist" value="30">30
						<input type="checkbox" name="dlist" value="40">40
						<input type="checkbox" name="dlist" value="50">50
						<input type ="submit" value="send"> 
					</tr>
				</table>
			</div>
			</fieldset>
</form>	
</body>
</html>