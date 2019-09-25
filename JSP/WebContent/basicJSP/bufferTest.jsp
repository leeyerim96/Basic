<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="1kb" autoFlush="true"%>
<!-- buffer="8kb" autoFlush="false" -> flush 됨 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Buffer Test **</title>
</head>
<body>
<h3>** Buffer Test **</h3>
=> default : buffer="8kb" autoFlush="true"<br>
=> autoFlush="true" : 버퍼가 다차면 flush 하고 계속 작업 진행<br>
=> autoFlush="false" : 버퍼가 다차면 무조건 exception 발생 (응답코드500)<br>
---------------------> 그러나 버퍼가 다차지 않으면 flush 됨.               
<% for (int i=0;i<1000;i++){%>
	12
<%}
	//if (true) throw new Exception() ;
	// autoFlush="true" 의 경우 마지막 buffer 의 내용이 Exception 으로 인하여 
	// 전송되지 못했음을 비교 Test 	
%> 
<br>** Good Bye : Page End **<br>
</body>
</html>