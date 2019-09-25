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

import java.util.*;

@WebServlet("/login") // �α������� �����̸��� �Ȱ��ƾ��� <form action="�����̸�">
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����ڸ�� �߰��ϱ� -> admin, 12345
		//Form���� ���۵� ���� ó�� 
		//-> request.get .....-> vo�� ���
		MemberVO vo = new MemberVO();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		HttpSession session=request.getSession();
		if(id.equals("admin") && password.equals("12345")) {
			// admin ������ session�� �����ϰ�, memberList ����ϱ�	
			session.setAttribute("loginID", id);
			response.sendRedirect("/Web01/mlist");
			return; // void �޼��忡�� �޼��� ���������
		}
		vo.setId(id);
		vo.setPassword(password);
		
		// DAO �� memberLogin ȣ��
		MemberDAO mdao = new MemberDAO();
		vo = mdao.memberLogin(vo);
		if(vo!=null) {
			//����  -> login ���� session ����
			//HttpSession session=request.getSession();
			session.setAttribute("loginID", vo.getId()); // ��𿡼����� �α���id�� �θ��� ����..EL�̿��ؼ�
			//���� test1. -> loginSuccess ���
			request.getRequestDispatcher("/login/loginSuccess.jsp").forward(request, response); 
			//�̿Ͱ���������� �α����ϸ� �ٷ� �����͸� ���� �Ҽ� ���� redirect�� �����!
			//���� test2. -> memberList ���
			//response.sendRedirect("/Web01/mlist"); // ��û�� �ϰ� ��û�� ��url�� ���� url�� �ٽ� ���û list.jsp �ι�° ��û�� ���� ������ ��
		}else {
		    //����
			request.getRequestDispatcher("/login/loginFail.jsp").forward(request, response);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}


