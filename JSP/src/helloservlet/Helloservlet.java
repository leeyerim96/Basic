package helloservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Helloservlet")
public class Helloservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. hello 출력
		// response.setContentType("text/html");
		
		// 2. 한글출력
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print("<html><body><h2 style=\"color:blue\">");
		out.print("** hello servlet **<br>");
		out.print("안녕하세요~~~~<br>");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

// 두 개의 메소드 기본 제공
// main 필요없음
// 웹에서는 요청을 두가지 방식으로 get , post 
// 