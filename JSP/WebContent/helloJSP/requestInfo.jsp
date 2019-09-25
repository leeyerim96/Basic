<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** requestInfo Test **</title>
</head>
<body>
<h3>** requestInfo Test **</h3>
=> test1. 단수 parameter <br>
=> get/post(한글 인코딩 필요함) 방식 Test <br>
<%request.setCharacterEncoding("UTF-8"); %>
=>   <%= request.getParameter("id")%>  님 환영 합니다.<br>
=>   loginInfo : <%= request.getParameter("name")%>, 
				 <%= request.getParameter("password")%> <br>
				 
<hr>			 
=> test2. 복수 parameter <br>
=> 당신의 취미 <br>
	<%String[] hb = request.getParameterValues("hobby");
	  if(hb==null){
		  out.print("취미가 없습니다. <br>");
	  }else {
		  for(String h:hb){
			  out.print(h+"<br>");
		  }
	  }
	%>
	
	
<hr>
=> Test3. getParameterNames() <br>
=> 전송된 parameter의 이름은 <br>
<% Enumeration<String> pNames = request.getParameterNames();
   while(pNames.hasMoreElements()){
	   out.print(pNames.nextElement()+"<br>");
   }
%>

<hr>
=> Test4. getParameterMap() <br>
=> getParameterMap() 으로 ID 출력하기 <br>
<% Map<String,String[]> imap=request.getParameterMap(); 
   String[] iVal = imap.get("id");
   out.print("ID => "+iVal[0]);
%>

<br>
=> getParameterMap() 으로 Hobby 출력하기 <br>
<% String[] hVal = imap.get("hobby");
   for(String h : hVal){
	   out.print(h+" , ");
   }
%>


<hr>
=> Test5. request 객체의 주요 info 메서드 Test<br>
클라이언트IP = <%=request.getRemoteAddr() %><br>
요청정보길이 =<%= request.getContentLength() %><br>
요청정보 인코딩 =<%=request.getCharacterEncoding() %><br>
요청정보 컨텐츠타입=<%=request.getContentType() %><br>
요청정보 프로토콜 =<%=request.getProtocol() %><br>
요청정보 전송방식 =<%= request.getMethod() %><br>
요청 URL=<%=request.getRequestURL() %><br>
컨텍스트 경로=<%= request.getContextPath() %><br>
서버이름=<%=request.getServerName() %><br>
서버포트 =<%=request.getServerPort() %><br>
	
</body>
</html>