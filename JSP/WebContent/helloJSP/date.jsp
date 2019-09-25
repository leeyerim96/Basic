<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> ** JSP_Date Test **</h1>
=> JAVA 를 이용해서 현재 날짜 시간 출력 하기 <br>
<% String name= "홍길동"; 
   java.util.Date now = new java.util.Date(); %>
=> <%=now%><br> <!-- 자바의 변수이므로  써야함 -->
=> name : <%=name%>
<hr>
<h3> ** request Test ** </h3>
<% String id = request.getParameter("id");
   String password= request.getParameter("password"); %>
id : <%=id%> <br>
password : <%=password%>
</body>
</html>