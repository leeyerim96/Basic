<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** forTockens Test **</title>
</head>
<body>
<h3>** 1. forTockens Test **</h3>
=> 구분자로 각각의 토큰을 처리할 때 사용한다.<br>
=> test 1<br>
<c:forTokens var="city" items="서울,동경,북경,파리.뉴욕" delims=",">
${city} <br> 
</c:forTokens>
=> test 2<br>
<c:forTokens var="city" items="서울,동경,북경,파리.뉴욕" delims=",.">
${city} <br> 
</c:forTokens>
<hr>
<h3>** 2. JSTL import Test **</h3>
=> jsp:include 와 동일 효과 <br>
=> 즉 실행결과가 포함되므로 변수공유 안됨<br>
=> var 속성을 이용할 수도 있음 <br>
<c:import var="jstlImportPage" url="jstl03_for02.jsp"></c:import>

-------------------------------------<br>
${jstlImportPage}<br>
-------------------------------------<br>

<hr>
<h3>** 3. JSTL reDirect Test **</h3>
=>response.sendRedirect()와 동일 기능<br>
=>웹 브라우저의 주소창의 url이 변경됨 <br>
<c:redirect url="jstl03_for02.jsp"></c:redirect>
</body>
</html>