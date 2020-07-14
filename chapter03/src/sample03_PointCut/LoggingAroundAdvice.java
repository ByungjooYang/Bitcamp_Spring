package sample03_PointCut;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("Around -> 입실 췤");
		long start = System.currentTimeMillis();
		
		Object ob = invocation.proceed();//핵심
		
		long end = System.currentTimeMillis();
		System.out.println("Around -> 퇴실 췤");
		System.out.println((end-start)/1000 + "초");
		
		return ob;
		
	}

}
