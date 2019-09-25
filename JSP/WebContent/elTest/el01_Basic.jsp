<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** EL Test01 Basic **</title>
</head>
<body>
<h3>** EL Test01 Basic **</h3>
=> EL : 표현 언어 (EL, Expression Language) <br>
=> 이렇게 값(Value)를 출력하면 편하다 <br><br>
1) Java => <%="자바의 표현식"%><br>
2) JavaCode out객체 => <% out.print("JavaCode out객체<br>"); %>
3) EL => ${"** Hello EL **"}<br>

<hr>

** EL의 자료형 <br>
정수형: ${10}<br>
실수형:${10.123}<br>
문자형:${"안녕하세요~~~~EL"}<br>
논리형:${true}<br>
null: ${null}<br>
----------------------------------------------------<br>
**EL 의 자료형 <br>
=> 4칙연산<br>
\${5+2} => ${5+2}<br>
\${5-2} => ${5-2}<br>
\${5*2} => ${5*2}<br>
\${5/2} => ${5/2}<br>
\${5%2} => ${5%2}<br>
\${5mod2} => ${5 mod 2}<br><br>

=> 관계연산<br>
gt : greater than /  lt : less than<br>
ge : greater equal /  le : less equal<br>
\${5gt2} => ${5 gt 2}<br>
\${5ge2} => ${5 ge 2}<br>
\${5lt2} => ${5 lt 2}<br>
\${5le2} => ${5 le 2}<br>
\${5>2} => ${5 > 2}<br>
\${5>=2} => ${5 >= 2}<br>
\${5>2 ? 5:2} => ${5>2 ? 5:2}<br>
\${5>2 && 10>100} => ${5>2 && 10>100}<br>
\${5>2 || 10>100} => ${5>2 || 10>100}<br>

----------------------------------------------------<br>
** EL에서 자바변수와 request의 파라미터 처리**<br>
1) 자바 변수=> 불가능  <br>
<% String name="홍길동"; %>
\${name} => ${name}<br>
\${emptyname} => ${empty name}<br>
2) request의 파라미터 처리<br>
javaCode id => <%=request.getParameter("id") %><br>
EL id => ${param.id}<br>
동일표현 => ${param["id"]}<br>
\${emptyparam.id} => ${empty param.id}<br>
<!--  => empty : 검사할 객체가 비어있는지 확인
				비어있으면 true
				list, map 타입의 객체가 값이 있는지 없는지 구분해줌
				=> EL 에 자바변수는 직접 값을 전달하지 못함 
				(jsp에서 자바코드가 완전 분리됨을 목표로하기떄문에 자바변수를 사용)
				=>-->
</body>
</html>