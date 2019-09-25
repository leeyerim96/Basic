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


@WebServlet("/mdetail")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
         	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) request(요청) 분석
		// => My Id 확인 // session에 attribute가 가지고있음
		//     -> login 확인, id 가져오기 ( session 에서)
		HttpSession session = request.getSession(false);
		// -> 매개변수 : false : session이 때에 따라서 없을 수도 없음 그래서 session 없을 때 -> null값  return
		// -> 매개변수 : false가 아닌 경우 : session 없을 때 -> 만들어서  return -> 그러므로 null 값 안나옴
		String id = null;
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
	
		if (session != null) {
			id = (String)session.getAttribute("loginID"); 
			if (id!=null) {
				// 2) Model(DAO) 호출
				// -> 관리자 기능 추가
				if(id.equals("admin")) 
					vo.setId(request.getParameter("id"));
				else vo.setId(id);
				
				vo = dao.mDetail(vo);
				request.setAttribute("Apple", vo);  // request session
			}else System.out.println("** loginID 값 null **");
			
		}else System.out.println("***session 값 null ***");
		
		// 3) response 처리 -> View(jsp) 호출
		if (vo != null && id!=null ) {
			//detailView.jsp로 forward
			request.getRequestDispatcher("/member/detailView.jsp").forward(request, response);
		}else // doFinish.jsp로 forward
		{
			request.setAttribute("fCode", "D");
			request.getRequestDispatcher("/member/doFinish.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
