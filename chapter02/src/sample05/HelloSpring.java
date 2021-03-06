package sample05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
	private List<SungJukDTO2> list;
	private Scanner scanner;
	
	public void setList(List<SungJukDTO2> list) { this.list = list; }
	public List<SungJukDTO2> getList(){	return list; }
	public void setScanner(Scanner scanner) { this.scanner = scanner; }
	public Scanner getScanner() { return scanner; }
	
	
	public void menu(ApplicationContext context) {
		String choice;
		//scanner = new Scanner(System.in);
		list = new ArrayList<SungJukDTO2>();
		while(true) {
			System.out.println();
			System.out.println("======================");
			System.out.println("	1. 입력");
			System.out.println("	2. 츨력");
			System.out.println("	3. 수정");
			System.out.println("	4. 삭제");
			System.out.println("	5. 끝");
			System.out.println("======================");
			System.out.print("번호를 입력해주세요 : ");
			choice = scanner.next(); // nextInt로 받을시 숫자 외의 문자가 들어오면 에러가 떠서 문자열로 받은 후 비교함.
			
			if(choice.equals("5")) break;
			
			if(choice.equals("1")) {
				context.getBean("sungJukInput", SungJuk.class).execute();
				
			}else if(choice.equals("2")) {
				context.getBean("sungJukOutput", SungJuk.class).execute();
				
			}else if(choice.equals("3")) {
				context.getBean("sungJukModify", SungJuk.class).execute();
				
			}else if(choice.equals("4")) {
				context.getBean("sungJukDelete", SungJuk.class).execute();
				
			}else {
				System.out.println();
				System.out.println("1~5사이의 숫자를 입력해주세요.");
			}
			
		}
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloSpring helloSpring = context.getBean("helloSpring", HelloSpring.class);	
		helloSpring.scanner = new Scanner(System.in);
		helloSpring.menu(context);
		helloSpring.scanner.close();
	}
}
