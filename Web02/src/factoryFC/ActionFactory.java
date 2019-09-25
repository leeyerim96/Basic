package factoryFC;
// 싱글톤 패턴 : 인스턴스를 1개만 허용
// => 생성자를 private으로 내부에서만 생성하고
// => 내부에서 생성 제공해줌
// => 외부에서는 getInstance() 메서드를 통해 사용
public class ActionFactory {
		// 생성자를 private 으로 정의
		private ActionFactory() {}
		
		// 내부에서 getInstance() 메서드
		private static ActionFactory instance = new ActionFactory();
		public static ActionFactory getInstance() {
			return instance;
		}
		
		//요청에 따른 객체를 생성하여 return
		public Action getAction(String path) {         // 다형성
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
