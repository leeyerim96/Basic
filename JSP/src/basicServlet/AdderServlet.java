package basicServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adder")
public class AdderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 처리
		// Get 방식에서는 "UTF-8" 이 Default
		// 그러나 post 방식의  경우에는 반드시 한글 인코딩 방법을 지정해야함.
		request.setCharacterEncoding("UTF-8");
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String name = request.getParameter("name") ;
		// 요청 결과 응답 처리=> 한글처리
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter() ;
		out.print("<h2>** 연산 결과 **<br>");
		out.print("이름 : "+name+"<br>");
		out.print("결과 : "+num1+" + "+num2+" = "+(num1+num2)+"<br>");
		out.print("<br><br><a href='javascript:history.go(-1)'>다시 선택 하기</a></h2><br>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
