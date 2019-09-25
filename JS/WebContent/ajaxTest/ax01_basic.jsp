<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Ajax Test01 Basic **</title>
<script src="../jsLib/jquery-3.2.1.min.js"></script>
<script src="ax01_xhrTest.js"></script>
<script src="ax01_jqTest.js"></script>
<!-- Test1. Basic Test -->
<!-- Test2. JS Parameter Test -->
<!-- Test3. JQuery Param Test -->
<!-- Ajax 란?
	 비동기 방식의 javascript와 xml을 가리킴. 
	 동기방식은 서버에 신호를 보냈을 때 응답이 돌아와야 다음 동작을 수행할 수 있고
	 비동기방식은 그와 바내돌 신호를 보냈을 때 응답상태와 상관없이 다음 동작을 수행할 수 있다는 점이 다름
	 웹브라우저와 상관없이 자바스크립트가 클라이언트의 요청을 처리 -->

</head>
<body>
<h3>** Ajax : 서버와의 비동기식 통신 **</h3>
<form action="#">
	I D : <input type="text" id=id name=id value="banana"><br>
	P W : <input type="password" id=password name=password value="12345"><br>
	NAME: <input type="text" id=name name=name value="홍길동"><br><br>
	1.JavaScript Basic Test =>&nbsp;&nbsp;
		<input type="button" value="Basic" onclick="startMethod()"><br>
	2.JavaScript Param Test =>
	<input type="button" value="Get전송" onclick="startMethodG()">&nbsp;
	<input type="button" value="post전송" onclick="startMethodP()"><br>
	3.JQuery Param Test =>&nbsp;&nbsp;&nbsp;
	<input type="button" value="JQuery(G/P)" id=jqTest><br>
</form>
<hr>
<div  id=resultArea>
</div>
</body>
</html>