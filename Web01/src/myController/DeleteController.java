package myController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.MemberDAO;
import vo.MemberVO;


@WebServlet("/mdelete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
         	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) request(��û) �м�
		// => My Id Ȯ�� // session�� attribute�� ����������
		//     -> login Ȯ��, id �������� ( session ����)
		HttpSession session = request.getSession(false);
		// -> �Ű����� : false : session�� ���� ���� ���� ���� ���� �׷��� session ���� �� -> null��  return
		// -> �Ű����� : false�� �ƴ� ��� : session ���� �� -> ����  return -> �׷��Ƿ� null �� �ȳ���
		String id = null;
		int cnt = 0;
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
	
		if (session != null) {
			id = (String)session.getAttribute("loginID"); 
			if (id!=null) {
				// 2) Model(DAO) ȣ��
				if(id.equals("admin")) 
					vo.setId(request.getParameter("id"));
				else vo.setId(id);
				
				cnt = dao.mDelete(vo);
				request.setAttribute("Apple", vo);  // request session
			}else System.out.println("** loginID �� null **");
			
		}else System.out.println("***session �� null ***");
		
		// 3) response ó�� -> View(jsp) ȣ��
		if (cnt >0) {
			// ������ ��� ���� ���� : mlist 
			if(id.equals("admin")) {
				response.sendRedirect("/Web01/mlist");
				return ;  // return�� ���ϸ� �޸��� �������� ó���ع���
			}else {
			//ȸ���� delete ���� : session ����       // �α��� ���� ��ÿ� ���ǿ� ����Ǿ� �ִ� ���鵵 ���������! ���ǰ��� ������� ��!
				session.invalidate();
				request.setAttribute("fCode", "DS");
			}
		}else // doFinish.jsp�� forward
		{
			request.setAttribute("fCode", "DF");
	
		}
		request.getRequestDispatcher("/member/doFinish.jsp").forward(request, response); // ������ dofinish ȸ�� Ż��!
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
