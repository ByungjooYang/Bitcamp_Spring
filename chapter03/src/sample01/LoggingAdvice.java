package sample01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

//공통 관심 사항
//aspect
public class LoggingAdvice {
	public void beforeTrace() {
		System.out.println("before trace...");
		
	}
	
	public void afterTrace() {
		System.out.println("after trace...");
	}
	
	public void trace(ProceedingJoinPoint joinPoint) throws Throwable {
		//proceed() 가 핵심사항을 호출한다.
		//공통부분 처리
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println("메소드 명 : " + methodName);
		
		StopWatch sw = new StopWatch();
		sw.start();
		
		//핵심 관심 사항 호출
		//joinPoint.proceed();
		Object ob = joinPoint.proceed(); // print 메서드에 리턴값이 있을 때 이렇게 하면 값이 나옴.
		System.out.println("결과 ob : " + ob);
		
		
		//proceed가 핵심을 처리하고 다시 돌아옴. 그리고 공통부분 다시 처리
		sw.stop();
		
		System.out.println("처리 시간 = " + sw.getTotalTimeMillis()/1000 + "초");
	}
}
