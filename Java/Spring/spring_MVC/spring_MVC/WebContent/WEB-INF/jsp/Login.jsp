<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>mybatis-spring</title>
<link rel="stylesheet" type="text/css" href="resources/css/default.css">
</head>
<body>
	<div id="wrap">
		<div id="header">
			<ul><li><a href="/">Home</a>|</li>
				<li>
				<c:choose>
					<c:when test="true">
					<a href="loginForm">�α���</a>
					</c:when>
					<c:otherwise>
					�� <a href="logout">�α׾ƿ�</a>
					</c:otherwise>
				</c:choose>
				|</li>
				<li>
				<c:choose>
					<c:when test="true">
					<a href="member">ȸ������</a>
					</c:when>
					<c:otherwise>
					<a href="mypage">����������</a>
					</c:otherwise>
				</c:choose>
				|</li>
				<li><a href="">�μ�����Ʈ</a>|</li>
				<li><a href="">�������Ʈ</a>|</li>
				<li>IP:</li>
			</ul>
		</div>
		<div id="content">
			<fieldset style="width: 300px; margin: auto">
				<legend>�α��� ��</legend>
				<form method="post" action="loginProcess" 
				autocomplete="off">
				<p>
				<label>���̵�</label>
				<input type="text" name="id" id="id">
				</p>
				<p>
				<label>��й�ȣ</label>
				<input type="password" name="pwd" id="pwd">
				</p>
				<p style="text-align: right;">
				
				<input type="submit" value="�α��� ">
				</p>
				</form>
				
			</fieldset>
		</div>
				<div id="footer">
			<ul>
				<li>�������� ��ȣ��å</li>
				<li>ȸ��Ұ�</li>
				<li>����Ʈ��</li>
			</ul>
		</div>
	</div>
</body>
</html>