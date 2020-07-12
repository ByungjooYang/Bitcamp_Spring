package sample04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		int x = 25;
		int y = 36;
		
		//Calc calcAdd = new CalcAdd();
		//Calc calcMul = new CalcMul();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Calc calcAdd = context.getBean("calcAdd", Calc.class);	
		Calc calcMul = context.getBean("calcMul", Calc.class);
		
		calcAdd.calculate(x, y);
		calcMul.calculate(x, y);
		
		((AbstractApplicationContext)context).close();
	}

}
