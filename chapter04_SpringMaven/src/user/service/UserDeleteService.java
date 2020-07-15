package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserDeleteService implements UserService {
	@Autowired
	UserDAO userDAO;
	
	@Override
	public void execute() {
		ApplicationContext context = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");
		userDAO = context.getBean("userDAOImpl", UserDAO.class);
	
		Scanner scanner = new Scanner(System.in);
		System.out.print("삭제할 아이디 입력 : ");
		String id = scanner.next();
		
		UserDTO userDTO = userDAO.getUser(id);
		
		if(userDTO == null) {
			System.out.println("\n찾는 아이디가 없습니다.");
			return;
		}
		
		userDAO.delete(id);
		
		System.out.println("삭제되었습니다.");
		
	}

}
