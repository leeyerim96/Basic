
package factoryFC;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//인터페이스 하는 이유
	// 모델을 수행하는 서비스 클래스들의 메서드의 이름을 동일이름으로 규정하기 위함
	//=> user() : 추상메서드로 정의
	//=> view의 이름을 리턴
public interface Action {
	
	public String user(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException;
	
}
