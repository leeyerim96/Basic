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

@WebServlet("/login") // 로그인폼의 맵핑이름과 똑같아야함 <form action="맵핑이름">
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//관리자모드 추가하기 -> admin, 12345
		//Form에서 전송된 값을 처리 
		//-> request.get .....-> vo에 담기
		MemberVO vo = new MemberVO();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		HttpSession session=request.getSession();
		if(id.equals("admin") && password.equals("12345")) {
			// admin 계정을 session에 보관하고, memberList 출력하기	
			session.setAttribute("loginID", id);
			response.sendRedirect("/Web01/mlist");
			return; // void 메서드에서 메서드 종료시켜줌
		}
		vo.setId(id);
		vo.setPassword(password);
		
		// DAO 의 memberLogin 호출
		MemberDAO mdao = new MemberDAO();
		vo = mdao.memberLogin(vo);
		if(vo!=null) {
			//성공  -> login 정보 session 보관
			//HttpSession session=request.getSession();
			session.setAttribute("loginID", vo.getId()); // 어디에서든지 로그인id를 부를수 있음..EL이용해서
			//성공 test1. -> loginSuccess 출력
			request.getRequestDispatcher("/login/loginSuccess.jsp").forward(request, response); 
			//이와같은방식으로 로그인하면 바로 데이터를 보게 할수 없음 redirect를 써야함!
			//성공 test2. -> memberList 출력
			//response.sendRedirect("/Web01/mlist"); // 요청을 하고 요청이 웹url에 가면 url이 다시 재요청 list.jsp 두번째 요청에 의해 나오게 됨
		}else {
		    //실패
			request.getRequestDispatcher("/login/loginFail.jsp").forward(request, response);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}


