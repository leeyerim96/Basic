package basicServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/radio")
public class RadioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RadioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// get ��� : ��Ĺ������ get ��Ŀ����� �ѱ� �Է°��� ���ڵ��� �⺻������  UTF-8 �� ó��
		// post ��� : �׷��� Post ��Ŀ����� �׷��� �ʱ� ������ �ѱ����ڵ� ����� �����ؾ� ��
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter() ;
		// ��û ó��
		// 1) radio button => getParameter("gender")
		String gender = request.getParameter("gender") ;
		String mail = request.getParameter("mailCheck") ;
		// 2) text area => getParameter("content")
		String content = request.getParameter("content") ;
		
		out.print("<h2>����� ������ "+gender+"�Դϴ� ~~~<br>" );
		out.print("���ϼ���: "+mail+"<br>" );
		out.print("�����λ�: <br>");
		out.print(content+"<br></h2>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
