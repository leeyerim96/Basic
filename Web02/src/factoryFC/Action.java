
package factoryFC;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�������̽� �ϴ� ����
	// ���� �����ϴ� ���� Ŭ�������� �޼����� �̸��� �����̸����� �����ϱ� ����
	//=> user() : �߻�޼���� ����
	//=> view�� �̸��� ����
public interface Action {
	
	public String user(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException;
	
}
