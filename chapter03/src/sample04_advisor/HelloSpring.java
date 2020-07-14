package sample04_advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext04.xml");
		MessageBean bean = context.getBean("proxy", MessageBean.class);
		
		//study만 공통관심사항 삽입된당.
		//advisor는 언제 끼어들 것인지. 이것을 확장한 것이 aspect이다 advice와  pointcut을 합친것.
		bean.study();
		System.out.println("================");
		System.out.println("결과 : " + bean.game());
		System.out.println("================");
		bean.lesson();
		
	}

}
