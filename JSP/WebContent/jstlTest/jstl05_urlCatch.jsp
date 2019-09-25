<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** JSTL url, catch Test **</title>
</head>
<body>
<h3>** 1. url 속성 Test **</h3>
=> Value 의 값을 url로 인식 시켜줌<br>

=> test 1.1 : a Link<br>
<c:url var="aLink" value="jstl03_for02.jsp"/>
aLink=>${aLink}<br>
<a href="${aLink}">urlTest</a>
<hr>
=> test 1.2 : image <br>
<c:url var="iName" value="../image/summersea.jpg"/>
<img src="${iName}" width="400" height=150><br>
<hr>

<h3>** 2. catch 속성 Test ** </h3><br>
=> 예외상황을 처리해주는 Tag<br>
=> c:catch ~/c:catch 사이에서 Exception 발생 처리<br>
=> 예외발생시 발생한 Exception 객체를 var의 값에 저장하고 catch 문 밖으로 <br>
<c:catch var="e">
   예외상황 발생전<br>
 => 예외상황 10/0 <%=10/0%>
<%-- => 정상상황 10/2: <%=10/2%><br> --%>
   예외상황 발생후<br>
</c:catch>
=> e: ${e}<br>



</body>
</html>