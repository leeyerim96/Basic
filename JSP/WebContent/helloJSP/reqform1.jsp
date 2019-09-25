<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** request Form test **</title>
</head>
<body>
<h3>** request Form test **</h3>
<form action="/Jsp01/helloJSP/requestInfo.jsp" method="post">
=> Test1 -> adder Test <br>
* ID : <input type="text" name=id value="banana"> <br>
* PassWord : <input type="password" name=password value="1234"> <br>
* Name : <input type="text" name=name value="홍길동"> <br>
* 취미 * <br>
<input type="checkbox" name=hobby value="game">Game<br>
<input type="checkbox" name=hobby value="sport">Sport<br>
<input type="checkbox" name=hobby value="trip">Trip<br>
<input type="checkbox" name=hobby value="musin">music<br>
<input type="checkbox" name=hobby value="movie">movie<br>
<input type="submit" value="전송">
</form>
<hr>


</body>
</html>