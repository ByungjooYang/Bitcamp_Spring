package user.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import user.service.UserService;

@ComponentScan("user.conf")
public class HelloSpring {
	public void menu(ApplicationContext context) {
		Scanner scanner = new Scanner(System.in);
		int choice;
		while(true) {
			System.out.println("==================");
			System.out.println("	1. 입력");
			System.out.println("	2. 출력");
			System.out.println("	3. 수정");
			System.out.println("	4. 삭제");
			System.out.println("	5. 끝");
			System.out.println("==================");
			System.out.print("번호 입력 : ");
			choice = scanner.nextInt();
			
			if(choice==5) break;
			if(choice > 5 || choice < 1) System.out.println("1~5번 까지만 입력 가능합니다.");
			
			switch (choice) {
			case 1:
				context.getBean("userInsertService", UserService.class).execute();
				break;
				
			case 2:
				context.getBean("userSelectService", UserService.class).execute();
				break;
				
			case 3:
				context.getBean("userUpdateService", UserService.class).execute();
				break;
				
			case 4:
				context.getBean("userDeleteService", UserService.class).execute();
				break;
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");
		HelloSpring helloSpring = context.getBean("helloSpring", HelloSpring.class);
		
		helloSpring.menu(context);
	}

}
