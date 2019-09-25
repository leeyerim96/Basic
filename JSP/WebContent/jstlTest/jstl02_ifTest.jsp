<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** JSTL 조건문 Test**</title>
</head>
<body>
<h3>** JSTL 조건문 Test**</h3>
=>if Test<br>
<c:if test="${param.color==1}">
	<span style="color:red"> 빨강 선택 했습니다~~</span></c:if>
	<c:if test="${param.color==2}">
	<span style="color:yellow"> 노랑 선택 했습니다~~</span></c:if>
	<c:if test="${param.color==3}">
	<span style="color:green"> 초록 선택 했습니다~~</span></c:if>
	<c:if test="${param.color==4}">
	<span style="color:blue"> 파랑 선택 했습니다~~</span></c:if>
	<c:if test="${param.color==5}">
	<span style="color:purple"> ERROR </span></c:if>
	
	<br><br>
=>choose Test<br>
=> if 구문이 else가 없음을 보완 <br>
<c:choose>
	<c:when test="${param.color==1}">
		<span style="color:red">빨강 선택 했습니다~</span>
	</c:when>
	<c:when test="${param.color==2}">
	<span style="color:yellow"> 노랑 선택 했습니다~~</span>
	</c:when>
	<c:when test="${param.color==3}">
	<span style="color:green"> 초록 선택 했습니다~~</span>
	</c:when>
	<c:when test="${param.color==4}">
	<span style="color:blue"> 파랑 선택 했습니다~~</span>
	</c:when>
	<c:otherwise>
	<span style="color:purple"> ERROR </span>
	</c:otherwise>
</c:choose>
</body>
</html>