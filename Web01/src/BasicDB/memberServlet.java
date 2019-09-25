package BasicDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MemberDAO;
import vo.MemberVO;


@WebServlet("/memberServlet")
public class memberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DAO의 memberList 호출 
		MemberDAO mdao = new MemberDAO();
		ArrayList<MemberVO> list = mdao.memberList();
		// 출력문 작성 -> 웹브라우저

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("** Member List **<br>");
		out.print("ID ----- Password ----- Name <br>");
		for(int i=0; i<list.size(); i++) {
			out.print(list.get(i).getId()+", ");
			out.print(list.get(i).getPassword()+", ");
			out.print(list.get(i).getName()+"<br>");
		} // for

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
