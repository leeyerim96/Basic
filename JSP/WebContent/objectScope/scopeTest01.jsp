<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Scope Test01_setAttribute **</title>
</head>
<body>
<h3>** Scope Test01_setAttribute **</h3>
<%	pageContext.setAttribute("name", "pageContextValue");
	request.setAttribute("name","requestValue");
	session.setAttribute("name","sessionValue");
	application.setAttribute("name","applicationValue");
	System.out.println("** file-name: scopeTest01.jsp **");
	System.out.println("** pageContext:"+pageContext.getAttribute("name"));
	System.out.println("** request:"+request.getAttribute("name"));
	System.out.println("** session:"+session.getAttribute("name"));
	System.out.println("** application:"+application.getAttribute("name"));
	System.out.println("** ID:"+request.getParameter("id"));
	// 출력 Test1 forward
	//request.getRequestDispatcher("scopeTest02.jsp").forward(request, response);
	// 출력 Test2 sendRedirect
	response.sendRedirect("scopeTest02.jsp");
%>
</body>
</html>