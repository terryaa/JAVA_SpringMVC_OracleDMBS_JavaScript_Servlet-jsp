<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<ul>
		<li><a href="./">Home</a></li>
		<!-- ������ ������ �α׾ƿ�, ������ ������ �α��� -->
		<li><a href="mykosta">
			<c:choose>
				<c:when test="${sessionScope.uid ==null }">
					<a href="loginForm">�α���</a>
				</c:when>
				<c:otherwise>
					${sessionScope.uname }�� <a href="logout">�α׾ƿ�</a>
				</c:otherwise>
			</c:choose></a></li>
		<li><a href="voteform">
			<c:choose>
				<c:when test="${sessionScope.uid == null }">
					<a href="member">ȸ������</a>
				</c:when>
				<c:otherwise>
					<a href="Mypage">����������</a>
				</c:otherwise>
			</c:choose>
		</a></li>
		<li><a href="board">�Խ���</a></li>
		<li><a href="jsoup3">UI���� ����</a></li>
		<li><a href="ckeditor">CkEditor</a></li>
		<li><a href="txf">Transaction ����</a></li>
	</ul>