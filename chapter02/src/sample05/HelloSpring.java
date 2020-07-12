package sample05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
	private List<SungJukDTO2> list = new ArrayList<SungJukDTO2>();
	private Scanner scanner;
	
	public void setList(List<SungJukDTO2> list) { this.list = list; }
	public List<SungJukDTO2> getList(){	return list; }
	public void setScanner(Scanner scanner) { this.scanner = scanner; }
	public Scanner getScanner() { return scanner; }
	
	
	public void menu(ApplicationContext context) {
		scanner = new Scanner(System.in);
		int choice;
		while(true) {
			System.out.println("======================");
			System.out.println("	1. 입력");
			System.out.println("	2. 츨력");
			System.out.println("	3. 수정");
			System.out.println("	4. 삭제");
			System.out.println("	5. 끝");
			System.out.println("======================");
			System.out.print("번호를 입력해주세요 : ");
			choice = scanner.nextInt();
			
			if(choice==5) {
				scanner.close();
				break;
			}
			
			if(choice==1) {
				context.getBean("sungJukInput", SungJuk.class).execute();
				
			}else if(choice==2) {
				context.getBean("sungJukOutput", SungJuk.class).execute();
				
			}else if(choice==3) {
				context.getBean("sungJukModify", SungJuk.class).execute();
				
			}else if(choice==4) {
				context.getBean("sungJukDelete", SungJuk.class).execute();
				
			}else {
				System.out.println("1~5사이의 숫자를 입력해주세요.");
			}
			
		}
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloSpring helloSpring = context.getBean("helloSpring", HelloSpring.class);	
		helloSpring.menu(context);
	}
}
