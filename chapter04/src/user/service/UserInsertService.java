package user.service;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Setter
public class UserInsertService implements UserService {
	private UserDTO userDTO;
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		ApplicationContext context = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");
		userDTO = context.getBean("userDTO", UserDTO.class);
		
		System.out.print("이름 입력 : ");
		userDTO.setName(scanner.next());
		System.out.print("아이디 입력 : ");
		userDTO.setId(scanner.next());
		System.out.print("비밀번호 입력 : ");
		userDTO.setPwd(scanner.next());
		
		userDAO = context.getBean("userDAOImpl", UserDAO.class);
		
		userDAO.write(userDTO);
		
		System.out.println();
		System.out.println("★DB에 저장★");
		System.out.println();
		
		
	}

}
