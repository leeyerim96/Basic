package factoryFC;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MemberDAO;
import vo.MemberVO;

public class Listf implements Action{
	public String user(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> mlist = dao.memberList();
		request.setAttribute("banana", mlist);
		return "/member/memberList.jsp";
		
	} //user

}
