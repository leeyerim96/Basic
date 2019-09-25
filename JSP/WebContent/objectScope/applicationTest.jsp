<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Application 객체 Test **</title>
</head>
<body>
<h3>** Application 객체 Test **</h3>
1) 서버 정보 출력 하기 <br>
서버정보 : <%=application.getServerInfo()%><br>
서블릿 규약 메이저 버전 : <%=application.getMajorVersion()%><br>
서블릿 규약 마이너 버전 : <%=application.getMinorVersion()%><br>
2) 초기화 파라미터 읽어오기<br>
=> Application 실행전에 web.xml에 준비해 놓은 parameter값<br>
<ul>
<%	Enumeration<String> iNames= application.getInitParameterNames();
	while (iNames.hasMoreElements()) { %>
		<li>
		<%out.print(iNames.nextElement());        
	}
%>
</ul>
3) Application 실제 경로 알아보기<br>
* 웹 애플리케이션의 컨텍스트 경로명 :<%=application.getContextPath()%><br>
* 웹 애플리케이션의 파일 경로명 :<%=application.getRealPath("applicationTest.jsp")%><br>
</body>
</html>