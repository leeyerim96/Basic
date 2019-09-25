<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page errorPage="errorMessage.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Error Test **</title>
</head>
<body>
<h3>** Error Test **</h3>
** Test1. page 디렉티브 의 속성 : errorPage, isErrorPage 이용<br><br>
=> ArithmeticException : by Zero 에러 유도<br>
test code : 2/1 = <%=2/1%>

** Test2. web.xml : 응답 코드별로 작성 가능<br>
=> 404<br>
=> 500<br>
=> NullPointerException<br>
I D : <%=request.getParameter("id").toUpperCase()%>
<br><br>
** Test3. Error 처리 우선순위<br>
=> 1)현재 Page , 2)web.xml 의 exceptionType , <br>
 3)web.xml 의 응답코드 , 4) 서버의 Default 화면<br>

</body>
</html>