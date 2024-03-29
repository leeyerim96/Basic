package factoryFC;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MemberDAO;
import vo.MemberVO;

public class Joinf implements Action {
	public String user(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		// post 방식에서는 "utf-8"로 반드시 한글처리
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
		
		// 2) DAO 호출
		int cnt = dao.mInsert(vo);   // 몇 건이 업데이트 되었는지  
		// 3) View 호출
		if(cnt > 0) {
			// Join 성공 -> memberList 출력
			request.setAttribute("joinID", id);
			request.setAttribute("fCode", "JS");
			return "/member/doFinish.jsp";
			
		} else {
			// Join 실패 -> doFinish.jsp 1114
			request.setAttribute("fCode", "JF");
			return "/member/doFinish.jsp";
		}
	
	}
}

