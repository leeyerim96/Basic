<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** pageContext 객체 Test **</title>
</head>
<body>
<h3>** pageContext 객체 Test **</h3>
=> 기본객체를 return하는 메서드를 제공<br>
<%	HttpServletRequest pReq = (HttpServletRequest)pageContext.getRequest();	
%>
=> pReq 와 request객체 의 동질성 비교<br>
pReq==request => <%=pReq==request%><br>
pReq name => <%=pReq.getParameter("name")%><br>
=> pageContext 객체를 이용하여 out 객체로 출력하기 <br>
<%	pageContext.getOut().print("pageContext.getOut() 을 이용한 출력~~~<br>");
	out.print("out.. 을 이용한 출력~~~<br>");
%>

</body>
</html>