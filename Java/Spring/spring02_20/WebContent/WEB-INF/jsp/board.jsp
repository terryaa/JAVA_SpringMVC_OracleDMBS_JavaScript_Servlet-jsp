<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title></title>
</head>
<body>
	<form method="post" action="showboard">
		<fieldset>
			<legend>��� ����Ʈ ����</legend>
			<div>
				<table style="width: 80%">
					<tr style="background: pink; height: 50px">
						<th>no.</th>
						<th>title</th>
						<th>content</th>
						<th>id</th>
					</tr>
					<c:forEach items="${list }" var="bvo">
						<tr align ="center">
						<td>${bvo.num}</td>
						<td>${bvo.title}</td>
						<td>${bvo.content}</td>
						<td>${bvo.id}</td>
						</tr>			
					</c:forEach>
					<tr>
						<th colspan="5">
						���� �˻�:
						<input type="text" name="title">
						<input type="submit" value="send">
						<a href="writeboard" style="color: black">�Խñ��Է�</a>
						</th>
					</tr>
				</table>
			</div>
		</fieldset>
	</form>
</body>
</html>