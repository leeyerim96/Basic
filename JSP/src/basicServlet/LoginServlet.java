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
		// ��ûȮ�� 
		// => id=banana, pw=1234   : Login ����
		// => �ƴϸ� : ������ Login ���� 
		String id = request.getParameter("id") ;
		String password = request.getParameter("password") ;
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter() ;
		
		if (id.equals("banana") && password.equals("1234")) {
			out.print("~~ �ȳ��ϼ���~ "+id+"�� �α��� ���� ~~");
		}else out.print(id+"�� �� �α��� ���� ~~ �ٽ� �ϼ��� ~~");
	} // doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
} // class
