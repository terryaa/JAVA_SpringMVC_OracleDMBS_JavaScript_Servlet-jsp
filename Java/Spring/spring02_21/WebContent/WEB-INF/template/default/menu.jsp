<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<ul>
		<li><a href="./">Home</a></li>
		<!-- 세션이 있으면 로그아웃, 세션이 있으면 로그인 -->
		<li><a href="mykosta">
			<c:choose>
				<c:when test="${sessionScope.uid ==null }">
					<a href="loginForm">로그인</a>
				</c:when>
				<c:otherwise>
					${sessionScope.uname }님 <a href="logout">로그아웃</a>
				</c:otherwise>
			</c:choose></a></li>
		<li><a href="voteform">
			<c:choose>
				<c:when test="${sessionScope.uid == null }">
					<a href="member">회원가입</a>
				</c:when>
				<c:otherwise>
					<a href="Mypage">마이페이지</a>
				</c:otherwise>
			</c:choose>
		</a></li>
		<li><a href="board">게시판</a></li>
		<li><a href="jsoup3">UI적용 예제</a></li>
		<li><a href="ckeditor">CkEditor</a></li>
		<li><a href="txf">Transaction 예제</a></li>
	</ul>