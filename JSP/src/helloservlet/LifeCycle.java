package helloservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cycle")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	int ccnt =1;
	int icnt=1;
	int gcnt=1;
	int dcnt=1;
	
    public LifeCycle() {
        super();
        System.out.println("** 생성자=>"+ccnt++);
    }

    public void init(ServletConfig config) throws ServletException {
    	 System.out.println("** init: 첫 요청시에만 호출 =>"+icnt++);
    }
	
    public void destroy() {
    	 System.out.println("** destory: 소멸시에만 호출 =>"+dcnt++);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("** doGet: 호출시에만 호출 =>"+gcnt++);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h3>**Servlet Lifecycle Test **</h3>");
		out.print("<h3> 현재 시간 : "+new Date()+"</h3>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
