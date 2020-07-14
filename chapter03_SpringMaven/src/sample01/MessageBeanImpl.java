package sample01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

//핵심 관심 사항
//Target
//@Component
@ComponentScan("spring.conf")
public class MessageBeanImpl implements MessageBean {
	@Value("Have a nice day")
	private String str;

	public void setStr(String str) {
		this.str = str;
	}


	@Override
	public void showPrintBefore() {
		System.out.println("showPrintBefore 메시지 = " + str);
		
	}

	@Override
	public void viewPrintBefore() {
		try {
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
		
		System.out.println("viewPrintBefore = " + str);	
		
	}

	@Override
	public void display() {
		System.out.println("display 메시지 = " + str);
		
	}


	@Override
	public void showPrintAfter() {
		System.out.println("showPrintAfter = " + str);
	}


	@Override
	public void viewPrintAfter() {
		System.out.println("viewPrintAfter = " + str);
		
	}


	@Override
	public void showPrint() {
		try {
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
		System.out.println("showPrint = " + str);
	}


	@Override
	public void viewPrint() {
		System.out.println("viewPrint = " + str);
	}
	



}
