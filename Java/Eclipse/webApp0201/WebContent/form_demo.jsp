<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%-- �������� �Ⱥ��̴� jsp �ּ�
addMember��� �������� �Ķ���Ͱ����� �����ϴ� ����
������:addMember��� ���� �޾Ƽ� ó���ϴ� ����...
 --%>
<form action="addMemJDBC" method="post">
                		<table style="margin:auto"; width:80%;">
                			<tr>
                				<th style="color:red; height:40px">name</th>
                				<td>
                				<input type="text" name="name" id="name"
                				style="height:30px"; font-size:13px">
                				</td>
                			</tr>
                			<tr>
                				<th>deptno</th>
                				<td>
                				<input type="password" name="deptno" id="deptno">
                				</td>
                			</tr>
                			<tr>
                				<th>sajob</th>
                				<td>
                				<input type="text" name="sajob" id="sajob">
                				</td>
                			</tr>
                			<tr>
                				<th>sapay</th>
                				<td>
                				<input type="text" name="sapay" id="sasay">
                				</td>
                			</tr>
                			<tr>
                				<th>gender</th>
                				<td>
                				<input type="text" name="gender" id="gender">
                				</td>
                			</tr>
                			<tr>
                			<td colspan="2" style="text-align:right">
                				<input type="submit" value="����">
                			</td>
                		</table>
                		</form>
</body>
</html>