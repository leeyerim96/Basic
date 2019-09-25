<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,util.*,vo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Member List Test JSP **</title>
</head>
<body>
<h3>** Member List Test JSP **</h3>
</body>
<%	MemberDAO mdao = new MemberDAO();
	ArrayList<MemberVO> list = mdao.memberList();

	out.print("<b>** Member List **<br>");
	out.print("ID ----- Password ----- Name </b><br>");
	for(int i=0; i<list.size(); i++) {
		out.print(list.get(i).getId()+", ");
		out.print(list.get(i).getPassword()+", ");
		out.print(list.get(i).getName()+"<br>");
} // for
%>
</html>