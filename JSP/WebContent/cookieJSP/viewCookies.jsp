<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** View Cookies **</title>
</head>
<body>
<h3>** View Cookies **</h3>
=> 현재 요청에 포함된 쿠키 목록 <br>
=> 웹 브라우져는 request header에 쿠키를 저장해서 보냄<br>
=> request.getCookies() : 배열타입이며 없으면 null을 return <br><br>

<% 
	Cookie[] ck = request.getCookies();
	if(ck!=null && ck.length>0){
		for(int i=0; i<ck.length; i++){
			out.print("name="+ck[i].getName());
			out.print(" , value= "+ck[i].getValue()+"<br>");
		} // for
	} else out.print("** 쿠키가 존재하지 않습니다~~<br>");
	
%>

</body>
</html>