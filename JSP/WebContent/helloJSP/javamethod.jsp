<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** JAVA 선언부 Test **</title>
</head>
<body>
<h3>** JAVA 선언부 TEST **</h3>
=> 선언부(Declaration): 메서드 정의 <br>
=> 두개의 정수를 매개변수로 받아 add한 결과를 return 하는 메서드 구현 <br><br>

<%! public int adder(int a, int b){
   return a+b;
   }%>
   
=> adder 결과2: <%=adder(7,8)%> 
<br><br>
=> adder 호출 (쿼리 스트링으로 2개의 숫자값을 request 받아 처리)
<%   String n1 = request.getParameter("n1");
   String n2 = request.getParameter("n2");
   int m1 = Integer.parseInt(n1);
   int m2 = Integer.parseInt(n2);
%>
<br>
=> adder 결과2: <%=adder(m1,m2)%>   


</body>
</html>