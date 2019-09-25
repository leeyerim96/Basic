<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Scope Test02_getAttribute **</title>
</head>
<body>

** file-name: scopeTest02.jsp **<br>
** pageContext:<%=pageContext.getAttribute("name")%><br>
** request:<%=request.getAttribute("name")%><br>
** session:<%=session.getAttribute("name")%><br>
** application:<%=application.getAttribute("name")%><br>
** ID:<%=request.getParameter("id")%><br>
<a href="scopeTest03.jsp">scopeTest03.jsp</a>

</body>
</html>