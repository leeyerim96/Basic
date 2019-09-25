<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** for 01 **</title>
</head>
<body>
<h3>** forEach 01 기본 형식 **</h3>
=> 배열을 정의하고 이를 전달받아 JSTL로 출력하기 <br>
<%
	String[] actorList = { "비비안","엘리자베스","제임스","로버트"};
	// 현재 이 페이지에서만 쓸것이기 때문에 page
	pageContext.setAttribute("star", actorList);
%>

<c:forEach var ="starName" items="${star}">
${starName}<br>
</c:forEach>
<h3>** forEach 02 varStatus 속성활용 **</h3>
<table border=1 style="text-align: center" width: 100%;>
<tr><th>starName</th><th>Index</th><th>Count</th></tr>
<c:forEach var="starName" items="${star}" varStatus="vs">
<tr>
<td>${starName}</td> <td>${vs.index}</td><td> ${vs.count}</td> <br>
</tr>
</c:forEach>
</table>

<h3>** forEach 03 varStatus 속성 활용II</h3>
=> first , last , 중첩 <br>
=> 첫번째 자료의 이름은 굵은 파랑색으로 출력<br>
=> 마지막 자료는 ',' 없이 출력한다 <br>
<ul>
	<c:forEach var="starName" items="${star}" varStatus="vs">
	<c:choose>
		<c:when test="${vs.first}">
		<li style="font-weight: bold; color:blue;">${starName} ,</li>
		</c:when>
		
		<c:when test="${vs.last}">
		<li>${starName}</li>
		</c:when>
		
		<c:otherwise><li>${starName} ,</li></c:otherwise>
	</c:choose>  
	</c:forEach>
</ul>
</body>
</html>