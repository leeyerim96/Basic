package basicServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/check")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter() ;
		
		// ������ ������ �ϴ°�� => getParameterValues("item")
		String[] userno = request.getParameterValues("userno");
		/*
		 * out.print("<h2>** ����� ������ �׸� **<br>"); if (items==null)
		 * out.print(" ������ �׸��� �����ϴ�.<br>"); else { for (int i=0;i<items.length;i++) {
		 * out.print(items[i]+" , "); } }
		 */
		out.print("<br><br><a href='javascript:history.go(-1)'>�ٽ� ���� �ϱ�</a></h2><br>");
	} // doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
