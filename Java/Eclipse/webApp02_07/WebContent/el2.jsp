<%@page import="webApp02_07.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%
    ArrayList<String> singerList=new ArrayList<>();
    singerList.add("소녀시대");
    singerList.add("원더걸스");
    request.setAttribute("singerList", singerList);
    
    Customer[] customerList=new Customer[2];
    Customer cust1=new Customer();
    cust1.setName("홍길동");
    cust1.setEmail("hong@nate.com");
    cust1.setPhone("011-236-4789");
    
    Customer cust2=new Customer();
    cust2.setName("이순신");
    cust2.setEmail("lee@nate.com");
    cust2.setPhone("011-555-5555");
    
    customerList[0]=cust1;
    customerList[1]=cust2;
    request.setAttribute("customerList", customerList);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>${singerList[0]},${singerList[1]}</li>
	</ul>
	<ul>
		<li>이름:${customerList[0].name}</li>
		<li>메일:${customerList[0].email}</li>
		<li>전화:${customerList[0].phone}</li>
	</ul>
	<ul>
		<li>이름:${customerList[1].name}</li>
		<li>메일:${customerList[1].email}</li>
		<li>전화:${customerList[1].phone}</li>
	</ul>
	
</body>
</html>