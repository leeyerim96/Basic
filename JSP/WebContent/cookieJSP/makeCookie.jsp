<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** 쿠키 생성 **</title>
</head>
<body>
<h3>** 쿠키 생성  **</h3> <!-- 생성자를 통해서 쿠키 생성 -->
<% Cookie ck1 = new Cookie("myCookie","greecComputer");
   Cookie ck2 = new Cookie("myName","그린컴퓨터");
   response.addCookie(ck1);
   response.addCookie(ck2);
%>
<h3> ** 쿠키 수정 & 삭제 **</h3>
=> 쿠키의 유효시간 <br>
=> setMaxAge(10) -> 초단위 (60 * 60 1시간)
=> 유효시간을 0로 주면  쿠키가 삭제 된다. <br>
<% Cookie[] ck = request.getCookies();
   if (ck !=null && ck.length>0){
      for (int i=0; i<ck.length; i++){
         if (ck[i].getName().equals("myCookie")){
            Cookie delck=new Cookie("myCookie","");
            delck.setMaxAge(0);      // 유효시간 0으로 설정, 쿠키 삭제.
            response.addCookie(delck);
         }//if
            if(ck[i].getName().equals("myName")){
            Cookie upck=new Cookie("myName","홍길동");
            upck.setMaxAge(20);
            response.addCookie(upck);
            }
      }// for
   }// if
%>

<h3>** 쿠키 목록 확인  **</h3>
===><a href="viewCookies.jsp">viewCookies</a><br>
</body>
</html>