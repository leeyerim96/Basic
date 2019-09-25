<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** JSTL 조건문 Test Form **</title>
</head>
<body>
<h3>** JSTL 조건문 Test Form **</h3>
<form action="jstl02_ifTest.jsp" method="get">
<label for="color">** 색상 선택 **</label><br>
	<select name=color id=color>
		<option value="1">빨강</option>
		<option value="2">노랑</option>
		<option value="3">초록</option>
		<option value="4">파랑</option>
		<option value="5">ERROR</option>
	</select><br>

<input type="submit" value="전송">

</form>
</body>
</html>