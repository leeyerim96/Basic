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
		// 1) request(요청) 분석
		// => My Id 확인 // session에 attribute가 가지고있음
		//     -> login 확인, id 가져오기 ( session 에서)
		HttpSession session = request.getSession(false);
		// -> 매개변수 : false : session이 때에 따라서 없을 수도 없음 그래서 session 없을 때 -> null값  return
		// -> 매개변수 : false가 아닌 경우 : session 없을 때 -> 만들어서  return -> 그러므로 null 값 안나옴
		String id = null;
		int cnt = 0;
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
	
		if (session != null) {
			id = (String)session.getAttribute("loginID"); 
			if (id!=null) {
				// 2) Model(DAO) 호출
				if(id.equals("admin")) 
					vo.setId(request.getParameter("id"));
				else vo.setId(id);
				
				cnt = dao.mDelete(vo);
				request.setAttribute("Apple", vo);  // request session
			}else System.out.println("** loginID 값 null **");
			
		}else System.out.println("***session 값 null ***");
		
		// 3) response 처리 -> View(jsp) 호출
		if (cnt >0) {
			// 관리자 모드 삭제 성공 : mlist 
			if(id.equals("admin")) {
				response.sendRedirect("/Web01/mlist");
				return ;  // return을 안하면 쭈르륵 내려가서 처리해버림
			}else {
			//회원이 delete 성공 : session 삭제       // 로그인 했을 당시에 세션에 저장되어 있던 값들도 없애줘야함! 세션값을 지워줘야 함!
				session.invalidate();
				request.setAttribute("fCode", "DS");
			}
		}else // doFinish.jsp로 forward
		{
			request.setAttribute("fCode", "DF");
	
		}
		request.getRequestDispatcher("/member/doFinish.jsp").forward(request, response); // 무조건 dofinish 회원 탈퇴!
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
