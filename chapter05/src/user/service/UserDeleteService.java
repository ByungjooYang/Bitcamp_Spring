package user.service;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Setter
public class UserDeleteService implements UserService {
	UserDTO userDTO;
	UserDAO userDAO;
	
	@Override
	public void execute() {
		ApplicationContext context = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");
		userDAO = context.getBean("userDAOMyBatis", UserDAO.class);
	
		Scanner scanner = new Scanner(System.in);
		System.out.print("삭제할 아이디 입력 : ");
		String id = scanner.next();
		
		userDTO = userDAO.getUser(id);
		
		if(userDTO == null) {
			System.out.println("\n찾는 아이디가 없습니다.");
			return;
		}
		
		userDAO.delete(id);
		
		System.out.println("삭제되었습니다.");
		
	}

}
