<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div id="aticle">
	<div id="header2">
		<h1>�н���ǥ : UI Design : Jsoup ũ�Ѹ� �����ϱ�</h1>
		<p id="time">2019.02.21</p>
	</div>
	<div id="content">
		<div style="width: 600px">
<%-- 		<table border="1" style="color: black">${elements}</table> --%>
		<c:forEach items="${list}" var="ls">
		<table style="color: black">${ls }</table>
		</c:forEach>
		</div>
	</div>
	</div>