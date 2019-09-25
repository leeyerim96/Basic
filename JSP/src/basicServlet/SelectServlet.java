package basicServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// => 매핑 네임은 프로젝트내에서 중복되면 안됨.
// => 그러나 여러개의 이름을 가질 수 있음.
// => 단, url mapping name 은 예약어도 사용가능 하지만 "Anonymous" 는 톰캣 오류 발생가능성
//=> 대소문자 구별하여 정확 해야함.
//@WebServlet("/select")
//@WebServlet(urlPatterns={"/sel","/sele","/selec","/select"})
@WebServlet()
// => 괄호 있거나 없거나 : web.xml 에서는 <url-pattern>/select</url-pattern>
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter() ;
		// url mapping name test
		out.print("<h2>~~ 안녕하세요 ~~ <br>");
		out.print("~~ url mapping name test 중 입니다 ~~<br><hr><br>");
		
		// select request test
		// 단수의 선택
		String job = request.getParameter("job") ;
		out.print("** 당신이 선택한 직업은 => "+job+"입니다 **<br>");
		// 복수의 선택
		out.print("** 당신의 관심분야 **<br>");
		String[] interest = request.getParameterValues("interest") ;
		if (interest==null) {
			out.print("~~ 선택 항목이 없습니다. ~~<br>");
		} else {
			for (String i:interest) {
				out.print(i+" , ");
			}
		}
		out.print("<br><br><a href='javascript:history.go(-1)'>다시 선택 하기</a></h2><br>");
	} // doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
