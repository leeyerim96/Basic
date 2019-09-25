package factoryFC;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MemberDAO;
import vo.MemberVO;

public class Updatef implements Action{
	public String user(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
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
				return "mlist.do";
			} else {
				// ���� ���� -> doFinish.jsp 1114
				request.setAttribute("fCode", "U");
				return "/member/doFinish.jsp";
			}
		
	}
}
