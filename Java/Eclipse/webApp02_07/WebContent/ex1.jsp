<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<%!
//선언부
	private String msg="ok";
	public String test(){
		return "himan";
	}
%>
<title>Insert title here</title>
</head>
<body>

	<div style="width: 300px; background:orange;">
		<%
			String testMsg=test();
			//위치는 어디있어도 상관이 없다.
			//스크립트 릿(service 메서드 영역)
			//지역변수이며 service영역 안에있는것과같다.
		%>
		<%-- 표현식 out.println(testMsg)와 같다. --%>
		<%=
		testMsg
		%>
</body>
</html>