<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>**JSTL Basic **</title>
</head>
<body>
<h3>**JSTL Basic **</h3>
1) 출력 : out tag<br>
=> JAVA 의 표현식을 대신하고, <br>
=> out 객체, EL을 대신 할 수 있 음. <br><br>
<c:out value="Hello JSTL ~~~Welcome!!!"></c:out><br>

2) set & remove Test<br><br>
=> set : 변수의 정의와 값 부여 <br>
<c:set var="age" value="100" scope="page"></c:set>
<c:set var="name">홍길동</c:set>
\${age} => ${age}<br>
\${name} => ${name}<br>
c:out =>
<c:out value="${age123}" default="200"></c:out><br>
<c:out value="${age123}">300</c:out><br>
=> 변수 age가 없거나, value값이 없는 경우, <br>
=> default와 body의 지정값 출력<br>
<hr>
3) 연산 적용 <br>
<c:set var="add" value="${123+456}"></c:set>
add => ${add}<br>
<c:set var="bool" value="${123==456}"></c:set>
bool => ${bool}<br>
4) 변수 삭제 <br>
<c:remove var="bool"/>
remove bool => ${empty bool}<br>
</body>
</html>