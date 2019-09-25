<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** JSP 구구 단 </title>
</head>
<body>
   <% 
   for(int i=1; i<10; i++){
      for(int j=2; j<10; j++){
   %>
   <%=i%>*<%=j%>=<%=i*j%>&nbsp;&nbsp;
   <%}
      }%>
   
   
   <h3> **JSP 구구단2 **</h3>
   <% for(int i=1; i<=9; i++){
	   for(int j=2; j<=9; j++){
	   out.print(j+"*"+i+"="+(j*i)+"&nbsp;&nbsp;");
	   }
	   out.print("<br>");
	   }
	%>
	
</body>
</html>