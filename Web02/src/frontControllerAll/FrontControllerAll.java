package frontControllerAll;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.MemberDAO;
import vo.MemberVO;

//@WebServlet(urlPatterns = {"*.do"})   // ��� ��û�� �ϳ��� ��Ʈ�ѷ��� ó���� �� �ְԲ�  //web.xml�ε� ó���� �� ����
public class FrontControllerAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontControllerAll() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. ��û�м�
		// -> url �м� , �ش� ���񽺸� ã����
		// -> �ѱ�ó�� , ���� ����
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8"); // ���䳪�� �������� ����  (jsp�� �̹� �� ���ֱ⶧���� �Ƚᵵ ��)

		String uri = request.getRequestURI();   // ����� �Է����� �𸣰Զ����� request���� ã�Ƽ� �м�  // url�� ��ü �� uri�� ���� �� pc������ ��������..? ex) /Web02/mlist.do 
		String path = uri.substring(uri.lastIndexOf("/"));    // ã�� ���� ���� subString ��� 
		System.out.println("** uri =>" + uri);
		System.out.println("** path =>" + path);

		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession(false);
		String id = null;
		String password = null;
		String sendR = "", vName = "/index.jsp";    //�����̷�Ʈ�Ұ����� ������ �Ұ����� �𸣱� ������ �ϴ� ������ sendR�� �������

		// 2. �ش� ���� ó��
		if (path.equals("/mlist.do")) {
			ArrayList<MemberVO> mlist = dao.memberList();
			request.setAttribute("banana", mlist);
			vName = "/member/memberList.jsp";

		} else if (path.equals("/login.do")) {

			id = request.getParameter("id");
			password = request.getParameter("password");

			if (id.equals("admin") && password.equals("12345")) {
				session.setAttribute("loginID", id);
				sendR = "T";
				vName = "/Web02/mlist.do";
			} else {

				vo.setId(id);
				vo.setPassword(password);
				MemberDAO mdao = new MemberDAO();
				vo = mdao.memberLogin(vo);
				if (vo != null) {
					session.setAttribute("loginID", vo.getId());
					vName = "/login/loginSuccess.jsp";
				} else {
					vName = "/login/loginFail.jsp";
				}

			}
			
			//login ����

		} else if (path.equals("/mdetail.do")) {
			if (session != null) {
				id = (String) session.getAttribute("loginID");
				if (id != null) {
					if (id.equals("admin"))
						vo.setId(request.getParameter("id"));
					else
						vo.setId(id);
					vo = dao.mDetail(vo);
					request.setAttribute("Apple", vo);
				} else
					System.out.println("**** loginID �� null ****");
			} else
				System.out.println("**** session �� null ****");
			if (vo != null && id != null) {
				vName = "/member/detailView.jsp";
			} else { // doFinish.jsp �� forward
				request.setAttribute("fCode", "D");
				vName = "/member/doFinish.jsp";
			}

		}  // ����Ͻ� ���
		// 3. View ó��

		if (sendR.equals("T"))
			response.sendRedirect(vName);
		else
			request.getRequestDispatcher(vName).forward(request, response);
	} // doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
