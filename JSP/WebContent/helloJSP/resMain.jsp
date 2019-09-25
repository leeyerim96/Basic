<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Response Test **</title>
</head>
<body>
=> ReDirect & Forward<br>
=> forward : 현재의 요청 처리 (주소창의 url이 유지됨)<br>
=> sendRedirect : 재요청 처리 (주소창의 url이 변경됨)<br>
=> 서버 내의 현재 폴더위치에서 찾기 때문에 경로를 지정할때 주의<br>  
<% 	String site=request.getParameter("site");
	String id=request.getParameter("id"); 
	 /*if (site=="" && id=="")	{
		request.getRequestDispatcher("resform1.jsp").forward(request, response);
	}else if (id.equals("banana")) {
		//response.sendRedirect("guguJsp.jsp") ;
		response.sendRedirect("reqForm.jsp") ;
	}else {
		request.getRequestDispatcher("reqform1.jsp").forward(request, response);	
	} */
	if (site.equals("daum")) 
		request.getRequestDispatcher("http://www.daum.net").forward(request, response);
		//response.sendRedirect("http://www.daum.net");
	else if (site.equals("naver")) 
		response.sendRedirect("http://www.naver.com");
	else if (site.equals("oracle"))
		response.sendRedirect("http://www.oracle.com");
	else response.sendRedirect("hellojsp.jsp"); 
%>
</body>
</html>