package myController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MemberDAO;
import vo.MemberVO;


@WebServlet("/mupdate")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) ��û  �м�
		// => -> request -> VO -> DAO 
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		// post ��Ŀ����� "utf-8"�� �ݵ�� �ѱ�ó��
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String lev=request.getParameter("lev");
		String pay=request.getParameter("pay");
		String birthd=request.getParameter("birthd");
		String weight=request.getParameter("weight");
		
		vo.setId(id);
		vo.setPassword(password);
		vo.setName(name);
		vo.setLev(lev);
		vo.setPay(Integer.parseInt(pay));
		vo.setBirthd(birthd);
		vo.setWeight(Double.parseDouble(weight));
		
		// 2) DAO ȣ��
		int cnt = dao.mUpdate(vo);   // �� ���� ������Ʈ �Ǿ�����  
		// 3) View ȣ��
		if(cnt > 0) {
			// �������� -> memberList ���
			response.sendRedirect("/Web01/mlist");
		} else {
			// ���� ���� -> doFinish.jsp 1114
			request.setAttribute("fCode", "U");
			request.getRequestDispatcher("/member/doFinish.jsp").forward(request, response);
		}
	
	} // mupdate
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
