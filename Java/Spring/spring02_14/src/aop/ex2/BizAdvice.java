package aop.ex2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
//<aop:config>즉, ProxyFactoryBean선언
@Aspect
public class BizAdvice {
	@Before("execution(* aop.ex2.BizServiceImple.*(..))")
	public void beforeMethod() {
		System.out.println("***************");
	}
	
	@AfterReturning(pointcut="execution(* aop.ex2.BizServiceImple.second(..))",
	returning="ret")
	public void myReturnMethod(JoinPoint jp,Object ret) {
		String namev=jp.getSignature().getName();
		System.out.println("name:" +namev);
		System.out.println("반환값:");
		System.out.println(ret);
	}
	
}
