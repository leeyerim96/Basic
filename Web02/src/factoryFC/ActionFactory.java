package factoryFC;
// �̱��� ���� : �ν��Ͻ��� 1���� ���
// => �����ڸ� private���� ���ο����� �����ϰ�
// => ���ο��� ���� ��������
// => �ܺο����� getInstance() �޼��带 ���� ���
public class ActionFactory {
		// �����ڸ� private ���� ����
		private ActionFactory() {}
		
		// ���ο��� getInstance() �޼���
		private static ActionFactory instance = new ActionFactory();
		public static ActionFactory getInstance() {
			return instance;
		}
		
		//��û�� ���� ��ü�� �����Ͽ� return
		public Action getAction(String path) {         // ������
			Action action = null ;
			if(path.equals("/mlist.do")) {
				action = new Listf();
			}else if(path.equals("/mdetail.do")) {
				action = new Detailf();
			}else if(path.equals("/login.do")) {
				action = new Loginf();
			}else if(path.equals("/mdelete.do")) {
				action = new Deletef();
			}else if(path.equals("/mupdate.do")) {
				action = new Updatef();
			}else if(path.equals("/mjoin.do")) {
				action = new Joinf();
			}
			
			return action;
		} //getAction
} // class
