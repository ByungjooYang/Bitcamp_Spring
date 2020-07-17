package user.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Setter
public class UserSelectService implements UserService {
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		ApplicationContext context = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");
		userDAO = context.getBean("userDAOMyBatis", UserDAO.class);
		
		List<UserDTO> list = userDAO.getUserList();
		
		System.out.println("이름\t아이디\t비밀번호");
		for(UserDTO userDTO : list) {
			System.out.println(userDTO);
		}
		
	}

}
