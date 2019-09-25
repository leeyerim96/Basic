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
	
	int ccount=1;  // 생성자 메서드
	int icount=1;  // init 메서드
	int gcount=1;  // get 메서드 
	int dcount=1;  // destory 메서드
       
    public LifeCycle() {
        super();
        System.out.println("생성자 메서드 => "+ccount++);
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init: 첫 요청시에만 호출되는 메서드 => "+icount++);
	}

	@Override
	public void destroy() {
		System.out.println("destroy: 톰캣 종료시에만 호출되는 메서드 => "+dcount++);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet: 메서드 요청시 마다 호출되는 메서드 => "+gcount++);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter() ;
		out.print("<h2>** Servlet LifeCycle Test **<br>");
		out.print("현재시간 : "+new Date()+"<br>");
		out.print("gcount : "+gcount+"<br>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
