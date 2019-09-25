package factoryFC;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.MemberDAO;
import vo.MemberVO;

public class Deletef implements Action {
	public String user(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		HttpSession session = request.getSession(false);
		
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
				request.setAttribute("sendR", "T");
				return "Web02/mlist.do";  // return�� ���ϸ� �޸��� �������� ó���ع���
			}else {
			
				session.invalidate();
				request.setAttribute("fCode", "DS");
			}
		}else 
		{
			request.setAttribute("fCode", "DF");
	
		}
		return "/member/doFinish.jsp";
		
	}
		
	}

