package basicServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/life")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int ccount=1;  // ������ �޼���
	int icount=1;  // init �޼���
	int gcount=1;  // get �޼��� 
	int dcount=1;  // destory �޼���
       
    public LifeCycle() {
        super();
        System.out.println("������ �޼��� => "+ccount++);
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init: ù ��û�ÿ��� ȣ��Ǵ� �޼��� => "+icount++);
	}

	@Override
	public void destroy() {
		System.out.println("destroy: ��Ĺ ����ÿ��� ȣ��Ǵ� �޼��� => "+dcount++);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet: �޼��� ��û�� ���� ȣ��Ǵ� �޼��� => "+gcount++);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter() ;
		out.print("<h2>** Servlet LifeCycle Test **<br>");
		out.print("����ð� : "+new Date()+"<br>");
		out.print("gcount : "+gcount+"<br>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
