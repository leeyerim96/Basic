<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Format(fmt) Test **</title>
</head>
<body>
<h3>**Formatting1 : DateTime Test **</h3>
<c:set var="now" value="<%= new java.util.Date() %>"></c:set>
now => ${now}<br>
date: <fmt:formatDate value="${now}" type="date"/><br>
time: <fmt:formatDate value="${now}" type="time"/><br>
both: <fmt:formatDate value="${now}" type="both"
				dateStyle="default" timeStyle="default"/><br>
short: <fmt:formatDate value="${now}" type="both"
				dateStyle="short" timeStyle="short"/><br>
medium: <fmt:formatDate value="${now}" type="both"
				dateStyle="medium" timeStyle="medium"/><br>	
long: <fmt:formatDate value="${now}" type="both"
				dateStyle="long" timeStyle="long"/><br>
full: <fmt:formatDate value="${now}" type="both"
				dateStyle="full" timeStyle="full"/><br><br>		
				
=> pattern : yyyy년 MM월 dd일 hh시 mm분 ss초 적용하기 <br>			
=> <fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초"/><br>	
=> 나라별 시간을 적용하려면 fmt:setTimeZone, fmt:timeZone 태그활용<br>
<hr>
<h3>**Formatting2 : Number Test **</h3>
<c:set var="money" value="123456789000"/>
<fmt:formatNumber value="${money}" pattern="###,###,###,###"/>원

</body>
</html>