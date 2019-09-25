 package myController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MemberDAO;
import vo.MemberVO;

import java.util.*;

@WebServlet("/mlist")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ListController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDAO mdao = new MemberDAO();
		ArrayList<MemberVO> list = mdao.memberList();
		request.setAttribute("banana", list );
		request.getRequestDispatcher("/member/memberList.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}


