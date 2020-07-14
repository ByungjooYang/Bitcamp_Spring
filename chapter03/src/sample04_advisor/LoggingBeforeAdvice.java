package sample04_advisor;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

//공통 관심 사항
//aspect
public class LoggingBeforeAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("입실 췤");
		
	}
	
}
