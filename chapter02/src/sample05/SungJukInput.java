package sample05;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SungJukInput implements SungJuk {
	private SungJukDTO2 sungJukDTO2;
	private HelloSpring helloSpring;
	
	public SungJukInput(HelloSpring helloSpring) {
		this.helloSpring = helloSpring;
	}
	
	public void setSungJukDTO2(SungJukDTO2 sungJukDTO2) {
		this.sungJukDTO2 = sungJukDTO2;
	}
	
	@Override
	public void execute() {
		Scanner scanner = helloSpring.getScanner();
		//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//sungJukDTO2 = context.getBean("sungJukDTO2", SungJukDTO2.class);
		System.out.print("이름 입력 : ");
		sungJukDTO2.setName2(scanner.next());
		System.out.print("국어 입력 : ");
		sungJukDTO2.setKor2(scanner.nextInt());
		System.out.print("영어 입력 : ");
		sungJukDTO2.setEng2(scanner.nextInt());
		System.out.print("수학 입력 : ");
		sungJukDTO2.setMath2(scanner.nextInt());
		
		sungJukDTO2.calcTot2();
		sungJukDTO2.calcAvg2();
		
		helloSpring.getList().add(sungJukDTO2);
	}

}
