package BasicDB;
import java.util.*;

import util.MemberDAO;
import vo.MemberVO;

// memberList 출력하기
public class MemberMain {

	public static void main(String[] args) {
		// DAO의 memberList 호출 
		MemberDAO mdao = new MemberDAO();
		ArrayList<MemberVO> list = mdao.memberList();
		// 출력문 작성
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i).getId()+", ");
			System.out.print(list.get(i).getPassword()+", ");
			System.out.print(list.get(i).getName()+"\n");
		} // for
	
	} // main

} // class
