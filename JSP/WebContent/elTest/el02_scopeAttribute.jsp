<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** EL Test02 ScopeAttribute**</title>
</head>
<h3>** EL Test02 ScopeAttribute**</h3>
<body>
<% //1) 동일한 속성명을 모든 영역에 정의 => 적용 우선 순위 
	pageContext.setAttribute("name", "pageContext Value");
	request.setAttribute("name", "request Value");
	session.setAttribute("name", "session Value");
	application.setAttribute("name", "application Value");
	
	//2) 모두 다른 속성명을 모든 영역에 정의
	pageContext.setAttribute("namep", "pageContext Value2");
	request.setAttribute("namer", "request Value2");
	session.setAttribute("names", "session Value2");
	application.setAttribute("namea", "application Value2");

%>
test 1)  동일한 속성명을 모든 영역에 정의 => 적용 우선 순위 <br>
name : ${name}<br>
=> 좁은 범위부터 넓은 범위로 적용됨<br>
=> EL에 속성의 이름을 적용하면 해당 속성의 값이 출력됨 <br> 
=> 모두 구별하여 출력하려면 해당되는 영역을 속성명 앞에 붙여서 적용<br>
page name : ${pageScope.name }<br>
request name : ${requestScope.name }<br>
session name : ${sessionScope.name }<br>
application name : ${applicationScope.name }<br>
-----------------------------------------<br>
Test 2) 모두 다른 속성명을 모든 영역에 정의<br>
=> 속성명으로만 출력가능<br>

page : ${namep}<br>
request : ${namer}<br>
session : ${names}<br>
application : ${namea}<br>

</body>
</html>