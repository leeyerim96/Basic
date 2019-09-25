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
		// 1. ��û�м�
		// -> url �м� , �ش� ���񽺸� ã����
		// -> �ѱ�ó��
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html); charset=utf-8");
		
		//http://localhost:9090/Web01/mlist
		String uri = request.getRequestURI();
		String path= uri.substring(uri.lastIndexOf("/"));
		System.out.println("** uri=>"+uri);
		System.out.println("** path=>"+path);
		System.out.println("** getRequestURL"+request.getRequestURL());
		
		// 2. �ش� ���� ó��
		// => ����(ActionFactory)�� �ñ�
		// => ActionFactory�� �̱������� ó�� // �̱���-> �����ϰ� �ϳ��� �ν��Ͻ����� ����ϴ°�..?
		// => ��û�� path�� �˷��� => �ش� ���� ��ü�� return 
		ActionFactory af = ActionFactory.getInstance();
		Action action =	af.getAction(path);  // �׼��� �� �Ѿ� �Դ���
		String vName = "/index.jsp";
		if (action!=null)
		 vName = action.user(request, response); // ���� ��Ŵ
		// 3. View ó��
		if((request.getAttribute("sendR")!=null) && (request.getAttribute("sendR").equals("T")))
				response.sendRedirect(vName);
		else request.getRequestDispatcher(vName).forward(request, response); 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
