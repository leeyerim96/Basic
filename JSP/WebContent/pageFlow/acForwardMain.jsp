<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>**  ActionTag Forward Test _ Main  **</title>
</head>
<body bgcolor="red">
<h3>**  ActionTag Forward Test _ Main  **</h3>
<pre>
forward 를 실행하면 ...
과연 red 가 나타 날까요 yellow 가 나타날까요 ?
아니면 둘 다 나타 날까요 ?? 
</pre>
<jsp:forward page="acForwardSub.jsp"/>
</body>
</html>