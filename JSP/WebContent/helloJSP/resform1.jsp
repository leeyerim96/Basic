<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Response Test Form **</title>
</head>
<body>
<h3>** Response Test Form **</h3>
=> ReDirect & Forward<br>
<form action="/Jsp01/helloJSP/resMain.jsp" method="get">
	* 이 동 : <input type="text" name=site><br>
	* I D : <input type="text" name=id><br>
	<input type="submit" value="전 송">	
</form>
</body>
</html>