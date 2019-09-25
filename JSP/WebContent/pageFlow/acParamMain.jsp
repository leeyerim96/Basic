<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** ActionTag Param Main **</title>
</head>
<body>
<h3>** ActionTag Param Main **</h3>
=> include before Data 값<br>
=> Jsp01/pageFlow/acParamMain.jsp?name=홍길동&age=100<br>
<%	request.setCharacterEncoding("utf-8");
	String name=request.getParameter("name");
	int age=Integer.parseInt(request.getParameter("age"));
%>
name :<%=name%><br>
age :<%=age%><br>
<hr>
<jsp:include page="acParamSub.jsp">
	<jsp:param value="<%=name%>" name="myName"/>
	<jsp:param value="banana" name="name"/>
	<jsp:param value="<%=age%>" name="myAge"/>
</jsp:include>
<hr>
=> include after Data 값<br>
name :<%=name%><br>
age :<%=age%><br>
<hr>
=> helloJsp.jsp 를 include 하세요 ~~
<jsp:include page="../helloJSP/helloJsp.jsp"/>
=> 비교 Test
<% if (age>100) {
	request.getRequestDispatcher("acParamSub.jsp").forward(request, response);
	} else {
	response.sendRedirect("acParamSub.jsp?name=KimGilDong&age=220");
	}
%>
</body>
</html>