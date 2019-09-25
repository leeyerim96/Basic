<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** ActionTag Include Test_ SUB **</title>
</head>
<body>
<h3>** ActionTag Include Test_ SUB **</h3>
=> Main 의 Data 호출<br>
<%=mainNum%><br>
<%mainNum+=123;%>
=> test Data 정의<br>
<% String subName="홍길동";%>
</body>
</html>