package aop.ex0;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MessageAdvice implements MethodInterceptor {

	//공통관심사항1 ---- advice적용영역
	//핵심로직 수행   ---- 메서드호출
	//공통관심사항2 ----advice적용영역
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("타겟보다 먼저 처리될 로직 ! before전처리");
		Object rev=invocation.proceed();
		System.out.println("타겟이 수행 된 후 처리 될 로직!After 후처리!!");
		
		//전처리와후처리가 다 일어남으로, around advice역할을한다. 
		return rev;
	}
	
}
