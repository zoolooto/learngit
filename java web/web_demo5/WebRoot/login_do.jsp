<%@ page language="java" import="java.util.*" import="web_demo5.*" contentType="text/html; charset=UTF-8"%>
<%
String sid=request.getParameter("name");
String pwd=request.getParameter("pwd");
StudentDao so=new StudentDAOImpl();
if(so.getStudent(sid, pwd)==null)
	response.sendRedirect("index.jsp");
else response.sendRedirect("home.jsp");
%>
