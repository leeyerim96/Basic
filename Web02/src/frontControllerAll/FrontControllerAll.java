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

//@WebServlet(urlPatterns = {"*.do"})   // 모든 요청을 하나의 컨트롤러가 처리할 수 있게끔  //web.xml로도 처리할 수 있음
public class FrontControllerAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontControllerAll() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 요청분석
		// -> url 분석 , 해당 서비스를 찾아줌
		// -> 한글처리 , 변수 선언
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8"); // 응답나갈 페이지에 대한  (jsp에 이미 다 써있기때문에 안써도 됨)

		String uri = request.getRequestURI();   // 뭐라고 입력할지 모르게때문에 request에서 찾아서 분석  // url은 전체 다 uri는 현재 내 pc에서의 파일정보..? ex) /Web02/mlist.do 
		String path = uri.substring(uri.lastIndexOf("/"));    // 찾아 내기 위해 subString 사용 
		System.out.println("** uri =>" + uri);
		System.out.println("** path =>" + path);

		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession(false);
		String id = null;
		String password = null;
		String sendR = "", vName = "/index.jsp";    //리다이렉트할것인지 포워드 할것인지 모르기 때문에 일단 변수명 sendR을 만들어줌

		// 2. 해당 서비스 처리
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
			
			//login 종료

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
					System.out.println("**** loginID 값 null ****");
			} else
				System.out.println("**** session 값 null ****");
			if (vo != null && id != null) {
				vName = "/member/detailView.jsp";
			} else { // doFinish.jsp 로 forward
				request.setAttribute("fCode", "D");
				vName = "/member/doFinish.jsp";
			}

		}  // 비즈니스 모듈
		// 3. View 처리

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
