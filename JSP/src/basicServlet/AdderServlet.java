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
		// ��û ó��
		// Get ��Ŀ����� "UTF-8" �� Default
		// �׷��� post �����  ��쿡�� �ݵ�� �ѱ� ���ڵ� ����� �����ؾ���.
		request.setCharacterEncoding("UTF-8");
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String name = request.getParameter("name") ;
		// ��û ��� ���� ó��=> �ѱ�ó��
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter() ;
		out.print("<h2>** ���� ��� **<br>");
		out.print("�̸� : "+name+"<br>");
		out.print("��� : "+num1+" + "+num2+" = "+(num1+num2)+"<br>");
		out.print("<br><br><a href='javascript:history.go(-1)'>�ٽ� ���� �ϱ�</a></h2><br>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
