<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<%!
//�����
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
			//��ġ�� ����־ ����� ����.
			//��ũ��Ʈ ��(service �޼��� ����)
			//���������̸� service���� �ȿ��ִ°Ͱ�����.
		%>
		<%-- ǥ���� out.println(testMsg)�� ����. --%>
		<%=
		testMsg
		%>
</body>
</html>