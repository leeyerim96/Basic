<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** ActionTag Param Sub **</title>
</head>
<body>
<h3>** ActionTag Param Sub **</h3>
<%request.setCharacterEncoding("utf-8");%>
1) main 의  변수의 값 => 출력 불가능  <br>
 ---><%-- <%=name%> , <%=age%>  --%> <br>
 ---><%-- <%=request.getParameter("myName")%>,
 	 <%=request.getParameter("myAge")%><br> --%>
2) param name =><%=request.getParameter("name") %><br>
3) param age =><%=request.getParameter("age") %><br>
<%-- <% int age=Integer.parseInt(request.getParameter("age"));
		age*=2;%> 
4) age*2=<%=age%><br> --%>

</body>
</html>