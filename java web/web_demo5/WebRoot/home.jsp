<%@page import="web_demo5.*"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%
StudentDao so=new StudentDAOImpl();
List<Student> stus=so.getStudentList();
%>
<html>
  <body>
  <table border="1" cellspacing="0" cellpadding="2" width="600">
  <tr>
  <th>学号</th>
  <th>姓名</th>
  <th>性别</th>
  <th>地址</th>
  </tr>
  <%if(stus==null||stus.size()==0){ %>
  <tr>
  <th colspan="4">对不起，没有任何记录 </th>
  </tr>
  <%}else{
	  for(int i=0;i<stus.size();i++){
		  Student stu=stus.get(i);
%>
	  <tr align="center">
	  <td><%=stu.getSid()%></td>
	   <td><%=stu.getSname()%></td>
	   <td><%=stu.getGender()%></td>
	    <td><%=stu.getAddress()%></td>
	   </tr>
<%			
			}
  	}
%>
  	</table>
  </body>
</html>
