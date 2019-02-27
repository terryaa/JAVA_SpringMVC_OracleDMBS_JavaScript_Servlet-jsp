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
			<ul><li>Home|</li>
				<li>
				<c:choose>
					<c:when test="${sessionScope.uid==null }">
						<a href="loginForm">로그인</a>
					</c:when>
					<c:otherwise>
						${sessionScope.uname }님 <a href="logout">로그아웃</a>
					</c:otherwise>
				</c:choose>
				|</li>
				<li>
				<c:choose>
					<c:when test="${sessionScope.uid == null }">
						<a href="member">회원가입</a>
					</c:when>
					<c:otherwise>
						<a href="mypage">마이페이지</a>
					</c:otherwise>
				</c:choose>
				|</li>
				<li><a href="">부서리스트</a>|</li>
				<li><a href="">사원리스트</a>|</li>
				<li>IP:</li>
			</ul>
		</div>
		<div id="content">메인페이지 내용입니다.</div>
				<div id="footer">
			<ul>
				<li>개인정보 보호정책</li>
				<li>회사소개</li>
				<li>사이트맵</li>
			</ul>
		</div>
	</div>
   
</body>
</html>