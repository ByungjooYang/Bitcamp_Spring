package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Calc calcAdd = context.getBean("calcAdd", Calc.class);
		Calc calcMul = context.getBean("calcMul", Calc.class);
		
		calcAdd.calculate();
		calcMul.calculate();
		
	}
}
