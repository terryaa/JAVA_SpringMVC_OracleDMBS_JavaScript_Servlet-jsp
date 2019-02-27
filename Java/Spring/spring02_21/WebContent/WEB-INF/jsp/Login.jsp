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
		<div id="content">
			<fieldset style="width: 300px; margin: auto">
				<legend>로그인 폼</legend>
				<form method="post" action="loginProcess" 
				autocomplete="off">
				<p>
				<label>아이디</label>
				<input type="text" name="id" id="id">
				</p>
				<p>
				<label>비밀번호</label>
				<input type="password" name="pwd" id="pwd">
				</p>
				<p style="text-align: right;">
				
				<input type="submit" value="로그인 ">
				</p>
				</form>				
			</fieldset>
		</div>
	</div>
</body>
</html>