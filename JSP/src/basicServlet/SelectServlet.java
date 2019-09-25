package basicServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// => ���� ������ ������Ʈ������ �ߺ��Ǹ� �ȵ�.
// => �׷��� �������� �̸��� ���� �� ����.
// => ��, url mapping name �� ���� ��밡�� ������ "Anonymous" �� ��Ĺ ���� �߻����ɼ�
//=> ��ҹ��� �����Ͽ� ��Ȯ �ؾ���.
//@WebServlet("/select")
//@WebServlet(urlPatterns={"/sel","/sele","/selec","/select"})
@WebServlet()
// => ��ȣ �ְų� ���ų� : web.xml ������ <url-pattern>/select</url-pattern>
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter() ;
		// url mapping name test
		out.print("<h2>~~ �ȳ��ϼ��� ~~ <br>");
		out.print("~~ url mapping name test �� �Դϴ� ~~<br><hr><br>");
		
		// select request test
		// �ܼ��� ����
		String job = request.getParameter("job") ;
		out.print("** ����� ������ ������ => "+job+"�Դϴ� **<br>");
		// ������ ����
		out.print("** ����� ���ɺо� **<br>");
		String[] interest = request.getParameterValues("interest") ;
		if (interest==null) {
			out.print("~~ ���� �׸��� �����ϴ�. ~~<br>");
		} else {
			for (String i:interest) {
				out.print(i+" , ");
			}
		}
		out.print("<br><br><a href='javascript:history.go(-1)'>�ٽ� ���� �ϱ�</a></h2><br>");
	} // doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
