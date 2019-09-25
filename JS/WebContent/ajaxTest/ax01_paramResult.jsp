<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Ajax Parameter Test View (Get/Post) **</title>
</head>
<body>
<h3>** Ajax Patameter Test 전송 내용 **</h3>
I D => ${param.id}<br>
P W => <%=request.getParameter("password")%><br>
Name=> ${param.name}<br>
</body>
</html>