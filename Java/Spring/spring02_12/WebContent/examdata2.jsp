<%@page import="org.springframework.context.support.GenericXmlApplicationContext"%>
<%@page import="exam.ExamBeanInter"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
String type = request.getParameter("con");
ApplicationContext ctx = new GenericXmlApplicationContext("exam/exam.xml");
ExamBeanInter examBean = ctx.getBean("exam", ExamBeanInter.class);
examBean.callExecutebean(type);
String msg = examBean.getMessageBean();
%>^_^ : <%=msg %>