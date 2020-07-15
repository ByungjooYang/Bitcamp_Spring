package user.service;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Setter
public class UserUpdateService implements UserService {
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		ApplicationContext context = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");
		userDAO = context.getBean("userDAOImpl", UserDAO.class);
		Map<String, String> map = new HashedMap<String, String>();
		
		System.out.print("아이디를 입력해주세여 : ");
		String id = scanner.next();
		map.put("id", id);
		
		UserDTO userDTO = userDAO.getUser(id);
		
		if(userDTO != null) {
			System.out.print("새 이름를 입력해주세요 : ");
			map.put("name", scanner.next());
			System.out.print("새 비밀번호를 입력해주세요 : ");
			map.put("pwd", scanner.next());
			
			userDAO.modify(map);
			
			System.out.println("수정이 완료되었습니다.");
		
		} else {
			System.out.println("찾는 이름이 엄슴");
			return;
		}
	}

}
