package factoryFC;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//MVC2 Test
 
//@WebServlet(urlPatterns= {"*.do"})
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FrontController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청분석
		// -> url 분석 , 해당 서비스를 찾아줌
		// -> 한글처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html); charset=utf-8");
		
		//http://localhost:9090/Web01/mlist
		String uri = request.getRequestURI();
		String path= uri.substring(uri.lastIndexOf("/"));
		System.out.println("** uri=>"+uri);
		System.out.println("** path=>"+path);
		System.out.println("** getRequestURL"+request.getRequestURL());
		
		// 2. 해당 서비스 처리
		// => 공장(ActionFactory)에 맡김
		// => ActionFactory는 싱글톤으로 처리 // 싱글톤-> 유일하게 하나의 인스턴스에만 허락하는거..?
		// => 요청의 path를 알려줌 => 해당 서비스 객체를 return 
		ActionFactory af = ActionFactory.getInstance();
		Action action =	af.getAction(path);  // 액션이 잘 넘어 왔는지
		String vName = "/index.jsp";
		if (action!=null)
		 vName = action.user(request, response); // 일을 시킴
		// 3. View 처리
		if((request.getAttribute("sendR")!=null) && (request.getAttribute("sendR").equals("T")))
				response.sendRedirect(vName);
		else request.getRequestDispatcher(vName).forward(request, response); 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
