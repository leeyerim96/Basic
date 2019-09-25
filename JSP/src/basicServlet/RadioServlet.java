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
		// get 방식 : 톰캣서버는 get 방식에서는 한글 입력값의 인코딩을 기본적으로  UTF-8 로 처리
		// post 방식 : 그러나 Post 방식에서는 그렇지 않기 때문에 한글인코딩 방법을 지정해야 함
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter() ;
		// 요청 처리
		// 1) radio button => getParameter("gender")
		String gender = request.getParameter("gender") ;
		String mail = request.getParameter("mailCheck") ;
		// 2) text area => getParameter("content")
		String content = request.getParameter("content") ;
		
		out.print("<h2>당신의 성별은 "+gender+"입니다 ~~~<br>" );
		out.print("메일수신: "+mail+"<br>" );
		out.print("가입인사: <br>");
		out.print(content+"<br></h2>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
