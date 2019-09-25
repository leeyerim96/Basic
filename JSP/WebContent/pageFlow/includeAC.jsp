<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** ActionTag Include Test **</title>
</head>
<body>
<h3>** ActionTag Include Test **</h3>
=> 여기는 main 화면 호출 전 입니다.<br>
<% int mainNum = 100 ; %>
<hr>
<%-- <jsp:include page="includeAC_Sub.jsp"/> --%>
<%@ include file="includeAC_Sub.jsp"%>
<hr>
=> 여기는 main 화면 호출 후 입니다.<br>
=>sub Data Test <br>
<%=subName%>, <%=mainNum%> 

</body>
</html>