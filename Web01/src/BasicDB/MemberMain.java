package BasicDB;
import java.util.*;

import util.MemberDAO;
import vo.MemberVO;

// memberList ����ϱ�
public class MemberMain {

	public static void main(String[] args) {
		// DAO�� memberList ȣ�� 
		MemberDAO mdao = new MemberDAO();
		ArrayList<MemberVO> list = mdao.memberList();
		// ��¹� �ۼ�
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i).getId()+", ");
			System.out.print(list.get(i).getPassword()+", ");
			System.out.print(list.get(i).getName()+"\n");
		} // for
	
	} // main

} // class
