<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** for 02 begin, end, step **</title>
</head>
<body>
<h3>** for 02 begin, end, step **</h3>
=> 첫번째 출력할 인덱스 값, 마지막에 출력할 인덱스 값, 증가 인덱스 값<br>
문제1. 1~10까지를 1행에 출력하기 <br>
=> 1, 2, 3, ...., 10 <br>
<%-- 
	for(int i=0; i<arr.length; i++){
	}
--%>

<c:forEach var="i" begin="1" end="10" varStatus="vs">
${i} <c:if test="${not vs.last}">,</c:if>
</c:forEach>
<br><br>
문제2. 1~10에서 table을 이용하여 <br>
짝수값과 index, count 출력하기
<table border=1 style= "text-align:center" width=50%;>
<tr><th>i</th><th>Index</th><th>Count</th></tr>
<c:forEach var="i" begin="2" end="10" varStatus="vs" step="2">
<tr>
<td>${i}</td> <td>${vs.index}</td><td> ${vs.count}</td> <br>
</tr> 
</c:forEach>
</table>
<br>
문제3. 1~30을 다음처럼 한 행에 5개씩 출력하기<br>
1,2,3,4,5
6,7,8,9,10
11,12,13,14,15
...
...............30 <br>
<c:forEach var="i" begin="1" end="30" varStatus="vs">
${i} <c:if test="${i%5==0}"><br></c:if> <c:if test="${i%5!=0}">,</c:if>
</c:forEach>



</body>
</html>