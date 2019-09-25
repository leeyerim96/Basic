package basicServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청확인 
		// => id=banana, pw=1234   : Login 성공
		// => 아니면 : 무조건 Login 실패 
		String id = request.getParameter("id") ;
		String password = request.getParameter("password") ;
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter() ;
		
		if (id.equals("banana") && password.equals("1234")) {
			out.print("~~ 안녕하세요~ "+id+"님 로그인 성공 ~~");
		}else out.print(id+"님 은 로그인 실패 ~~ 다시 하세요 ~~");
	} // doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
} // class
